package com.virtualclassroom.manager;

import com.virtualclassroom.models.Classroom;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {

    private Map<String, Classroom> classrooms = new HashMap<>();

    public void addClassroom(String className) {
        // Validate class name
        if (!InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid class name.");
            return;
        }

        if (!classrooms.containsKey(className)) {
            Classroom newClassroom = new Classroom(className);
            classrooms.put(className, newClassroom);
            Logger.logInfo("Classroom " + className + " has been created.");
        } else {
            Logger.logError("Classroom " + className + " already exists.");
        }
    }

    public void addStudentToClass(String studentId, String className) {
        // Validate inputs
        if (!InputValidator.isValidStudentId(studentId) || !InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid input for adding student.");
            return;
        }

        if (classrooms.containsKey(className)) {
            Classroom classroom = classrooms.get(className);
            classroom.addStudent(studentId);
            Logger.logInfo("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            Logger.logError("Classroom " + className + " does not exist.");
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            Logger.logInfo("No classrooms available.");
            return;
        }
        Logger.logInfo("Available Classrooms:");
        classrooms.keySet().forEach(className -> Logger.logInfo("- " + className));
    }

    public void removeClassroom(String className) {
        // Validate class name
        if (!InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid class name.");
            return;
        }

        if (classrooms.containsKey(className)) {
            classrooms.remove(className);
            Logger.logInfo("Classroom " + className + " has been removed.");
        } else {
            Logger.logError("Classroom " + className + " does not exist.");
        }
    }
}
