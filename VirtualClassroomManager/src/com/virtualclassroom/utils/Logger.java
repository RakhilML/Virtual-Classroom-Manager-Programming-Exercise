package com.virtualclassroom.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String LOG_FILE = "logs/application.log";

    public static void logInfo(String message) {
        log("INFO", message);
    }

    public static void logError(String message) {
        log("ERROR", message);
    }

    public static void logDebug(String message) {
        log("DEBUG", message);
    }

    private static void log(String level, String message) {
        String logEntry = "[" + level + "] " + message;

        // to log file
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logEntry);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }

        //print to the console
        System.out.println(logEntry);
    }
}
