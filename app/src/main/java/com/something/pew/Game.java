package com.something.pew;

public class Game {
    private int points;
    private float initialx, initialy, finalx, finaly, framecount, time, velocityy, velocityx;
    private double velocity, angle;

    //Time is measured as sec/60frames
    public Game(int points) {
        this.points = points;
        framecount = 0;
        time = 0;
    }

    //Velocity is distance traveled divided by time
    public void calculateVelocityX() {
        velocityx = (finalx - initialx)/framecount/1.5f;
    }

    public void calculateVelocityY() {
        velocityy = (finaly - initialy)/framecount*3;
    }

    //Velocity is squareroot of velocityx^2 + velocityy^2
//    public void calculateVelocity() {
//        calculateVelocityX();
//        calculateVelocityY();
//        velocity = Math.sqrt(Math.pow(velocityx, 2) + Math.pow(velocityy, 2));
//    }

    //Calculates the angle the ball is being sent in
    public void calculateAngle() {
        angle = Math.toDegrees(Math.asin(velocityy/velocity));
    }

    public void incrementFrameCount() {
        framecount++;
    }

    public void resetFrameCount() {
        framecount = 0;
    }

    public void setTime(float frames) {
        time = frames/60;
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

    public float getTime() {
        return time;
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