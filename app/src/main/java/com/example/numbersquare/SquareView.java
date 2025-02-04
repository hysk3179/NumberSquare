package com.example.numbersquare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SquareView extends View {

    private Paint red;
    private Paint blue;
    private List<Square> flock;
    protected boolean initialized;
    private Square check;

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

    @Override
    public void onDraw(Canvas c) {
        float w = getWidth();
        float h = getHeight();
        flock.clear();
        if (!initialized) {
            flock.add(new Square(w,h,1));
            for (int i = 2; i < 6; i ++) {
                Square check;
                boolean overlaps;
                do {
                    check = new Square(w,h,i);
                    overlaps = false;
                    for (int j = 0; j < flock.size(); j++) {
                        if (check.isOverlapping(flock.get(j))) {
                            overlaps = true;
                            break;
                        }
                    }
                } while (overlaps);

                    flock.add(check);
            }
            initialized = true;
        }
        for (var d : flock) {
            d.draw(c);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN){
            initialized = false;
            invalidate();
            return true;
        } else if (m.getAction() == MotionEvent.ACTION_UP) {
            initialized = false;
            invalidate();
            return true;
        }
        return super.onTouchEvent(m);
    }
}
