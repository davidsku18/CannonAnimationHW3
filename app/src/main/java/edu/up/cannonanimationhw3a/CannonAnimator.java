package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class CannonAnimator extends CannonMainActivity implements Animator{
    // instance variables
    private int count = 0; // counts the number of logical clock ticks
    int width;
    int height;

    //ArrayList<Ball> balls = new ArrayList<>();
    private int cannonLeft = 0;
    private int cannonTop = 1000;
    private int cannonRight = 400;
    private int cannonBottom = 1200;
    private int touchX;
    private int touchY;

    private double xDisplacement;
    private double yDisplacement;
    private double newXDisplacement;
    private double newYDisplacement;

    private double velocity=40;
    private double ballXVelocity;
    private double ballYVelocity;
    private double ballXAcceleration;
    private double ballYAcceleration;
    private float ballXPos = 50;
    private float ballYPos = 1100;
    private int ballRadius = 40;
    private double angle;
    private float degrees;

    // Creating our Cannon and Ball objects
    Cannon cannon = new Cannon(cannonLeft, cannonTop, cannonRight, cannonBottom, angle);
    Ball newBall = new Ball(cannonRight, cannonBottom, ballRadius, velocity, ballXAcceleration, ballYAcceleration, angle);

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
     * @param canvas the graphics object on which to draw
     */
    public void tick(Canvas canvas) {

        // bump our count either up or down by one, depending on whether
        // we are in "backwards mode".

        count++;

        // Determine the pixel position of our ball.  Multiplying by 15
        // has the effect of moving 15 pixel per frame.  Modding by 600
        // (with the appropriate correction if the value was negative)
        // has the effect of "wrapping around" when we get to either end
        // (since our canvas size is 600 in each dimension).

        newBall.drawMe(canvas, count);
        cannon.drawMe(canvas, (-60)*angle);
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
            fireCannon();
        }

    }
/*
    public void pivotCannon (View view, float pivotX, float pivotY){
        if (view.getPivotX() == pivotX && view.getPivotY() == pivotY) {
            return;
        }

        float[] prevPoint = { 0.0f, 0.0f };
        view.getMatrix().mapPoints(prevPoint);

        view.setPivotX(pivotX);
        view.setPivotY(pivotY);

        float[] currPoint = { 0.0f, 0.0f };
        view.getMatrix().mapPoints(currPoint);

        float offsetX = currPoint[0] - prevPoint[0];
        float offsetY = currPoint[1] - prevPoint[1];

        view.setTranslationX(view.getTranslationX() - offsetX);
        view.setTranslationY(view.getTranslationY() - offsetY);

    }

    public void rotate(double angle) {
        if ((angle <= Math.toRadians(90) && degrees > 0) || (angle >= -Math.toRadians(90) && degrees < 0)) {
            Matrix newMatrix = new Matrix();
            newMatrix.setRotate(degrees, 0, cannonpivotY);
            cannon.transform(newMatrix);
            rotate += degrees;
        }
    }
    */
    public void fireCannon()
    {
        count = 0;
        newBall = new Ball(cannonRight, cannonBottom, ballRadius, velocity, ballXAcceleration, ballYAcceleration, angle);
        cannon = new Cannon(0, cannonTop, cannonRight, cannonBottom , -(1)*angle);
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }
}
