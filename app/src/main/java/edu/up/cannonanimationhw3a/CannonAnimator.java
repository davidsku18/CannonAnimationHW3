package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import java.util.ArrayList;


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
    Cannon cannon = null;
    private int cannonLeft = 0;
    private int cannonTop = 1000;
    private int cannonRight = 200;
    private int cannonBottom = 1200;
    private double angle;

    // Ball's velocity when it's fired
    private int velocity = 60;
    private double gravity;

    // Ball's values
    private int ballRadius = 80;

    // Targets values
    private int targetRadius = 80;

    ArrayList<Target> targets;
    ArrayList<Ball> cannonBalls;

    /**
     * Ctor for creating the cannonBalls and targets array list as
     * well as the cannon object and creating the targets
     */
    public CannonAnimator()
    {
        cannonBalls = new ArrayList<>();
        targets = new ArrayList<>();
        cannon = new Cannon(cannonLeft, cannonTop, cannonRight, cannonBottom, angle);

        createTargets();
    }

    /**
     * Interval between animation frames: .001 seconds (i.e., about 100 times
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
     * Creates out targets and adds them to the array list
     */
    private void createTargets()
    {
        Target target1 = new Target(1300,300, targetRadius);
        Target target2 = new Target(1400,800, targetRadius);
        Target target3 = new Target(1200,1000, targetRadius);
        Target target4 = new Target(1000,400, targetRadius);
        Target target5 = new Target(800,800, targetRadius);

        targets.add(target1);
        targets.add(target2);
        targets.add(target3);
        targets.add(target4);
        targets.add(target5);
    }
    /**
     * Action to perform on clock tick
     *
     * @param canvas the graphics object on which to draw
     */
    public void tick(Canvas canvas) {

        //draws the targets
        count++;
        for (Target t: targets) {
            // checks if targets were hit and changes the targets color
            t.drawMe(canvas);
        }

        for (Ball b : cannonBalls) {
            // checks if ball goes out of the screen and removes it from the array list
            if (b.getX() >= canvas.getWidth() || b.getY() >= canvas.getHeight() || b.getY() <= 0) {
                b = null;
                cannonBalls.remove(b);
            }
            else {
                // drawing our cannonballs
                b.drawMe(canvas, count);
                for (Target t: targets) {
                    // checks if the cannonball hit the target
                    if(b.getX() >= t.getTargetX() - 160 && b.getX() < t.getTargetX() + 160
                            && b.getY() >= t.getTargetY() - 160 && b.getY() < t.getTargetY() + 160) {
                        t.hitTarget(true);
                    }
                }
            }
        }



        // drawing our cannon
        cannon.drawMe(canvas, Math.toDegrees(-1 * angle));
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
        Ball newBall = new Ball(cannon.getCannonCenterX(), cannon.getCannonCenterY(), velocity, angle, ballRadius, gravity);
        cannonBalls.add(newBall);
        count = 0; //resets the count to 0 so that the trajectory can restart
    }

    /**
     * Sets the angle and passes it to the seekBar
     *
     * @param angle
     *          the angle that will be adjusted
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Sets the gravity and passes it to the seekBar
     * @param gravity
     *          the gravity that the user will adjust
     */
    public void setGravity(double gravity) { this.gravity = gravity; }
}
