package com.virtualclassroom.manager;

import com.virtualclassroom.models.Classroom;
import com.virtualclassroom.models.Student;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {

    private static ClassroomManager instance; 

    private Map<String, Classroom> classrooms = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Map<String, Boolean>> attendanceRecords = new HashMap<>();

    private ClassroomManager() {}

    public static ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
        }
        return instance;
    }

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

            // Create a student if not already in the system
            if (!students.containsKey(studentId)) {
                System.out.println("Enter student name:");
                String studentName = InputValidator.getUserInput();  // Prompt for name
                Student newStudent = new Student(studentId, studentName);
                students.put(studentId, newStudent);
            }

            Student student = students.get(studentId);
            classroom.addStudent(studentId);
            student.enrollInClassroom(classroom);

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

    public void listStudentsInClass(String className) {
        if (!InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid class name.");
            return;
        }

        if (classrooms.containsKey(className)) {
            Classroom classroom = classrooms.get(className);
            Logger.logInfo("Students enrolled in " + className + ":");
            classroom.getStudents().forEach(studentId -> Logger.logInfo("- " + studentId));
        } else {
            Logger.logError("Classroom " + className + " does not exist.");
        }
    }
    public void markAttendance(String studentId, String className, boolean isPresent) {
        if (!InputValidator.isValidStudentId(studentId) || !InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid input for marking attendance.");
            return;
        }

        if (!classrooms.containsKey(className)) {
            Logger.logError("Classroom " + className + " does not exist.");
            return;
        }

        // Record attendance
        if (!attendanceRecords.containsKey(className)) {
            attendanceRecords.put(className, new HashMap<>());
        }

        attendanceRecords.get(className).put(studentId, isPresent);
        Logger.logInfo("Attendance marked for student: " + studentId + " in classroom: " + className + " - Present: " + isPresent);
    }

    public void listAttendance(String className) {
        if (!InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid class name.");
            return;
        }

        if (!attendanceRecords.containsKey(className)) {
            Logger.logError("No attendance records for " + className);
            return;
        }

        Logger.logInfo("Attendance for " + className + ":");
        attendanceRecords.get(className).forEach((studentId, isPresent) -> {
            String attendanceStatus = isPresent ? "Present" : "Absent";
            Logger.logInfo("- " + studentId + ": " + attendanceStatus);
        });
    }
}
