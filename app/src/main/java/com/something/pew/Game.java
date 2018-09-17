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
        System.out.println("ballleft: " + ball.left);
        System.out.println("balltop: " + ball.top);
        System.out.println("ballbottom: " + ball.bottom);
        System.out.println("wallleft: " + wall.left);
        if(ball.left < wall.left && ball.left > 0 && ball.top >= 0 && ball.bottom <= 1750) {
            return 2;
        }
        else if(ball.right >= (hole.right - (hole.width()*0.4)) && ball.top <= hole.top && ball.bottom >= hole.bottom) {
            return 1;
        }
        return 0;
    }

    //Velocity is distance traveled divided by animateframecount
    public void calculateVelocityX() {
        velocityx = (finalx - initialx)/framecount/2.5f;
    }

    public void calculateVelocityY() {
        velocityy = (initialy - finaly)/framecount*3;
    }

    public void incrementFrameCount() {
        framecount++;
    }

    public void incrementAnimateFrameCount() {
        animateframecount++;
    }

    public void resetFrameCount() {
        framecount = 0;
    }

    public void resetAnimateFrameCount() {
        animateframecount = 0;
    }

    public void setPoints(int points) {
        this.points = points;
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