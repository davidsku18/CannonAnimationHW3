package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Our Cannon circle element class which defines
 * the location of the element
 *
 * @author Kurtis Davidson
 * @version 4/5/2017
 */

public class CircleElement {
    protected Paint paint = new Paint();
    protected int color;
    protected int radius;
    protected int x;
    protected int y;

    /**
     * Parent ctor for Target
     * @param initX
     *          the X coordinate
     * @param initY
     *          the y coordinate
     * @param radius
     *          the radius
     */
    public CircleElement(int initX, int initY, int radius)
    {
        this.x = initX;
        this.y = initY;
        this.radius = radius;
    }

    /**
     * Draws the circle at a specified point with a
     * specified radius and paint
     *
     * @param canvas
     *          the canvas
     */
    public void drawMe(Canvas canvas)
    {
        canvas.drawCircle(x,y,radius, paint);
    }

}