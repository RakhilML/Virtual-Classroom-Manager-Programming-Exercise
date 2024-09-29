package com.virtualclassroom.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);
    
    // Regular expression for valid classroom names: alphanumeric and underscores only
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");

    // Classroom name validation
    public static boolean isValidClassName(String className) {
        return className != null && CLASS_NAME_PATTERN.matcher(className).matches();
    }

    public static boolean isValidStudentId(String studentId) {
        return studentId != null && !studentId.trim().isEmpty();
    }

    public static boolean isValidStudentName(String studentName) {
        return studentName != null && !studentName.trim().isEmpty();
    }

    public static boolean isValidAssignmentTitle(String assignmentTitle) {
        return assignmentTitle != null && !assignmentTitle.trim().isEmpty();
    }

    public static boolean isValidDueDate(String dueDate) {
        // Simple validation: dueDate should not be empty (further validation can be added)
        return dueDate != null && !dueDate.trim().isEmpty();
    }

    // Prompt user for input
    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static boolean isValidGrade(String grade) {
        // Grade validation: only allows grades A-F (case insensitive)
        return grade != null && grade.matches("[A-Fa-f]");
    }
}
