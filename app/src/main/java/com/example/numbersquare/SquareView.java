package com.example.numbersquare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
        if (initialized == false) {
            //Resources res = getResources();
            for (int i = 1; i < 6; i ++) {
                flock.add(new Square(w, h, i));
            }
            initialized = true;
        }
        for (var d : flock) {
            d.draw(c);

        }
    }
}
