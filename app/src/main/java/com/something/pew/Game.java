package com.something.pew;

import android.graphics.RectF;
import android.graphics.Rect;

public class Game {
    private int points;
    private float initialx, initialy, finalx, finaly, framecount, animateframecount, velocityy, velocityx;
    private double velocity, angle;

    public Game(int points) {
        this.points = points;
        framecount = 0;
        animateframecount = 1;
    }

    //Checks to see if the ball's coordinates line up with the hole's.
    //Return 0 if it hits the wall or is out of bounds, 1 if it lines up with the hole, 2 if it's still going.
    public int checkCollision(RectF ball, RectF hole, Rect wall) {
        if(ball.left < wall.left && ball.left > 0 && ball.bottom >= 0 && ball.bottom <= 1750) {
            return 2;
        }
        else if(ball.right >= 950 && ball.top >= hole.top && ball.bottom <= hole.bottom) {
            return 1;
        }
        return 0;
    }

    //Velocity is distance traveled divided by animateframecount
    public void calculateVelocityX() {
        velocityx = (finalx - initialx)/framecount/1.6f;
    }

    public void calculateVelocityY() {
        velocityy = (initialy - finaly)/framecount*3;
    }

    public void incrementFrameCount() {
        framecount++;
    }

    public void incrementAnimateFrameCount() {
        animateframecount+=0.75;
    }

    public void resetFrameCount() {
        framecount = 0;
    }

    public void incrementPoints() {
        points++;
    }

    public void resetPoints() {
        points = 0;
    }

    public void resetAnimateFrameCount() {
        animateframecount = 0;
    }

    public void setInitialX(float pos) {
        initialx = pos;
    }

    public void setInitialY(float pos) {
        initialy = pos;
    }

    public void setFinalX(float pos) {
        finalx = pos;
    }

    public void setFinalY(float pos) {
        finaly = pos;
    }

    public float getFrameCount() {
        return framecount;
    }

    public float getAnimateFrameCount() {
        return animateframecount;
    }

    public float getInitialX() {
        return initialx;
    }

    public float getInitialY() {
        return initialy;
    }

    public float getFinalX() {
        return finalx;
    }

    public float getFinalY() {
        return finaly;
    }

    public float getVelocityY() {
        return velocityy;
    }

    public float getVelocityX() {
        return velocityx;
    }

//    public double getVelocity() {
//        return velocity;
//    }

    public double getAngle() {
        return angle;
    }

    public int getPoints() {
        return points;
    }
}