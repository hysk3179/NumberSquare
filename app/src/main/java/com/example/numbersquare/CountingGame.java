package com.example.numbersquare;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingGame implements GameStyle{
    private int level;
    private List<String> sqLst;
    private int nextNumber = 1;
    private int i = 0;


    CountingGame(int num){
        level = 2;
        sqLst = new ArrayList<>();
        for (int i = 0; i< num; i++){
            sqLst.add(Integer.toString(i+1));
        }
    }
    /**
     * Returns the size of the square list.
     *
     * @return The size of the square list.
     */
    public int getLabel() {
        return sqLst.size();
    }
    /**
     * Returns the label for the next level, represented as a string.
     *
     * @param res The resources to fetch any localized data.
     * @return A string representing the next level label.
     */
    @Override
    public String getNextLevelLabel(Resources res) {
        return Integer.toString(level++);
    }
    /**
     * Returns the label prompting the user to try again.
     *
     * @param res The resources to fetch any localized data.
     * @return A string that says "Try Again!".
     */
    @Override
    public String getTryAgainLabel(Resources res) {
        return "Try Again!";
    }
    /**
     * Returns the list of square labels.
     *
     * @return A list of strings representing the square labels.
     */
    @Override
    public List<String> getSquareLabels() {
        return sqLst;
    }
    /**
     * Determines the touch status based on the provided square object.
     *
     * @param c The square object to check the word.
     * @return The touch status indicating whether the user should continue, try again, or if the level is complete.
     */
    @Override
    public TouchStatus getTouchStatus(Square c) {
        String num = c.getWord();


//        if (num == nextNumber) {
//            if (nextNumber == getLabel()){
//                nextNumber = 1;
//                return  TouchStatus.LEVEL_COMPLETE;
//            } else {
//                ++nextNumber;
//                return TouchStatus.CONTINUE;
//            }
//        } else {
//            return TouchStatus.TRY_AGAIN;
//        }
        if (sqLst.get(i).equals(num)) {
            if (nextNumber == getLabel()) {
                nextNumber = 1;
                i = 0;
                return TouchStatus.LEVEL_COMPLETE;
            } else {
                i++;
                ++nextNumber;

                return TouchStatus.CONTINUE;
            }
        } else {
            return TouchStatus.TRY_AGAIN;
        }
    }
}
