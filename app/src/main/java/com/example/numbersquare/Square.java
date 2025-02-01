package com.example.numbersquare;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;

public class Square {
    private RectF bounds;
    private Paint green;
    private Paint red;
    private float x;
    private float y;
    private int number;

    public Square(float screenWidth, float screenHeight, int i) {
        float size = screenWidth / 5;
        float left = (float)((screenWidth - size) * Math.random());
        float top = (float)((screenHeight-size) * Math.random());
        bounds = new RectF(left, top, left+size, top+size);
        x = (left+size/2)-22;
        y = (top+size/2)+22;
        number = i;
    }
    /**
     * Checks if this square is overlapping with another square.
     * <p>
     * This method uses the {@link RectF#intersects(RectF, RectF)} function to check if the
     * bounding rectangles of this square and another square intersect.
     * </p>
     *
     * @param other The other square to check for overlap.
     * @return true if the squares overlap, false otherwise.
     */
    public boolean isOverlapping(Square other) {
        return RectF.intersects(this.bounds, other.bounds);
    }

    /**
     * Draws a square and its associated number on the given canvas.
     * <p>
     * This method draws a green rectangle (representing the square) with a stroke style,
     * and then draws the number inside the square in red at a specified position.
     * </p>
     *
     * @param c The Canvas on which the square and number will be drawn.
     */
    public void draw(Canvas c) {
        green = new Paint();
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.STROKE);
        green.setStrokeWidth(20);

        red = new Paint();
        red.setColor(Color.RED);
        red.setTextSize(100);
        c.drawRect(bounds, green);
        c.drawText(Integer.toString(number), x, y, red);



    }

}
