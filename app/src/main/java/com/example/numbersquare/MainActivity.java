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
     * Initializes the activity and sets up the content view with a SquareView.
     * <p>
     * This method is called when the activity is first created. It initializes a new instance of
     * {@link SquareView} and sets it as the content view of the activity, allowing the view to be displayed on the screen.
     * </p>
     *
     * @param b A {@link Bundle} object containing the activity's previously saved state.
     *          If the activity has not been previously created, this will be null.
     */
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        sq = new SquareView(this);
        setContentView(sq);

    }
}