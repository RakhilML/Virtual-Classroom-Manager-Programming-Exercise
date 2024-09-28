package com.virtualclassroom.utils;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean isValidClassName(String className) {
        return className != null && !className.trim().isEmpty();
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
        // Simple validation: dueDate should not be empty
        return dueDate != null && !dueDate.trim().isEmpty();
    }

    // New method to prompt user for input
    public static String getUserInput() {
        return scanner.nextLine();
    }
}
