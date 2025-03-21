package com.example.numbersquare;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SpellingGame implements GameStyle {
    private int level;
    private List<String> list;
    private int time = 1;


    SpellingGame(int num) {
        level = 2;
        list = new ArrayList<>();
        if (num == 5) {
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int number = random.nextInt(26);
                switch (number) {
                    case 0:
                        list.add("a");
                        break;
                    case 1:
                        list.add("b");
                        break;
                    case 2:
                        list.add("c");
                        break;
                    case 3:
                        list.add("d");
                        break;
                    case 4:
                        list.add("e");
                        break;
                    case 5:
                        list.add("f");
                        break;
                    case 6:
                        list.add("g");
                        break;
                    case 7:
                        list.add("h");
                        break;
                    case 8:
                        list.add("i");
                        break;
                    case 9:
                        list.add("j");
                        break;
                    case 10:
                        list.add("k");
                        break;
                    case 11:
                        list.add("l");
                        break;
                    case 12:
                        list.add("m");
                        break;
                    case 13:
                        list.add("n");
                        break;
                    case 14:
                        list.add("o");
                        break;
                    case 15:
                        list.add("p");
                        break;
                    case 16:
                        list.add("q");
                        break;
                    case 17:
                        list.add("r");
                        break;
                    case 18:
                        list.add("s");
                        break;
                    case 19:
                        list.add("t");
                        break;
                    case 20:
                        list.add("u");
                        break;
                    case 21:
                        list.add("v");
                        break;
                    case 22:
                        list.add("w");
                        break;
                    case 23:
                        list.add("x");
                        break;
                    case 24:
                        list.add("y");
                        break;
                    case 25:
                        list.add("z");
                        break;
                }
            }
        }
        if (num == 7) {
            for (int i = 0; i < 7; i++) {
                Random random = new Random();
                int number = random.nextInt(26);
                switch (number) {
                    case 0:
                        list.add("a");
                        break;
                    case 1:
                        list.add("b");
                        break;
                    case 2:
                        list.add("c");
                        break;
                    case 3:
                        list.add("d");
                        break;
                    case 4:
                        list.add("e");
                        break;
                    case 5:
                        list.add("f");
                        break;
                    case 6:
                        list.add("g");
                        break;
                    case 7:
                        list.add("h");
                        break;
                    case 8:
                        list.add("i");
                        break;
                    case 9:
                        list.add("j");
                        break;
                    case 10:
                        list.add("k");
                        break;
                    case 11:
                        list.add("l");
                        break;
                    case 12:
                        list.add("m");
                        break;
                    case 13:
                        list.add("n");
                        break;
                    case 14:
                        list.add("o");
                        break;
                    case 15:
                        list.add("p");
                        break;
                    case 16:
                        list.add("q");
                        break;
                    case 17:
                        list.add("r");
                        break;
                    case 18:
                        list.add("s");
                        break;
                    case 19:
                        list.add("t");
                        break;
                    case 20:
                        list.add("u");
                        break;
                    case 21:
                        list.add("v");
                        break;
                    case 22:
                        list.add("w");
                        break;
                    case 23:
                        list.add("x");
                        break;
                    case 24:
                        list.add("y");
                        break;
                    case 25:
                        list.add("z");
                        break;
                }
            }
        }
        if (num == 9) {
            for (int i = 0; i < 9; i++) {
                Random random = new Random();
                int number = random.nextInt(26);
                switch (number) {
                    case 0:
                        list.add("a");
                        break;
                    case 1:
                        list.add("b");
                        break;
                    case 2:
                        list.add("c");
                        break;
                    case 3:
                        list.add("d");
                        break;
                    case 4:
                        list.add("e");
                        break;
                    case 5:
                        list.add("f");
                        break;
                    case 6:
                        list.add("g");
                        break;
                    case 7:
                        list.add("h");
                        break;
                    case 8:
                        list.add("i");
                        break;
                    case 9:
                        list.add("j");
                        break;
                    case 10:
                        list.add("k");
                        break;
                    case 11:
                        list.add("l");
                        break;
                    case 12:
                        list.add("m");
                        break;
                    case 13:
                        list.add("n");
                        break;
                    case 14:
                        list.add("o");
                        break;
                    case 15:
                        list.add("p");
                        break;
                    case 16:
                        list.add("q");
                        break;
                    case 17:
                        list.add("r");
                        break;
                    case 18:
                        list.add("s");
                        break;
                    case 19:
                        list.add("t");
                        break;
                    case 20:
                        list.add("u");
                        break;
                    case 21:
                        list.add("v");
                        break;
                    case 22:
                        list.add("w");
                        break;
                    case 23:
                        list.add("x");
                        break;
                    case 24:
                        list.add("y");
                        break;
                    case 25:
                        list.add("z");
                        break;
                }
            }
        }
    }
    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int getLabel() {
        return list.size();
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
     * Returns the label to encourage the user to try again.
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
        return list;
    }
    /**
     * Returns a sentence formed by joining the list items into a string.
     *
     * @return A sentence as a string.
     */
    public String getSentence() {
        return String.join(list.toString());
    }
    /**
     * Determines the touch status based on the provided square object.
     *
     * @param c The square object to check the word.
     * @return The touch status indicating whether the user should continue, try again, or if the level is complete.
     */
    @Override
    public TouchStatus getTouchStatus(Square c) {
        String check = c.getWord();
        int i = 0;
        if (check == list.get(i)) {
            if (time == getLabel()) {
                time = 1;
                return TouchStatus.LEVEL_COMPLETE;
            } else {
                ++time;
                i++;
                return TouchStatus.CONTINUE;
            }
        } else {
            return TouchStatus.TRY_AGAIN;
        }
    }
}
