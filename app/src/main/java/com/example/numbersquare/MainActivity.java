package com.example.numbersquare;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SquareView sq;
    /**
     * Activity class that initializes the SquareView and sets it as the content view.
     */
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        sq = new SquareView(this);
        setContentView(sq);
    }
}