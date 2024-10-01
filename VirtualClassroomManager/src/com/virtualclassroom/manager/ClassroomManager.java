package com.virtualclassroom.manager;

import com.virtualclassroom.models.Assignment;
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
                Student newStudent = new Student(studentId, className);
                students.put(studentId, newStudent);
            }

            Student student = students.get(studentId);
            classroom.addStudent(student); 
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
            classroom.getStudents().forEach(student -> Logger.logInfo("- " + student.getStudentName() + " (" + student.getStudentId() + ")"));
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

    public void removeStudent(String studentId, String className) {
        if (!InputValidator.isValidStudentId(studentId) || !InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid input for removing student.");
            return;
        }
        if (!classrooms.containsKey(className)) {
            Logger.logError("Classroom " + className + " does not exist.");
            return;
        }
        Classroom classroom = classrooms.get(className);
        if (!students.containsKey(studentId)) {
            Logger.logError("Student " + studentId + " does not exist.");
            return;
        }
        Student student = students.get(studentId);
        if (!classroom.getStudents().contains(student)) {
            Logger.logError("Student " + studentId + " is not enrolled in " + className);
            return;
        }
        classroom.removeStudent(student);
        Logger.logInfo("Student " + studentId + " has been removed from classroom " + className);
    }

    public void displayEnrolledClassrooms(String studentId) {
        if (!InputValidator.isValidStudentId(studentId)) {
            Logger.logError("Invalid student ID.");
            return;
        }
        if (!students.containsKey(studentId)) {
            Logger.logError("Student " + studentId + " does not exist.");
            return;
        }
        Student student = students.get(studentId);
        if (student != null) {
            student.displayEnrolledClassrooms();
        } else {
            Logger.logError("Student not found.");
        }
    }

    public void assignGrade(String studentId, String className, String grade, String assignmentTitle) {
        // Validate inputs
        if (!InputValidator.isValidStudentId(studentId) || 
            !InputValidator.isValidClassName(className) || 
            !InputValidator.isValidGrade(grade)) {
            Logger.logError("Invalid input for assigning grade.");
            return;
        }
    
        // Check if the classroom exists
        if (!classrooms.containsKey(className)) {
            Logger.logError("Classroom " + className + " does not exist.");
            return;
        }
    
        // Check if the student exists
        if (!students.containsKey(studentId)) {
            Logger.logError("Student " + studentId + " does not exist.");
            return;
        }
    
        // Get the classroom
        Classroom classroom = classrooms.get(className);
        
        // Check if the student is enrolled in the classroom
        if (!classroom.getStudents().contains(students.get(studentId))) {
            Logger.logError("Student " + studentId + " is not enrolled in " + className);
            return;
        }
    
        // Get the assignment from the classroom
        Assignment assignment = classroom.getAssignment(assignmentTitle);
        if (assignment == null) {
            Logger.logError("Assignment " + assignmentTitle + " does not exist in " + className);
            return;
        }
    
        // Assign the grade through the assignment instance
        assignment.assignGrade(studentId, grade);
        Logger.logInfo("Grade " + grade + " assigned to student " + studentId + " for assignment " + assignmentTitle);
    }
    
    
    
    
}
