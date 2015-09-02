package com.games.evdoo.pinballgame;

public class Ball {

    private double WIDTH;
    private double HEIGHT;
    private double INIT_X;
    private double INIT_Y;
    private double ballSpeed;
    private double x;
    private double y;
    private double angleCos;
    private double angleSin;

    public Ball() {
        this.x = INIT_X;
        this.y = INIT_Y;
        this.ballSpeed = Math.random();

        double angle = Math.random() * 2 * Math.PI;
        this.angleSin = Math.sin(angle);
        this.angleCos = Math.cos(angle);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.ballSpeed = speed;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getBallSpeed() {
        return this.ballSpeed;
    }

    public void bounce(double wallX1, double wallY1, double wallX2, double wallY2) {
        double ballX = this.x;
        double ballY = this.y;
        double wallX;
        double wallY;

        if ((wallX1 == ballX) && (wallY1 == ballY)) {
            wallX = wallX2;
            wallY = wallY2;
        } else if ((wallX2 == ballX) && (wallY2 == ballY)) {
            wallX = wallX1;
            wallY = wallY1;
        } else if (Math.abs(wallX1 - ballX) < Math.abs(wallX2 - ballX)) {
            wallX = wallX2;
            wallY = wallY2;
        } else {
            wallX = wallX1;
            wallY = wallY1;
        }

        double wallVectorX = wallX - ballX;
        double wallVectorY = wallY - ballY;
        double singleVectorX = wallVectorX / Math.sqrt(wallVectorX * wallVectorX + wallVectorY * wallVectorY);
        double singleVectorY = wallVectorY / Math.sqrt(wallVectorX * wallVectorX + wallVectorY * wallVectorY);

        double k = singleVectorX;
        singleVectorX = singleVectorY;
        singleVectorY = -k;

        double scalarProduct = wallVectorX * singleVectorX + wallVectorY * singleVectorY;

        double changedMotionVectorX = -2 * scalarProduct * singleVectorX;
        double changedMotionVectorY = -2 * scalarProduct * singleVectorY;

        this.angleCos = this.angleCos + changedMotionVectorX;
        this.angleSin = this.angleSin + changedMotionVectorY;
    }
}