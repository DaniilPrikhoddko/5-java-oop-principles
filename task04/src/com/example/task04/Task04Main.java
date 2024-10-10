package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        // Создание обработчиков сообщений
        ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler = new FileHandler();
        RotationFileHandler rotationFileHandler = new RotationFileHandler(ChronoUnit.HOURS);

        // Создание MemoryHandler с буфером размером 3 и добавление обработчиков
        MemoryHandler memoryHandler = new MemoryHandler(3, consoleHandler, fileHandler, rotationFileHandler);

        // Добавление обработчиков в Logger
        Logger.handlers.add(consoleHandler);
        Logger.handlers.add(fileHandler);
        Logger.handlers.add(rotationFileHandler);
        Logger.handlers.add(memoryHandler);

        // Получение логгера
        Logger logger = Logger.getLogger("TestLogger");

        // Установка уровня логирования
        logger.setLevel(Logger.Level.DEBUG);

        // Логирование сообщений
        logger.debug("This is a debug message.");
        logger.info("This is an info message.");
        logger.warning("This is a warning message.");
        logger.error("This is an error message.");

        // Логирование сообщений с форматированием
        logger.debug("This is a formatted debug message with %s and %d", "string", 123);
        logger.info("This is a formatted info message with %s and %d", "string", 123);
        logger.warning("This is a formatted warning message with %s and %d", "string", 123);
        logger.error("This is a formatted error message with %s and %d", "string", 123);
    }
}
