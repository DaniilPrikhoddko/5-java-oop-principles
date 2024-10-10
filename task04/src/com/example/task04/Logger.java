package com.example.task04;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class Logger {
    private static final ArrayList<Logger> loggers = new ArrayList<Logger>();
    static final ArrayList<MessageHandler> handlers = new ArrayList<MessageHandler>();

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR;
    }


    private final String name;
    private Level level;

    private Logger(String name) {
        this.name = name;
        this.level = Level.DEBUG;
    }

    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    public void removeHandler(MessageHandler handler) {
        handlers.remove(handler);
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) {
                return logger;
            }

        }

        loggers.add(new Logger(name));
        return new Logger(name);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    private void log(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            String levelStr = level.name();
            String dateStr = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
            String timeStr = new SimpleDateFormat("HH:mm:ss").format(new Date());
            String outputMessage = String.format("[%s] %s %s %s - %s%n", levelStr, dateStr, timeStr, name, message);
            for (MessageHandler messageHandler : handlers) {
                messageHandler.handle(outputMessage);
            }
        }
    }

    public void log(Level level, String format, Object... args) {
        log(level, String.format(format, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void debug(String format, Object... args) {
        log(Level.DEBUG, String.format(format, args));
    }

    public void info(String format, Object... args) {
        log(Level.INFO, String.format(format, args));
    }

    public void warning(String format, Object... args) {
        log(Level.WARNING, String.format(format, args));
    }

    public void error(String format, Object... args) {
        log(Level.ERROR, String.format(format, args));
    }

}
