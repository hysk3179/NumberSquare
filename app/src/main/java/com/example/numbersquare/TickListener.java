package com.example.numbersquare;

import java.util.List;
/**
 * Interface for objects that want to listen for tick events.
 * It provides methods to register and remove listeners and a default tick method
 * that can be overridden to handle the tick event.
 */
public interface TickListener {
    /**
     * The method to be called on each tick event.
     * This is a default method, so it can be overridden by implementing classes.
     */
    default void tick(){};

    /**
     * Registers a tick listener to receive updates.
     *
     * @param listener The listener to register.
     */
    void registerListener(TickListener listener);
    /**
     * Removes a tick listener from the list of listeners.
     *
     * @param listener The listener to remove.
     */
    void removeListener(TickListener listener);

}



