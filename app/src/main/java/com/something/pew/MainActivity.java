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
import android.view.animation.PathInterpolator;

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
                    game.resetAnimateFrameCount();
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
                    game.calculateVelocityX();
                    game.calculateVelocityY();
                    System.out.println("\nVelocity Y: " + game.getVelocityY());
                    System.out.println("\nVelocity X: " + game.getVelocityX());
//                    System.out.println("\nAngle: " + game.getAngle());
                    System.out.println("framecount: " + game.getFrameCount());
                    if(game.getFrameCount() != 0 && game.getAnimateFrameCount() == 0) {
                        animateBall();
                    }
                }
                return true;
            }
        });
    }

    private void animateBall() {
//        System.out.println("newleft: " + newleft);
//        System.out.println("newright: " + newright);
//        System.out.println("newtop: " + newtop);
//        System.out.println("newbottom: " + newbottom);

        setTimeout(25, new Runnable() {
            @Override
            public void run() {
                System.out.println("Animating");
                float newleft = objects.getBall().left + (game.getVelocityX() * game.getAnimateFrameCount());
                float newtop = (float)(objects.getBall().top + ((3)*game.getAnimateFrameCount()) - (game.getVelocityY() * game.getAnimateFrameCount()));
                System.out.println("newtop: " + newtop);
                objects.getBall().set(newleft, newtop, newleft+100, newtop+100);
                setContentView(objects);
                if(game.getAnimateFrameCount() < game.getFrameCount()) {
                    game.incrementAnimateFrameCount();
                    animateBall();
                }
            }
        });

    }

    public void setTimeout(final int delay, Runnable function) {
        new android.os.Handler().postDelayed(function, delay);
    }
}
