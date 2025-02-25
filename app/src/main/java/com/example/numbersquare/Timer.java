package com.example.numbersquare;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;


public class Timer extends Handler {
    List<TickListener> listeners = new ArrayList<>();

    Timer() {
        sendMessageDelayed(obtainMessage(), 0);
    }

    @Override
    public void handleMessage(Message m) {
        for (var d : listeners) {
            d.tick();
        }
        sendMessageDelayed(obtainMessage(), 25);
    }

    public void registerListener(TickListener listener) {
        listeners.add(listener);
    }

    public void removeListener(TickListener listener) {
        listeners.remove(listener);
    }
}