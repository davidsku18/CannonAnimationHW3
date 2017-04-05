package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class Cannon {
    private int left;
    private int top;
    private int right;
    private int bottom;
    private double angle;
    private Paint cannonDefaultPaint = new Paint();
    protected Rect myCannon;

    public Cannon(int left, int top, int right, int bottom, double initAngle) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        angle = initAngle;
        this.myCannon = new Rect(left, top, right, bottom);
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
        canvas.save();
        canvas.rotate((float)RotationAngle, (float)left, (float) top);// rotates the cannon's barrel when angle is adjusted
        canvas.drawRect(left, top, right, bottom , cannonDefaultPaint);
        canvas.restore();
    }
}
