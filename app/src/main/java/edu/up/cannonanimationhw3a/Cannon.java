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
    private int centerX;
    private int centerY;
    private int xNew;
    private int yNew;
    private double angle;
    private Paint cannonDefaultPaint = new Paint();
    private Paint cannonWheel = new Paint();

    public Cannon(int left, int top, int right, int bottom, double initAngle) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.angle = initAngle;
        centerX = ((right-left)/2) + left;
        centerY = ((bottom-top)/2) + top;
    }

    public int getCannonCenterX() {
        xNew = this.left * (int)Math.cos(this.angle) - (this.top+70) * (int)Math.sin(this.angle);
        return this.xNew;
    }


    public int getCannonCenterY() {
        yNew = (this.top+70) * (int)Math.cos(this.angle) + this.left * (int)Math.sin(this.angle);
        return this.yNew;
    }
    /**
     * Draws the cannon with it's adjusted angle
     * @param canvas
     */
    public void drawMe(Canvas canvas, double RotationAngle) {
        cannonDefaultPaint.setColor(Color.BLACK);
        cannonWheel.setColor(0xFF774F00);
        centerY = ((bottom-top)/2+top);
        canvas.save();
        canvas.rotate((float)RotationAngle, (float)(left), (float)(centerY));// rotates the cannon's barrel when angle is adjusted
        canvas.rotate((float)this.angle * -1, (float)(left), (float)(centerY));// rotates the cannon's barrel when angle is adjusted
        canvas.drawRect(left, top, right, bottom , cannonDefaultPaint);
        canvas.restore();
        canvas.drawCircle(0,bottom-50,80,cannonWheel);
    }
}
