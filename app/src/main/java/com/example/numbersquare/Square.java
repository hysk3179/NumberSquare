package com.example.numbersquare;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Square implements TickListener {

    private RectF bounds;
    private Paint green;
    private Paint red;
    private int color;
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
        this.color = Color.GREEN;

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
        this.color = Color.GREEN;
    }

    public void setColor(int newColor) {
        this.color = newColor;
    }

        public boolean isOverlapping (Square other) {
            return RectF.intersects(this.bounds, other.bounds);
        }

        public boolean isOverlapping(float x, float y) {
            return this.bounds.contains(x, y);
        }

    public void check(Square sq) {

        if (this.isOverlapping(sq)){
            if (Math.abs((this.bounds.top - sq.bounds.bottom)) <= 10 || Math.abs((this.bounds.bottom - sq.bounds.top)) <= 10) {

                this.p.y = -this.p.y;
                sq.p.y = -sq.p.y;
            }
            if (Math.abs((this.bounds.right - sq.bounds.left)) <= 10 || Math.abs((this.bounds.left - sq.bounds.right)) <= 10) {
                this.p.x = -this.p.x;
                sq.p.x = -sq.p.x;
            }
            this.bounds.offset(this.p.x,this.p.y);
            sq.bounds.offset(sq.p.x,sq.p.y);
        }
    }


    public void move() {
        if (bounds.left <= 0 || bounds.right >= width) {
            p.x = -p.x;
        }
        if (bounds.top <= 0 || bounds.bottom >= height) {
            p.y = -p.y;
        }
        bounds.offset(p.x,p.y);
    }
    public void stop(Square sq) {
        p.x = 0;
        p.y = 0;
    }

    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(100);


        c.drawRect(bounds, paint);
        c.drawText(Integer.toString(id), bounds.centerX()-20, bounds.centerY()+20, textPaint);
    }



    public void counter() {
        number++;
        id = number;
        if (number == 5){
            number = 1;
        }
    }

    @Override
    public void tick() {
        move();
    }

    @Override
    public void registerListener(TickListener o) {

    }

    @Override
    public void removeListener(TickListener o) {

    }

}