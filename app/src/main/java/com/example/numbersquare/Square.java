package com.example.numbersquare;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;

public class Square {
    private RectF bounds;
    private Paint green;
    private Paint red;
    private float x;
    private float y;
    static private int number = 1;
    int id;
    float width;
    float height;
    float velocitydx = (float)(Math.random()*10)-5; //-5 ~ 5
    float velocitydy = (float)(Math.random()*10)-5; //-5 ~ 5

    PointF p = new PointF(velocitydx, velocitydy);



    public Square(float screenWidth, float screenHeight, int i) {
        height = screenHeight;
        width = screenWidth;

        float size = screenWidth / 5;
        float left = (float)((screenWidth - size) * Math.random());
        float top = (float)((screenHeight-size) * Math.random());
        bounds = new RectF(left, top, left+size, top+size);
        x = (left+size/2)-22;
        y = (top+size/2)+22;
        id = i;

    }
    public Square(float screenWidth, float screenHeight) {
        height = screenHeight;
        width = screenWidth;

        float size = screenWidth / 5;
        float left = (float)((screenWidth - size) * Math.random());
        float top = (float)((screenHeight-size) * Math.random());
        bounds = new RectF(left, top, left+size, top+size);
        x = (left+size/2)-22;
        y = (top+size/2)+22;
   }
    /**
     * Checks if this square overlaps with another square.
     *
     * @param other The other square to check for overlap.
     * @return True if the squares overlap, false otherwise.
     */
   public boolean isOverlapping (Square other) {
        return RectF.intersects(this.bounds, other.bounds);
   }

    /**
     * Moves the object by updating its position based on velocity, reversing the velocity
     * when the object hits the screen boundaries (left, right, top, or bottom).
     */
    public void move() {
        if (bounds.left <= 0 || bounds.right >= width) {
            p.x = -p.x;
        }
        if (bounds.top <= 0 || bounds.bottom >= height) {
            p.y = -p.y;
        }
        bounds.offset(p.x,p.y);
   }
    /**
     * Draws the square and its number on the given canvas.
     * The square is outlined in green, and its number is displayed in red at the center.
     *
     * @param c The canvas on which to draw the square and number.
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
        c.drawText(Integer.toString(id), bounds.centerX()-20, bounds.centerY()+20, red);
    }
    /**
     * Increments the value of {@code number} and sets {@code id} to the current value of {@code number}.
     * If {@code number} reaches 5, it resets {@code number} to 1.
     * <p>
     * This method ensures that {@code number} cycles between 1 and 4, while {@code id} holds the current value of {@code number}.
     * </p>
     */
    public void counter() {
        number++;
        id = number;
        if (number == 5){
            number = 1;
        }
    }
}
