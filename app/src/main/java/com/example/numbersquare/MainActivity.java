package com.example.numbersquare;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SquareView sq;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        sq = new SquareView(this);
        setContentView(sq);

    }
}