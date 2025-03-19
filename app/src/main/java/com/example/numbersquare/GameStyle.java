package com.example.numbersquare;

import android.content.res.Resources;

import java.util.List;

public interface GameStyle {
    String getNextLevelLabel(Resources res);
    String getTryAgainLabel(Resources res);
    List<String> getSquareLabels();
    TouchStatus getTouchStatus(Square c);
}
