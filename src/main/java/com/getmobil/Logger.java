package com.getmobil;

public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    public static void info(String value) {
        logger.info(value);
    }

    public static void warning(String value) {
        logger.warning(value);
    }

    public static void fine(String value) {
        logger.fine(value);
    }

}
