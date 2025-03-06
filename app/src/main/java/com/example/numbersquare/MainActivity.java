package com.example.numbersquare;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SquareView sq;
    private ImageView iv;

    /**
     * Activity class that initializes the SquareView and sets it as the content view.
     */
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
//        Intent i =getIntent();
        sq = new SquareView(this, false);
        setContentView(sq);
        Toast toast = Toast.makeText(getApplicationContext(), "Level 1", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);  // Center the Toast
        toast.show();
    }
}