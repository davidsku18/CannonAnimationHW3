package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class Ball {

    private double xPos;
    private double yPos;
    private int radius;
    private double velocity;
    private double angle;
    private int negOne = -1;
    private Paint ballPaint = new Paint();


    /**
     * Ctor for our Ball object
     * @param x
     *          the ball's x position
     * @param y
     *          the balls's y position
     * @param radius
     *          the ball's radius
     * @param velocity
     *          the ball's velocity
     * @param initAngle
     *          the ball's angle
     */
    public Ball(double x, double y, int radius, double velocity, double initAngle)
    {
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.velocity = velocity;
        this.angle = initAngle;
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
     * Sets a new y position for the ball
     * @param newVelocity
     *          the ball's new y position
     */
    public void setBallYPos (double newVelocity) {
        velocity = newVelocity;
    }

    /**
     * Gets the ball's current x position
     * @return xPos
     *          the ball's x position
     */
    public double getBallXPos () {
        return this.xPos;
    }

    /**
     * Gets the ball's current y position
     * @return yPos
     *          the ball's y position
     */
    public double getBallYPos() {
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

    public void drawMe(Canvas canvas, int time, int x, int y, double rotationAngle) {
        ballPaint.setColor(Color.BLACK);
        // rotates the canvas about some point
        canvas.save();
        canvas.rotate((float)rotationAngle, (float)x , (float)y);
        canvas.restore();
        this.xPos = (int) (this.xPos + (this.velocity * Math.cos(angle) * (time)));
        this.yPos = (int) (this.yPos + ((this.velocity * Math.sin(angle) * (negOne)) * (time) +
                (0.5 * 7 * (time) * (time))));
        canvas.drawCircle((float) xPos, (float) yPos, radius, ballPaint);
    }
}
