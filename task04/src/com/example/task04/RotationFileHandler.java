package com.example.task04;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private ChronoUnit chronoUnit = ChronoUnit.HOURS;

    public RotationFileHandler(ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void handle(String message) {

        LocalDateTime time = LocalDateTime.now().truncatedTo(this.chronoUnit);

        try (FileWriter fw = new FileWriter(String.format("log-%s.txt", time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss"))), true)) {
            fw.append(message);
            fw.flush();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



}
