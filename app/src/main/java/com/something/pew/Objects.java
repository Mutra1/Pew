package com.something.pew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class Objects extends View {
    private Rect rectangle;
    private RectFAnimate hole, ball;
    private Paint rectpaint, ballpaint, holepaint;


    public Objects(Context context) {
        super(context);
        int ballxstart = (int)(Math.random() * 100) + 50;
        int ballystart = (int)(Math.random() * 800) + 200;
        float holestart = (float)(Math.random() * 1000) + 250;
        System.out.println("ballxstart: " + ballxstart);
        System.out.println("ballystart: " + ballystart);
        System.out.println("holestart: " + holestart);
        rectangle = new Rect(950, 0, 1100 ,5000);
        ball = new RectFAnimate(ballxstart, ballystart, ballxstart+100, ballystart+100);
        hole = new RectFAnimate(750, holestart-100, 1050, holestart + 150);
        rectpaint = new Paint();
        ballpaint = new Paint();
        holepaint = new Paint();
        rectpaint.setColor(Color.BLACK);
        ballpaint.setColor(Color.BLUE);
        holepaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(rectangle, rectpaint);
        canvas.drawOval(ball, ballpaint);
        canvas.drawArc(hole.left, hole.top, hole.right, hole.bottom, -120, 170, true, holepaint);
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public RectFAnimate getHole() {
        return hole;
    }

    public RectFAnimate getBall() {
        return ball;
    }


    //Animating ball: https://stackoverflow.com/questions/16932668/how-can-we-define-dynamicin-parabola-curve-path-of-viewobjectbitmap
    //Create line for ball to follow, then have ball follow line
}
