package com.example.numbersquare;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

public class TickHandler extends Handler {
    private final List<TickListener> listeners = new ArrayList<>();

    // Method to register a listener
    public void registerListener(TickListener listener) {
        listeners.add(listener);
    }

    // Method to remove a listener
    public void unregisterListener(TickListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void handleMessage(Message msg) {
        for (TickListener listener : listeners) {
            listener.tick();
        }
        sendEmptyMessageDelayed(0, 25); // Run every 25ms
    }
}