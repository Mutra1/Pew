package com.something.pew;

import android.annotation.SuppressLint;
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
                    System.out.println("increment");
                    game.incrementFrameCount();
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {        //User lifts finger off of screen
                    System.out.println("\nTouch Off");
                    System.out.println("\nFinal X: " + event.getX());
                    System.out.println("\nFinal Y: " + event.getY());
                    game.setFinalX(event.getX());
                    game.setFinalY(event.getY());
                    game.setTime(game.getFrameCount());                 //Calculate how much time has passed
                    System.out.println("\nFramecount: " + game.getFrameCount());
                    System.out.println("\nTime: " + game.getTime());
                    game.resetFrameCount();                             //Reset framecount for next run
                }
                return true;
            }
        });
    }
}
