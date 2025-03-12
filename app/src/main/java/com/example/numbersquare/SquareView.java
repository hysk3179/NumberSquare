package com.example.numbersquare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class SquareView extends androidx.appcompat.widget.AppCompatImageView implements TickListener{

    private List<Square> flock;
    protected boolean initialized;
    private Square check;
    private Timer tim;
    private int level = 2;
    int startNum = 1;
    boolean done = false;
    private Bitmap background;
    private MediaPlayer soundtrack;
    int number = Prefs.getNumberPref(getContext());

    public SquareView(Context c, boolean dd) {
        super(c);
        initialized = false;
        flock = new ArrayList<>();
        tim = new Timer();
        tim.registerListener(this);
        setBackgroundResource(R.drawable.temple);
        setScaleType(ScaleType.FIT_XY);
        if (Prefs.getMusicTrackPref(getContext())) {
            soundtrack = MediaPlayer.create(c, R.raw.boxstep);
        } else {
            soundtrack = MediaPlayer.create(c, R.raw.space_jazz);
        }
        soundtrack.setLooping(true);
        if (Prefs.getMusicPref(c)) {
            soundtrack.start();
        }
    }
    public void pauseMusic() {
        if (Prefs.getMusicPref(getContext())) {
            soundtrack.pause();
        }
    }

    public void resumeMusic() {
        if (Prefs.getMusicPref(getContext())) {
            soundtrack.start();
        }
    }

    public void unloadMusic() {
        soundtrack.release();
    }


    /**
     * Initializes and draws a flock of non-overlapping Square objects onto the canvas.
     * The flock is only initialized once, and each square is drawn after ensuring no overlap.
     *
     * @param c The canvas to draw the squares on.
     */
    @Override
    public void onDraw(Canvas c) {
        float w = getWidth();
        float h = getHeight();
        int number = Prefs.getNumberPref(getContext());
        if (!initialized) {
            flock.clear();


            int speed = Prefs.getSpeedPref(getContext());
            Square firstSquare = new Square(getResources(), w,h,1);
            firstSquare.speedingUp(speed);
            flock.add(firstSquare);
            for (int i = 2; i < number + 1; i ++) {
                Square check;
                boolean overlaps;
                do {
                    check = new Square(getResources(), w, h, i);
                    overlaps = false;
                    for (int j = 0; j < flock.size(); j++) {
                        if (check.isOverlapping(flock.get(j))) {
                            overlaps = true;
                            break;
                        }
                    }
                } while (overlaps);
                check.counter();
                check.speedingUp(speed);
                flock.add(check);
            }

            initialized = true;
        }
        for (var d : flock) {
            d.draw(c);
        }
    }
    /**
     * Handles touch events on the canvas. When the user touches the screen,
     * it checks if any square in the flock overlaps with the touch point.
     * If a square is touched, it changes its color to blue and stops it.
     *
     * @param m The motion event representing the touch action.
     * @return true if the touch event is handled; false otherwise.
     */
    @Override
        public boolean onTouchEvent(MotionEvent m) {
            if (m.getAction() == MotionEvent.ACTION_DOWN) {
                float x = m.getX();
                float y = m.getY();

                for (var d : flock) {
                    if (d.isOverlapping(x,y)) {
                        if (d.getId() == startNum) {
//                            d.setColor(Color.WHITE);
                            d.stop();
                            startNum = startNum + 1;
                            d.change();
                            if(startNum == number +1){
                                done = true;
                                initialized = false;
                                invalidate();
                            }
                        }
                    }
                }
                if (done) {

                    Toast toast = Toast.makeText(getContext(), "level" + level, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);  // Center the Toast
                    toast.show();
                    level ++;
                    invalidate();
                    done = false;
                    startNum = 1;
                }
                return true;
            }

            return super.onTouchEvent(m);
        }

    /**
     * Updates the state of the flock by checking for collisions and moving each square.
     * It also triggers a redraw of the view by calling invalidate().
     */
    @Override
    public void tick() {
        checkForCollisions();
        for (Square sq : flock){
            sq.move();
        }
        invalidate();
    }
    /**
     * Checks for collisions between all pairs of squares in the flock.
     * Each square is compared with every other square to detect potential collisions.
     */
    private void checkForCollisions() {
        for (int i = 0; i < flock.size(); i++) {
            for (int j = i + 1; j < flock.size(); j++) {
                flock.get(i).check(flock.get(j));
            }
        }
    }
    /**
     * Registers a tick listener.
     *
     * @param listener The listener to register.
     */
    @Override
    public void registerListener(TickListener listener) {

    }
    /**
     * Removes a registered tick listener.
     *
     * @param listener The listener to remove.
     */
    @Override
    public void removeListener(TickListener listener) {

    }

}
