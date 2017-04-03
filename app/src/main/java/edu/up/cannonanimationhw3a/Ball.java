package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class Ball extends CustomElement{

    private float xPos;
    private float yPos;
    private int radius;
    private double xVelocity;
    private double yVelocity;
    private double xAcceleration;
    private double yAcceleration;
    private Paint ballPaint = new Paint();

    public Ball(String name, int color, float x, float y,  int radius, double initXVel,
                double initYVal, double initXAccel, double initYAccel)
    {
        super(name, color);

        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.xVelocity = initXVel;
        this.yVelocity = initYVal;
        this.xAcceleration = initXAccel;
        this.yAcceleration = initYAccel;
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
     * Sets a new velocity for the ball
     * @param newXVelocity
     *          the ball's new x velocity
     */
    public void setBallXVelocity(int newXVelocity) {
        xVelocity = newXVelocity;
    }

    /**
            * Sets a new velocity for the ball
     * @param newYVelocity
     *          the ball's new y velocity
            */
    public void setBallYVelocity(int newYVelocity) {
        yVelocity = newYVelocity;
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
    public double getBallXPos () {
        return xPos;
    }

    /**
     * Gets the ball's current y position
     * @return yPos
     *          the ball's y position
     */
    public double getBallYPos() {
        return yPos;
    }

    /**
     * Gets the ball's current x velocity
     * @return velocity
     *          the ball's velocity
     */
    public double getBallXVelocity() {
        return xVelocity;
    }

    /**
     * Gets the ball's current y velocity
     * @return velocity
     *          the ball's velocity
     */
    public double getBallYVelocity() {
        return yVelocity;
    }

    /**
     * Gets the ball's current x acceleration
     * @return acceleration
     *          the ball's acceleration
     *
     */
    public double getBallXAcceleration() {
        return xAcceleration;
    }

    /**
     * Gets the ball's current y acceleration
     * @return acceleration
     *          the ball's acceleration
     *
     */
    public double getBallYAcceleration() {
        return yAcceleration;
    }

    public void move (int dt) {
        // update position
        xPos += xVelocity;
        yPos += yVelocity;

        // v = v0 + a * dt
        xVelocity += xAcceleration * dt;
        yVelocity+= yAcceleration * dt;


    }

    public boolean containsPoint(int x, int y) {
        //Calculate the distance between this point and the center
        int xDist = Math.abs(x - (int)(this.xPos));
        int yDist = Math.abs(y - (int)(this.yPos));
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

        return (dist < this.radius + TAP_MARGIN);
    }//contaisPoint

    public void drawMe(Canvas canvas) {
        canvas.drawCircle(xPos, yPos, radius, ballPaint);  //main circle
    }
}
