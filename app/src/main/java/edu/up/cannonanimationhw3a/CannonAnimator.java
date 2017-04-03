package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class CannonAnimator extends CannonMainActivity implements Animator{
    // instance variables
    private int count = 0; // counts the number of logical clock ticks

    ArrayList<Ball> balls = new ArrayList<Ball>();

    private int cannonLeft = 0;
    private int cannonTop = 1400;
    private int cannonRight = 200;
    private int cannonBottom = 1500;
    private int cannonAngle = getAngle();

    private float xDisplacement;
    private float yDisplacement;

    private double ballXVelocity;
    private double ballYVelocity;
    private double ballXAcceleration;
    private double ballYAcceleration;
    private float ballXPos = xDisplacement;
    private float ballYPos = yDisplacement;
    private int ballRadius = 20;

    private double gravity = 9.81;


    // Creating our Cannon and Ball objects
    Cannon cannon = new Cannon("The Cannon", Color.BLACK, cannonLeft, cannonTop, cannonRight, cannonBottom, cannonAngle);
    Ball ball = new Ball("The Cannon's ball", Color.RED, ballXPos, ballYPos, ballRadius, ballXVelocity,
            ballYVelocity, ballXAcceleration, ballYAcceleration);
    private boolean goBackwards = false; // whether clock is ticking backwards

    /**
     * Interval between animation frames: .03 seconds (i.e., about 33 times
     * per second).
     *
     * @return the time interval between frames, in milliseconds.
     */
    public int interval() { return 30; }

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
     * Tells the animation whether to go backwards.
     *
     * @param b true iff animation is to go backwards.
     */
    public void goBackwards(boolean b) {
        // set our instance variable
        goBackwards = b;
    }

    /**
     * Action to perform on clock tick
     *
     * @param g the graphics object on which to draw
     */
    public void tick(Canvas g) {
        // bump our count either up or down by one, depending on whether
        // we are in "backwards mode".
        if (goBackwards) {
            count--;
        }
        else {
            count++;
        }

        // Determine the pixel position of our ball.  Multiplying by 15
        // has the effect of moving 15 pixel per frame.  Modding by 600
        // (with the appropriate correction if the value was negative)
        // has the effect of "wrapping around" when we get to either end
        // (since our canvas size is 600 in each dimension).
        xDisplacement = (count*15)%2000;
        if (xDisplacement < 0) xDisplacement += 2000;

        yDisplacement = (count*15)%2000;
        if (yDisplacement < 0) yDisplacement += 2000;

        for ( int i = 0; i < balls.size(); ++i) {
            balls.add(ball);
        }

        // Draw the ball in the correct position.

        //gets ball's xVelocity

        ball.setBallXAcceleration(10);
        ball.setBallYAcceleration(10);

        onDraw(g);
        /*
        if (ball.getBallYVelocity() == 0)
        {
            ball.setBallYAcceleration(-9.81);
            onDraw(g);
        }
        */
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
     * reverse the ball's direction when the screen is tapped
     */
    public void onTouch(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            goBackwards = !goBackwards;
        }
    }

    /**
     * Prints the cannon and ball
     * @param canvas
     *          The canvas
     */
    public void onDraw (Canvas canvas)
    {
        for(Ball b : balls)
        {
            b.move(count);
            b.drawMe(canvas);
        }
        canvas.rotate(cannonAngle);
        cannon.drawMe(canvas);
        ball.drawMe(canvas);
    }
}
