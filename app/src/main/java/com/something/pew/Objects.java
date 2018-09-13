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
    private RectF hole, ball;
    private Paint rectpaint, ballpaint, holepaint;


    public Objects(Context context) {
        super(context);
        rectangle = new Rect(950, 0, 1100 ,5000); //Make rectangle BIG BOI
        ball = new RectF(100, 700, 200, 800);
        hole = new RectF(975, 600, 1075, 750);
        rectpaint = new Paint();
        ballpaint = new Paint();
        rectpaint.setColor(Color.BLACK);
        ballpaint.setColor(Color.BLUE);
        holepaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(rectangle, rectpaint);
        canvas.drawOval(ball, ballpaint);
        canvas.drawOval(hole, ballpaint);
    }




    //Animating ball: https://stackoverflow.com/questions/16932668/how-can-we-define-dynamicin-parabola-curve-path-of-viewobjectbitmap
    //Create line for ball to follow, then have ball follow line
}
