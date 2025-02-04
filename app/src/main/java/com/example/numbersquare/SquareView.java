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

    /**
     * This method is responsible for drawing the flock of squares onto the provided {@link Canvas}.
     *
     * Initially, the method checks if the flock has been initialized. If not, it generates a set of squares
     * of different sizes, ensuring that they do not overlap. Each square is added to the flock, and once the
     * initialization is complete, the {@link Square} objects are drawn onto the canvas.
     *
     * The squares are generated based on the current dimensions of the view, and they are stored in the
     * flock list. The first square is added with a fixed size, and subsequent squares of increasing sizes
     * are added after ensuring that they do not overlap with any already existing squares in the flock.
     *
     * After the initialization, the method iterates through all squares in the flock and draws them using
     * their respective {@link Square#draw(Canvas)} method.
     *
     * @param c The {@link Canvas} object onto which the flock of squares will be drawn.
     */
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

    /**
     * This method handles touch events on the view.
     *
     * It listens for both ACTION_DOWN and ACTION_UP events. When the user touches the screen (ACTION_DOWN) or
     * releases the touch (ACTION_UP), the method resets the initialization flag of the flock (`initialized = false`),
     * triggering the reinitialization of the flock of squares. After that, it calls {@link #invalidate()} to request a
     * redraw of the view, ensuring that the updated flock is displayed.
     *
     * @param m The {@link MotionEvent} that contains details about the touch event.
     * @return {@code true} if the touch event was handled; {@code false} if the event was not handled.
     */

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
