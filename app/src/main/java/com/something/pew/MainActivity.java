package com.something.pew;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Game game;
    private Objects objects;
    private Button resetButton;
    private TextView textResults;
    private DisplayMetrics dm;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //FLAG FULLSCREEN
        super.onCreate(savedInstanceState);
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        game = new Game(dm.widthPixels, dm.heightPixels);
        objects = new Objects(this, dm.widthPixels, dm.heightPixels);
        setContentView(objects);
        objects.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //User presses finger on screen
                    game.resetAnimateFrameCount();
                    game.resetFrameCount();                             //Resets the framecount for next run so that time is different every time the user sets their finger down and up again
                    game.setInitialX(event.getX());
                    game.setInitialY(event.getY());
                }
                if(event.getX() != game.getInitialX() || event.getY() != game.getInitialY()) {      //User starts to move finger
                    game.incrementFrameCount();
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {        //User lifts finger off of screen
                    game.setFinalX(event.getX());
                    game.setFinalY(event.getY());
                    game.calculateVelocityX();
                    game.calculateVelocityY();
                    if(game.getFrameCount() != 0 && game.getAnimateFrameCount() == 0) {
                        animateBall();
                    }
                }
                return true;
            }
        });
    }

    private void animateBall() {
        setTimeout(40, new Runnable() {
            @Override
            public void run() {
                float newleft = objects.getBall().left + (game.getVelocityX()*2);
                float newtop = (objects.getBall().top + ((6f)*(7.25f*game.getAnimateFrameCount())) - (game.getVelocityY()));
                objects.getBall().set(newleft, newtop, newleft+(dm.widthPixels * .0925925926f), newtop+(dm.heightPixels * .0557413601f));
                setContentView(objects);

                //Checks to see if the ball has hit the wall, entered the hole, or hasn't done either.
                //If it hasn't done either, ignore.
                if(game.checkCollision(objects.getBall(), objects.getHole(), objects.getRectangle()) == 3) {
                    game.incrementAnimateFrameCount();
                    animateBall();
                }
                else if(game.checkCollision(objects.getBall(), objects.getHole(), objects.getRectangle()) == 2) {
                    //Win the game
                    setTimeout(150, new Runnable() {
                        @Override
                        public void run() {
                            setContentView(R.layout.activity_main);
                            resetButton = findViewById(R.id.resetButton);
                            textResults = findViewById(R.id.textResults);
                            textResults.setText("You Win!");
                            resetButton.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    resetGame();
                                }
                            });
                        }
                    });
                }

                else if(game.checkCollision(objects.getBall(), objects.getHole(), objects.getRectangle()) == 1) {
                    game.reverseVelocityX();
                    game.incrementAnimateFrameCount();
                    animateBall();
                }

                else {
                    //Lose the game
                    setTimeout(150, new Runnable() {
                        @Override
                        public void run() {
                            setContentView(R.layout.activity_main);
                            resetButton = findViewById(R.id.resetButton);
                            textResults = findViewById(R.id.textResults);
                            textResults.setText("You Lose!");
                            resetButton.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    resetGame();
                                }
                            });
                        }
                    });
                }
            }
        });

    }

    @SuppressLint("ClickableViewAccessibility")
    private void resetGame() {
        objects = new Objects(this, dm.widthPixels, dm.heightPixels);
        setContentView(objects);
        objects.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //User presses finger on screen
                    game.resetAnimateFrameCount();
                    game.resetFrameCount();                             //Resets the framecount for next run so that time is different every time the user sets their finger down and up again
                    game.setInitialX(event.getX());
                    game.setInitialY(event.getY());
                }
                if(event.getX() != game.getInitialX() || event.getY() != game.getInitialY()) {      //User starts to move finger
                    game.incrementFrameCount();
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {        //User lifts finger off of screen
                    game.setFinalX(event.getX());
                    game.setFinalY(event.getY());
                    game.calculateVelocityX();
                    game.calculateVelocityY();
                    if(game.getFrameCount() != 0 && game.getAnimateFrameCount() == 0) {
                        animateBall();
                    }
                }
                return true;
            }
        });
    }

    public void setTimeout(final int delay, Runnable function) {
        new android.os.Handler().postDelayed(function, delay);
    }
}
