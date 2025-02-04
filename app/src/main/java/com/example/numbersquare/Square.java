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
     * Checks whether this {@link Square} overlaps with another {@link Square}.
     *
     * The method determines if the bounding rectangles of the two squares intersect using the {@link RectF#intersects(RectF, RectF)}
     * method. It returns {@code true} if the two squares' bounds overlap, otherwise {@code false}.
     *
     * @param other The other {@link Square} to check for overlap with this square.
     * @return {@code true} if the two squares overlap, {@code false} if they do not.
     */
   public boolean isOverlapping (Square other) {
        return RectF.intersects(this.bounds, other.bounds);
   }
    /**
     * Draws the square onto the provided {@link Canvas}.
     *
     * The method first creates a green {@link Paint} object to outline the square, setting its color to green,
     * its style to stroke (no fill), and the stroke width to 20. It then creates a red {@link Paint} object to
     * draw text inside the square, setting its color to red and the text size to 100.
     *
     * The method uses the canvas to draw the square's bounding rectangle (`bounds`) with the green paint and
     * the number associated with the square as text at the position defined by the square's coordinates (`x`, `y`),
     * using the red paint.
     *
     * @param c The {@link Canvas} onto which the square and its number will be drawn.
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
