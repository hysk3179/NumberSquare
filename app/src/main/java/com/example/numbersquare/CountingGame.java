package com.example.numbersquare;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingGame implements GameStyle{
    private int level =2 ;
    private List<String> sqLst;

    CountingGame(int num){
        level = 2;
        sqLst = new ArrayList<>();
        for (int i = 0; i< num; i++){
            sqLst.add(Integer.toString(i+1));
        }
    }

    @Override
    public String getNextLevelLabel(Resources res) {
        return Integer.toString(level++);
    }

    @Override
    public String getTryAgainLabel(Resources res) {
        return "Try Again!";
    }

    @Override
    public List<String> getSquareLabels() {
        return sqLst;
    }

    @Override
    public TouchStatus getTouchStatus(Square c) {
        if(c == //the right order of square){
            return TouchStatus.CONTINUE;
        } else if (c != //the right order of square){
            return TouchStatus.TRY_AGAIN;
        } else // if they click all the squares. {
            return TouchStatus.LEVEL_COMPLETE;
        }
        return null;
    }
}
