package com.something.pew;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

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
                if(event.getAction() == MotionEvent.ACTION_DOWN) {      //User presses finger on screen
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
//                    game.calculateAngle();                            //Calculates the angle that the ball is being sent at
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
        float newleft = 0;
        float newtop = 0;
        float newright = 0;
        float newbottom = 0;

       for(float t = 1; objects.getBall().left < 2000; t+=t+.01) {
           System.out.println("\nballleft: " + objects.getBall().left);
           newleft = objects.getBall().left + (game.getVelocityX()*t);
           newtop = (float)(objects.getBall().top + (float)(1/2)*(98.0)*(t) + (game.getVelocityY() * t));
           newright = newleft + 100;
           newbottom = newtop + 100;
           System.out.println("\nnewleft: " + newleft);
           System.out.println("\nnewtop: " + newtop);
           objects.getBall().set(newleft, newtop, newright, newbottom);

       }

        game.resetFrameCount();                             //Resets the framecount for next run so that time is different every time the user sets their finger down and up again
    }
}
