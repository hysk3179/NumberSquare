package com.example.numbersquare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SquareView extends View {

    private Paint red;
    private Paint blue;
    private float rectWidth, rectHeight;
    private float rectLeft, rectTop;
    private RectF bounds;
    private List<Square> flock;
    protected boolean initialized;
    private Square check1, check2;

    public SquareView(Context c) {
        super(c);
        initialized = false;
        flock = new ArrayList<>();
        red = new Paint();
        red.setColor(Color.RED);
        red.setStyle(Paint.Style.STROKE);
        red.setStrokeWidth(20);

        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setTextSize(100);
    }

    /**
     * Handles the drawing of objects on the given canvas.
     * <p>
     * This method initializes a flock of squares if it hasn't been initialized yet.
     * It creates a set of squares, checks for overlapping squares, and modifies the squares
     * as needed to ensure no overlap. After initialization, it draws each square in the flock.
     * </p>
     *
     * @param c The Canvas on which the objects (squares) will be drawn.
     */
    @Override
    public void onDraw(Canvas c) {
        float w = getWidth();
        float h = getHeight();
        if (!initialized) {
            flock.add(new Square(w,h,1));
            for (int i = 2; i < 6; i ++) {
                flock.add(new Square(w, h, i));
                for (int j = 0; j < i; j++) {
                    check1 = flock.get(i - 2);
                    check2 = flock.get(j);
                    if (check1.isOverlapping(check2)) {
                        check1 = new Square(w, h, i);
                        if (i < flock.size()) {
                            flock.set(i, check1);  // Modify the square at index i
                        }

                    }
                }
            }
            initialized = true;
        }
        for (var d : flock) {
            d.draw(c);
        }
    }


}
