package com.virtualclassroom.utils;

import java.io.*;
//import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Logger {
    private static final String LOG_FILE = "logs/application.log";
    private static final int LOG_RETENTION_DAYS = 7;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = "[" + timestamp + "][" + level + "] " + message;

        cleanupOldLogs(); // Ensure old logs are removed
        
        // Log to file with timestamp
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logEntry);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }

        // Print to the console without timestamp
        System.out.println("[" + level + "] " + message);
    }

    private static void cleanupOldLogs() {
        File logFile = new File(LOG_FILE);
        if (!logFile.exists()) {
            return; // If the file doesn't exist, no need to clean up.
        }

        List<String> validLogEntries = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String timestampString = extractTimestamp(line);
                if (timestampString != null) {
                    LocalDateTime logDateTime = LocalDateTime.parse(timestampString, formatter);
                    if (logDateTime.plusDays(LOG_RETENTION_DAYS).isAfter(currentDateTime)) {
                        validLogEntries.add(line); // Keep logs within retention period
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }

        // Rewriting the log file with valid entries
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            for (String logEntry : validLogEntries) {
                writer.println(logEntry);
            }
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    private static String extractTimestamp(String logEntry) {
        // The timestamp is expected to be in the format "[yyyy-MM-dd HH:mm:ss]"
        if (logEntry.length() > 21 && logEntry.charAt(0) == '[' && logEntry.charAt(20) == ']') {
            return logEntry.substring(1, 20); // Extract the timestamp portion
        }
        return null;
    }
}
