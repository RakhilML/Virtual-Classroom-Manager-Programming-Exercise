package com.virtualclassroom.utils;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean isValidClassName(String className) {
        if (className != null && CLASS_NAME_PATTERN.matcher(className).matches()) {
            return true;
        } else {
            System.out.println("Invalid class name. Please use alphanumeric characters and underscores.");
            return false;
        }
    }

    public static boolean isValidStudentId(String studentId) {
        if (studentId != null && !studentId.trim().isEmpty()) {
            return true;
        } else {
            System.out.println("Invalid student ID. It cannot be empty.");
            return false;
        }
    }

    public static boolean isValidStudentName(String studentName) {
        if (studentName != null && !studentName.trim().isEmpty()) {
            return true;
        } else {
            System.out.println("Invalid student name. It cannot be empty.");
            return false;
        }
    }

    public static boolean isValidAssignmentTitle(String assignmentTitle) {
        if (assignmentTitle != null && !assignmentTitle.trim().isEmpty()) {
            return true;
        } else {
            System.out.println("Invalid assignment title. It cannot be empty.");
            return false;
        }
    }

    public static boolean isValidDueDate(String dueDate) {
        try {
            LocalDate.parse(dueDate, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
            return false;
        }
    }

    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static boolean isValidGrade(String grade) {
        if (grade != null && grade.matches("[A-Fa-f]")) {
            return true;
        } else {
            System.out.println("Invalid grade. Please enter a grade between A and F.");
            return false;
        }
    }
}
