package com.virtualclassroom.utils;

public class InputValidator {

    public static boolean isValidClassName(String className) {
        return className != null && !className.trim().isEmpty();
    }

    public static boolean isValidStudentId(String studentId) {
        return studentId != null && !studentId.trim().isEmpty();
    }

    // Need to Add more validation methods as needed
}
