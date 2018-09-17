package com.something.pew;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {

    Game game;
    Objects objects;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game(0);
        objects = new Objects(this);
        setContentView(objects);
        objects.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                System.out.println("Touch");
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //User presses finger on screen
                    game.resetFrameCount();                             //Resets the framecount for next run so that time is different every time the user sets their finger down and up again
                    System.out.println("\ninitialx:" + event.getX());
                    System.out.println("\ninitialy: " + event.getY());
                    game.setInitialX(event.getX());
                    game.setInitialY(event.getY());
                }
                if(event.getX() != game.getInitialX() || event.getY() != game.getInitialY()) {      //User starts to move finger
                    game.incrementFrameCount();
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {        //User lifts finger off of screen
                    System.out.println("\nTouch Off");
                    game.setFinalX(event.getX());
                    game.setFinalY(event.getY());
                    System.out.println("Final x: " + game.getFinalX());
                    System.out.println("Final y: " + game.getFinalY());
                    game.setTime(game.getFrameCount());                 //Calculates how much time has passed
                    game.calculateVelocityX();
                    game.calculateVelocityY();
                    game.calculateAngle();                            //Calculates the angle that the ball is being sent at
                    System.out.println("\nVelocity Y: " + game.getVelocityY());
                    System.out.println("\nVelocity X: " + game.getVelocityX());
//                    System.out.println("\nAngle: " + game.getAngle());
                    System.out.println("framecount: " + game.getFrameCount());
                    animateBall();
                }
                return true;
            }
        });
    }

    private void animateBall() {
        float newleft = objects.getBall().left + (game.getVelocityX() * game.getFrameCount());
        float newtop = (float)(objects.getBall().top + (1/2)*(9.80)*(game.getFrameCount() + (game.getVelocityY() * game.getFrameCount())));
        float newright = newleft + 100;
        float newbottom = newtop + 100;
        AnimatorSet ballAnimation = new AnimatorSet();
//        System.out.println("newleft: " + newleft);
//        System.out.println("newright: " + newright);
//        System.out.println("newtop: " + newtop);
//        System.out.println("newbottom: " + newbottom);


        ObjectAnimator animateLeft = ObjectAnimator.ofFloat(objects.getBall(), "left", objects.getBall().left, newleft).setDuration(250);
        ObjectAnimator animateRight = ObjectAnimator.ofFloat(objects.getBall(), "right", objects.getBall().right, newright).setDuration(250);
        ObjectAnimator animateTop = ObjectAnimator.ofFloat(objects.getBall(), "top", objects.getBall().top, newtop).setDuration(250);
        ObjectAnimator animateBottom = ObjectAnimator.ofFloat(objects.getBall(), "bottom", objects.getBall().bottom, newbottom).setDuration(250);
//        ObjectAnimator animateArc = ObjectAnimator.ofFloat(objects.getHole(), "left", objects.getHole().left, objects.getHole().left);
//        animateArc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                objects.invalidate();
//            }
//        });
        animateBottom.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                objects.invalidate();
            }
        });
        animateRight.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                objects.invalidate();
            }
        });


        ballAnimation.playTogether(animateLeft, animateRight, animateTop, animateBottom);
        ballAnimation.start();
    }
}
