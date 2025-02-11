package com.example.numbersquare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
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
    private Timer tim;

    public class Timer extends Handler {

        public Timer() {
            sendMessageDelayed(obtainMessage(), 0);
        }

        @Override
        public void handleMessage(Message m) {
            for (var d : flock) {
                d.move();

            }
            invalidate();
            sendMessageDelayed(obtainMessage(), 10);
        }
    }

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
        tim = new Timer();
    }

    /**
     * Initializes and draws squares on the canvas. If not already initialized,
     * it adds new squares to the flock, ensuring no overlaps, and starts a timer.
     *
     * @param c The canvas on which to draw the squares.
     */
    @Override
    public void onDraw(Canvas c) {
        float w = getWidth();
        float h = getHeight();
       if (!initialized) {
            flock.add(new Square(w,h,1));
            for (int i = 2; i < 6; i ++) {
                Square check;
                boolean overlaps;
                do {
                    check = new Square(w,h);
                    overlaps = false;
                    for (int j = 0; j < flock.size(); j++) {
                        if (check.isOverlapping(flock.get(j))) {
                            overlaps = true;
                            break;
                        }
                    }
                } while (overlaps);
                check.counter();
                flock.add(check);
            }

            initialized = true;
       }
       for (var d : flock) {
            d.draw(c);
       }
    }


    /**
     * Handles touch events to reset initialization and the flock of squares.
     * On ACTION_DOWN, it invalidates the view, and on ACTION_UP, it clears the flock.
     *
     * @param m The MotionEvent containing the touch event data.
     * @return True if the event was handled, false otherwise.
     */
    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN){
            initialized = false;
            invalidate();
            return true;
        } else if (m.getAction() == MotionEvent.ACTION_UP) {
            initialized = false;
            flock.clear();
            invalidate();
            return true;
        }
        return super.onTouchEvent(m);
    }
}
