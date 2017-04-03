package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by kurtisdavidson on 4/2/17.
 */

public class Cannon extends CustomElement{

    private double x;
    private double y;
    private int angle;
    private Paint cannonDefaultPaint = new Paint();
    protected Rect myCannon;

    public Cannon (String name, int color, int left, int top, int right, int bottom, int initAngle) {
        super(name, color);
        x = left;
        y = top;
        angle = initAngle;
        this.myCannon = new Rect(left, top, right, bottom);
    }

    public void setCannonXPos (int newXPos) {
        x = newXPos;
    }

    public void setCannonYPos (int newYPos) {
        y = newYPos;
    }

    public void setCannonAngle (int newAngle) {
        angle = newAngle;
    }

    public double getCannonXPos() {
        return x;
    }

    public double getCannonYPos() {
        return y;
    }

    public int getCannonAngle() {
        return angle;
    }

    @Override
    public boolean containsPoint(int x, int y) {

        //Want to check for a tap within a slightly larger rectangle
        int left = this.myCannon.left - TAP_MARGIN;
        int top = this.myCannon.top - TAP_MARGIN;
        int right = this.myCannon.right + TAP_MARGIN;
        int bottom = this.myCannon.bottom + TAP_MARGIN;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);
    }//contaisPoint

    public void drawMe(Canvas canvas) {
        cannonDefaultPaint.setColor(Color.BLACK);
        canvas.rotate(getCannonAngle()); // rotates the cannon's barrel when angle is adjusted
        canvas.drawRect(myCannon, cannonDefaultPaint);
    }
}
