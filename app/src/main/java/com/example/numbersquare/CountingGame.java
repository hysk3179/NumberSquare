package com.example.numbersquare;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingGame implements GameStyle{
    private int level =2 ;
    private List<String> sqLst;
    private int nextNumber = 1;


    CountingGame(int num){
        level = 2;
        sqLst = new ArrayList<>();
        for (int i = 0; i< num; i++){
            sqLst.add(Integer.toString(i+1
            ));
        }
    }
    public int getLabel() {
        return sqLst.size();
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
        int num = c.getId();
        if (num == nextNumber) {
            if (nextNumber == getLabel()){
                nextNumber = 1;
                return  TouchStatus.LEVEL_COMPLETE;
            } else {
                ++nextNumber;
                return TouchStatus.CONTINUE;
            }
        } else {
            return TouchStatus.TRY_AGAIN;
        }
    }
}
