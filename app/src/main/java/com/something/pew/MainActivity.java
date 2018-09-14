package com.something.pew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Game game;
    Objects objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game(0);
        objects = new Objects(this);
        setContentView(objects);
    }


}
