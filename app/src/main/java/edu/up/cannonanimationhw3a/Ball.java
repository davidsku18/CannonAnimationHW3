package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class Ball {

    private int xPos;
    private int yPos;
    private int radius;
    private double velocity;
    private double xAcceleration;
    private double yAcceleration;
    private double angle;
    private int negOne = -1;
    private Paint ballPaint = new Paint();

    public Ball(int x, int y, int radius, double velocity, double initXAccel, double initYAccel, double initAngle)
    {
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.velocity = velocity;
        this.xAcceleration = initXAccel;
        this.yAcceleration = initYAccel;
        this.angle = initAngle;
    }

    /**
     * Sets a new acceleration for the ball
     * @param newXAcceleration
     *          the ball's new acceleration
     */
    public void setBallXAcceleration(double newXAcceleration) {
        xAcceleration = newXAcceleration;
    }

    /**
     * Sets a new acceleration for the ball
     * @param newYAcceleration
     *          the ball's new acceleration
     */
    public void setBallYAcceleration(double newYAcceleration) {
        yAcceleration = newYAcceleration;
    }

    /**
     * Sets a new x position for the ball
     * @param newXPos
     *          the ball's new x position
     */
    public void setBallXPos (int newXPos) {
        xPos = newXPos;
    }

    /**
     * Sets a new y position for the ball
     * @param newYPos
     *          the ball's new y position
     */
    public void setBallYPos (int newYPos) {
        yPos = newYPos;
    }

    /**
     * Gets the ball's current x position
     * @return xPos
     *          the ball's x position
     */
    public int getBallXPos () {
        return this.xPos;
    }

    /**
     * Gets the ball's current y position
     * @return yPos
     *          the ball's y position
     */
    public int getBallYPos() {
        return this.yPos;
    }

    /**
     * Gets the ball's current velocity
     * @return velocity
     *          the ball's velocity
     */
    public double getVelocity() {
        return this.velocity;
    }

    /**
     * Gets the ball's current x acceleration
     * @return acceleration
     *          the ball's acceleration
     *
     */
    public double getBallXAcceleration() {
        return this.xAcceleration;
    }

    /**
     * Gets the ball's current y acceleration
     * @return acceleration
     *          the ball's acceleration
     *
     */
    public double getBallYAcceleration() {
        return this.yAcceleration;
    }

    public void drawMe(Canvas canvas, int time) {
        this.xPos = (int) (this.xPos + (this.velocity * Math.cos(angle) * (time)));
        this.yPos = (int) (this.yPos + ((this.velocity * Math.sin(angle) * (negOne)) * (time) +
                (0.5 * 7 * (time) * (time))));
        ballPaint.setColor(Color.BLACK);
        canvas.rotate((float)angle, (float) xPos, (float) yPos );
        canvas.drawCircle(xPos, yPos, radius, ballPaint);  //main circle
    }
}
