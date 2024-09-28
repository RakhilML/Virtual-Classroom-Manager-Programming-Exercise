package com.virtualclassroom.utils;

public class InputValidator {

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

    // Add more validation methods as needed
}
