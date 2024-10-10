package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    @Override
    public void handle(String message) {
        try (FileWriter fw = new FileWriter("log.txt")) {
            fw.write(message);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
