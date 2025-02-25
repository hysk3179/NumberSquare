package com.example.numbersquare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class SquareView extends View implements TickListener{

    private List<Square> flock;
    protected boolean initialized;
    private Square check;
//    private Timer tim;
    public boolean isStopped = false;

    @Override
    public void tick() {
        invalidate();
    }

//    public class Timer extends Handler {
//
//        public Timer() {
//            sendMessageDelayed(obtainMessage(), 0);
//        }
//
//        @Override
//        public void handleMessage(Message m) {
//            for (var d : flock) {
//                d.move();
//            }
//            if (flock.size() > 4) {
//                for (int i = 0; i < 4; i++) {
//                    for (int j = i + 1; j < 5; j++) {
//                        flock.get(i).check(flock.get(j));
//                    }
//                }
//            }
//            invalidate();
//            sendMessageDelayed(obtainMessage(), 25);
//        }
//    }
    public SquareView(Context c) {
        super(c);
        initialized = false;
        flock = new ArrayList<>();
//        tim = new Timer();
    }

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

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            float x = m.getX();
            float y = m.getY();

            for (var d : flock) {
                for (int i = 0; i < 5; i++) {
                    if (flock.get(i).isOverlapping(x,y)) {
                        flock.get(i).setColor(Color.BLUE);
                        invalidate();
                        flock.get(i).stop(flock.get(i));

                    }
                }
            }

            return true;
        }

        return super.onTouchEvent(m);
    }
}
