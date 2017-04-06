package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Our Cannon object
 *
 * @author Kurtis Davidson
 * @version 4/5/2017
 */

public class Cannon {
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int centerY;
    private double angle;
    private Paint cannonDefaultPaint = new Paint();

    public Cannon(int left, int top, int right, int bottom, double initAngle) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.angle = initAngle;
    }

    /**
     * Draws the cannon with it's adjusted angle
     * @param canvas
     * @param RotationAngle
     */
    public void drawMe(Canvas canvas, double RotationAngle) {
        cannonDefaultPaint.setColor(Color.BLACK);
        centerY = ((bottom-top)/2+top);
        canvas.save();
        canvas.rotate((float)RotationAngle, (float)(left), (float)(centerY));// rotates the cannon's barrel when angle is adjusted
        canvas.drawRect(left, top, right, bottom , cannonDefaultPaint);
        canvas.restore();
    }
}
