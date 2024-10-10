package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements MessageHandler{
    private final ArrayList<MessageHandler> messageHandlers = new ArrayList<>();
    private final ArrayList<String> buffer = new ArrayList<>();
    private final int bufferSize;


    public MemoryHandler(int bufferSize, MessageHandler... handlers) {
        this.bufferSize = bufferSize;
        messageHandlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public void handle(String message) {
        buffer.add(message);
        if (buffer.size() == bufferSize) {
            handleBuffer();
        }
    }

    public void handleBuffer() {
        for (MessageHandler handler : messageHandlers) {
            for (String message : buffer) {
                handler.handle(message);
            }
        }
        buffer.clear();
    }
}
