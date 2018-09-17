package com.something.pew;

public class Game {
    private int points;
    private float initialx, initialy, finalx, finaly, framecount, animateframecount, velocityy, velocityx;
    private double velocity, angle;

    public Game(int points) {
        this.points = points;
        framecount = 0;
        animateframecount = 1;
    }

    //Velocity is distance traveled divided by animateframecount
    public void calculateVelocityX() {
        velocityx = (finalx - initialx)/framecount/1.5f;
    }

    public void calculateVelocityY() {
        velocityy = (finaly - initialy)/framecount*3;
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