package com.example.numbersquare;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

public class Timer extends Handler implements TickListener{
    private List<TickListener> listeners;
    public Timer() {
        listeners = new ArrayList<>();
        sendMessageDelayed(obtainMessage(), 0);
    }
    /**
     * Handles incoming messages by notifying all registered tick listeners.
     * It sends the next message after a delay of 25 milliseconds.
     *
     * @param m The message to handle.
     */
    @Override
    public void handleMessage(Message m) {
        for (TickListener listener : listeners) {
            listener.tick();
        }
        sendMessageDelayed(obtainMessage(), 25);
    }
    /**
     * This method is called on each tick but is currently empty.
     */
    @Override
    public void tick() {
        /**
         * Registers a tick listener to receive updates.
         *
         * @param o The listener to register.
         */
    }
    @Override
    public void registerListener(TickListener o) {
        listeners.add(o);
    }
    /**
     * Removes a tick listener from the list of listeners.
     *
     * @param o The listener to remove.
     */
    @Override
    public void removeListener(TickListener o) {
        listeners.remove(o);
    }
}