package com.something.pew;

public class Game {
    private int points;
    private float initialx, initialy, finalx, finaly, framecount, time, velocityx, velocityy, velocity;

    //Time is measured as sec/60frames
    public Game(int points) {
        this.points = points;
        framecount = 0;
        time = 0;
    }

    //Velocity is distance traveled divided by time
    public void calculateVelocityX() {
        velocityx = (finalx - finaly)/time;
    }

    public void calculateVelocityY() {
        velocityy = (finaly - initialy)/time;
    }

    //Velocity is squareroot of velocityx^2 + velocityy^2
    public void calculateVelocity() {
//        velocity = Math.sqrt
    }

    //Sets VelocityY to something else during ball travel, gravity will change it
    public void setVelocityY(float newvelocityy) {
        velocityy = newvelocityy;
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

    public float getVelocityX() {
        return velocityx;
    }

    public float getVelocityY() {
        return velocityy;
    }

    public float getVelocity() {
        return velocity;
    }

    public int getPoints() {
        return points;
    }
}