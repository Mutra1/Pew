package com.something.pew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Objects extends View {
    private Rect rectangle;
    private RectF hole, ball;
    private Paint rectpaint, ballpaint, holepaint;
    private List<Integer> paintList = new ArrayList<Integer>();


    public Objects(Context context, int width, int height) {
        super(context);
        float ballxstart = (float)(Math.random() * (width*.0925925926)) + (width*.0462962963f);
        float ballystart = (float)(Math.random() * (height*.5574136009)) + (height*.1114827202f);
        float holestart = (float)(Math.random() * (height*.5574136009)) + (height*.1114827202f);
        System.out.println("ballxstart: " + ballxstart);
        System.out.println("ballystart: " + ballystart);
        rectangle = new Rect((int)(width*.8564814815), 0, width ,5000);
        ball = new RectF(ballxstart, ballystart, ballxstart+(width * 0.0925925926f), ballystart+(height*.0557413601f));
        hole = new RectF((width*.69444444444f), holestart-(height*.1393534002f), width, holestart + (height*.1393534002f));
        rectpaint = new Paint();
        ballpaint = new Paint();
        holepaint = new Paint();
        paintList.add(Color.BLUE);
        paintList.add(Color.DKGRAY);
        paintList.add(0xFFEE590F);
        paintList.add(0xFF471C07);
        paintList.add(Color.RED);
        paintList.add(0xFF074707);
        paintList.add(0xFF1B6389);
        paintList.add(0xFFAE135B);
        paintList.add(0xFF6E03AE);
        paintList.add(0xFFBFBA1C);
        rectpaint.setColor(paintList.get((int)(Math.random()*(paintList.size()-1))));
        ballpaint.setColor(paintList.get((int)(Math.random()*(paintList.size()-1))));
        holepaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(rectangle, rectpaint);
        canvas.drawArc(hole.left, hole.top, hole.right, hole.bottom, -120, 170, true, holepaint);
        canvas.drawOval(ball, ballpaint);
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public RectF getHole() {
        return hole;
    }

    public RectF getBall() {
        return ball;
    }


    //Animating ball: https://stackoverflow.com/questions/16932668/how-can-we-define-dynamicin-parabola-curve-path-of-viewobjectbitmap
    //Create line for ball to follow, then have ball follow line
}
