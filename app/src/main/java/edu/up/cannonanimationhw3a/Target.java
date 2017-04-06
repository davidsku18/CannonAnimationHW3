package edu.up.cannonanimationhw3a;

import android.graphics.Color;

/**
 * Created by kurtisdavidson on 4/4/17.
 */

public class Target extends CircleElement{

    private int targetOuterPaint;
    private int radius = 80;

    public Target ( int x, int y, int radius) {
        super(x, y, radius);

        targetOuterPaint = Color.RED;
        paint.setColor(targetOuterPaint);
    }

    /**
     * Gets the target's x coordinate
     * @return x
     *          the x position
     */
    public int getTargetX() {
        return this.x;
    }

    /**
     * Gets the target's y coordinate
     * @return y
     *          the y position
     */
    public int getTargetY() {
        return this.y;
    }

    /**
     * Determines whether the target was hit and changes
     * the color of the target to yellow if hit
     *
     * @param hit
     *          if the target was hit
     */
    public void hitTarget(boolean hit)
    {
        if(hit)
        {
            targetOuterPaint = Color.YELLOW;
        }
        paint.setColor(targetOuterPaint);
    }

}
