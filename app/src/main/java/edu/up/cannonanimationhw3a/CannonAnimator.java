package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;


/**
 * Animates the ball when the ball is fired from the cannon
 *
 * @author kurtisdavidson
 * @version 4/2/17.
 */

public class CannonAnimator implements Animator {
    // instance variables
    private int count = 0; // counts the number of logical clock ticks

    // Cannon's initial values
    private int cannonLeft = -40;
    private int cannonTop = 1000;
    private int cannonRight = 600;
    private int cannonBottom = 1200;

    // Ball's velocity when it's fired
    private double velocity = 60;

    // Ball's initial values
    private int ballRadius = 80;
    private double angle;
    private int ballXPos = 0;
    private int ballYPos = 1000;

    // Targets values
    private int targetX = 1300;
    private int targetY = 300;
    private int target2X = 1300;
    private int target2Y = 800;
    private int targetRadius = 80;

    // Creating our Cannon and Ball objects
    Cannon cannon = new Cannon(cannonLeft, cannonTop, cannonRight, cannonBottom, angle);
    Ball newBall = new Ball(ballXPos, ballYPos, ballRadius, velocity, angle);
    Target target = new Target(targetX, targetY, targetRadius);
    Target target2 = new Target(target2X, target2Y, targetRadius);

    /**
     * Interval between animation frames: .03 seconds (i.e., about 33 times
     * per second).
     *
     * @return the time interval between frames, in milliseconds.
     */
    public int interval() {
        return 1;
    }

    /**
     * The background color: a light blue.
     *
     * @return the background color onto which we will draw the image.
     */
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(180, 200, 255);
    }

    /**
     * Action to perform on clock tick
     *
     * @param canvas the graphics object on which to draw
     */
    public void tick(Canvas canvas) {
        count++;

        // drawing our objects
        target.drawMe(canvas);
        target2.drawMe(canvas);
        newBall.drawMe(canvas, count, Math.toDegrees(-1 * angle));
        cannon.drawMe(canvas, Math.toDegrees(-1 * angle));

        // checks if targets were hit and changes the targets color
        if (newBall.getX() >= targetX-160 && newBall.getX() < targetX + 160
                && newBall.getY() >= targetY-160 && newBall.getY() < targetY + 160) {
            target.hitTarget(true);
        } else if (newBall.getX() >= target2X-160 && newBall.getX() < target2X + 160
                && newBall.getY() >= target2Y-160 && newBall.getY() < target2Y + 160) {
            target2.hitTarget(true);
        }
    }

    /**
     * Tells that we never pause.
     *
     * @return indication of whether to pause
     */
    public boolean doPause() {
        return false;
    }

    /**
     * Tells that we never stop the animation.
     *
     * @return indication of whether to quit.
     */
    public boolean doQuit() {
        return false;
    }

    /**
     * fire the ball when the screen is tapped
     *
     * @param event the event
     */
    public void onTouch(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // do nothing
        }
    }

    /**
     * Creates a new ball and cannon object and resets the count
     * so that the ball can be "fired"
     */
    public void fireCannon() {
        count = 0;
        newBall = new Ball(ballXPos, ballYPos, ballRadius, velocity, angle);
        target = new Target(targetX, targetY, targetRadius);
        target2 = new Target(target2X, target2Y, targetRadius);
        cannon = new Cannon(cannonLeft, cannonTop, cannonRight, cannonBottom, angle);
    }

    /**
     * Sets the angle and passes it to the seekBar
     *
     * @param angle the angle that will be adjusted
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }
}
