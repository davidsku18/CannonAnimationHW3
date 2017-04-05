package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;


/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class CannonAnimator implements Animator{
    // instance variables
    private int count = 0; // counts the number of logical clock ticks

    // Cannon's initial values
    private int cannonLeft = 0;
    private int cannonTop = 1000;
    private int cannonRight = 600;
    private int cannonBottom = 1250;

    // Ball's velocity when it's fired
    private double velocity=40;

    // Ball's initial values
    private int ballRadius = 40;
    private double angle;
    private double ballXPos = cannonBottom/(Math.tan(-1*angle));
    private double ballYPos = (Math.tan(-1*angle)*(cannonRight));

    private int targetX = 1300;
    private int targetY = 300;

    // Creating our Cannon and Ball objects
    Cannon cannon = new Cannon(cannonLeft, cannonTop, cannonRight, cannonBottom, angle);
    Ball newBall = new Ball(ballXPos, ballYPos, ballRadius, velocity, angle);
    Target target = new Target(0, 0);

    private boolean goBackwards = false; // whether clock is ticking backwards

    /**
     * Interval between animation frames: .03 seconds (i.e., about 33 times
     * per second).
     *
     * @return the time interval between frames, in milliseconds.
     */
    public int interval() { return 1; }

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
        ballXPos = cannonBottom/(Math.tan(-1*angle));
        ballYPos = ((Math.tan(-1*angle))*(cannonRight));

        newBall.drawMe(canvas, count, (int)ballXPos, (int)ballYPos, Math.toDegrees(-1*angle));
        cannon.drawMe(canvas, Math.toDegrees(-1*angle));
        target.drawMe(canvas);

        if (newBall.getBallXPos() >= target.getTargetX() && newBall.getBallYPos() >= target.getTargetY())
        {
            target.targetHit();
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
     * @param event
     *          the event
     */
    public void onTouch(MotionEvent event)
    {
        //if screen is touched the cannon will fire
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            fireCannon();
        }
    }
    /**
     * Creates a new ball and cannon object and resets the count
     * so that the ball can be "fired"
    */
    public void fireCannon()
    {
        count = 0;
        newBall = new Ball(ballXPos, ballYPos, ballRadius, velocity, angle);
        cannon = new Cannon(0, cannonTop, cannonRight, cannonBottom , angle);
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }
}
