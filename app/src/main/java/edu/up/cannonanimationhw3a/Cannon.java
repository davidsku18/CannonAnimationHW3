package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by kurtisdavidson on 4/2/17.
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

    public void setCannonXPos (int newXPos) {
        left = newXPos;
    }

    public void setCannonYPos (int newYPos) {
        top = newYPos;
    }

    public void setCannonAngle (int newAngle) {
        angle = newAngle;
    }

    public int getCannonXPos() {
        return this.left;
    }

    public int getCannonYPos() {
        return this.top;
    }

    public double getCannonAngle() {
        return this.angle;
    }

    public void drawMe(Canvas canvas, double RotationAngle) {
        cannonDefaultPaint.setColor(Color.BLACK);
        centerY = ((bottom-top)/2+top);
        canvas.save();
        canvas.rotate((float)RotationAngle, (float)(left), (float)(centerY));// rotates the cannon's barrel when angle is adjusted
        canvas.drawRect(left, top, right, bottom , cannonDefaultPaint);
        canvas.restore();
    }
}
