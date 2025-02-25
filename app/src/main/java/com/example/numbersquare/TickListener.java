package com.example.numbersquare;

public interface TickListener {
    default void tick(){}

    void registerListener(TickListener listener);
    void removeListener(TickListener listener);
}



