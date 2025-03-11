package com.example.numbersquare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Titlescreen extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        iv = new ImageView(this);
        iv.setImageResource(R.drawable.background);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        setContentView(iv);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            float h = iv.getHeight();
            float w = iv.getWidth();
            float x = m.getX();
            float y = m.getY();
            if (y < h*0.25) {
                if (x < w*0.4) {
                    //tapped About button
                    AlertDialog.Builder ab = new AlertDialog.Builder(this);
                    ab.setTitle("Title : Iced cube in Laie temple")
                            .setMessage("Developer : Hyunseok Cho\n" + "BackgroundMusic : funky boxstep.\n (source : incompetech.com)\n" +
                                    "How to play : You will see 5 squares floating around on the Laie temple background. Your mission is to make it stop by clicking those Squares. Once you done, it will show next level of squares.")
                            .setNeutralButton("OK", null);
                    AlertDialog box = ab.create();
                    ab.show();
                } else if (x > w * 0.6) {
                    Intent it = new Intent(this, Prefs.class);
                    startActivity(it);
                } else  {
                    Intent main = new Intent(this, MainActivity.class);
                    startActivity(main.putExtra("Start", true));
                }

            } else {
                //distinguish between
                //right/left facing ducks.
                Intent i = new Intent(this, MainActivity.class);
                if (x < w*0.5) {
                    i.putExtra("Start", true);
                } else {
                    i.putExtra("Start", false);
                }
                startActivity(i);
                finish();//close current activity
            }
        }
        return true;
    }

}
