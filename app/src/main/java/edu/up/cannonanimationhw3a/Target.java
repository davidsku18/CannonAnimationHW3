package edu.up.cannonanimationhw3a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by kurtisdavidson on 4/4/17.
 */

public class Target {

    private int x;
    private int y;
    private Paint targetOuterPaint = new Paint();
    private Paint targetInnerPaint = new Paint();
    private Paint targetCenterPaint = new Paint();

    public Target ( int initX, int initY) {
        this.x = initX;
        this.y = initY;
    }

    public int getTargetX() {
        return this.x;
    }

    public int getTargetY() {
        return this.y;
    }

    public void targetHit() {
        targetCenterPaint.setColor(Color.YELLOW);
        targetInnerPaint.setColor(Color.YELLOW);
        targetOuterPaint.setColor(Color.YELLOW);
    }

    public void drawMe(Canvas canvas) {
        targetOuterPaint.setColor(Color.RED);
        canvas.drawCircle(1100, 500, 90, targetOuterPaint);
        targetInnerPaint.setColor(Color.WHITE);
        canvas.drawCircle(1100, 500, 60, targetInnerPaint);
        targetCenterPaint.setColor(Color.RED);
        canvas.drawCircle(1100, 500, 30, targetCenterPaint);
    }
}
