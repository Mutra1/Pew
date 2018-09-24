package com.something.pew;

import android.graphics.RectF;
import android.graphics.Rect;

public class Game {
    private float initialx, initialy, finalx, finaly, framecount, animateframecount, velocityy, velocityx;
    private int width, height;

    public Game(int pwidth, int pheight) {
        framecount = 0;
        animateframecount = 1;
        width = pwidth;
        height = pheight;
    }

    //Checks to see if the ball's coordinates line up with the hole's.
    //Return 0 if it hits the wall or is out of bounds, 1 if it lines up with the hole, 2 if it's still going.
    public int checkCollision(RectF ball, RectF hole, Rect wall) {
        if(ball.right < wall.left && ball.left > 0 && ball.bottom <= height) {
            return 3;
        }

        else if(ball.right >= wall.left+(width*.0342962963) && ball.bottom >= hole.top/*-(height*.002)*/ && ball.bottom <= hole.bottom/*-(height*.008361204)*/) {
            return 2;
        }

        else if((ball.right >= wall.left-(width*.0462962963) || ball.left <= 0) && ball.bottom < height) {
            return 1;
        }

        if(ball.top >= 1500) {
            return 0;
        }
        return 0;
    }

    //Velocity is distance traveled divided by animateframecount
    public void calculateVelocityX() {
        velocityx = (finalx - initialx)/framecount/1.15f;
    }

    public void calculateVelocityY() {
        velocityy = (initialy - finaly)/framecount*3;
    }

    //Reverses the velocity of X when bouncing on wall.
    public void reverseVelocityX() {
        velocityx *= -1;
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

    public float getVelocityY() {
        return velocityy;
    }

    public float getVelocityX() {
        return velocityx;
    }

//    public double getVelocity() {
//        return velocity;
//    }
}