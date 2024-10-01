package com.virtualclassroom.models;

import java.util.ArrayList;
import java.util.List;
import com.virtualclassroom.utils.Logger;

public class Student {
    private String studentId;
    private String studentName;
    private List<Classroom> enrolledClassrooms;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledClassrooms = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Classroom> getEnrolledClassrooms() {
        return enrolledClassrooms;
    }

    public void enrollInClassroom(Classroom classroom) {
        if (!enrolledClassrooms.contains(classroom)) {
            enrolledClassrooms.add(classroom);
            //Logger.logInfo("Student " + studentId + " enrolled in class " + classroom.getClassName());
        } else {
            Logger.logError("Student " + studentId + " is already enrolled in class " + classroom.getClassName());
        }
    }

    public void unenrollFromClassroom(Classroom classroom) {
        if (enrolledClassrooms.contains(classroom)) {
            enrolledClassrooms.remove(classroom);
            Logger.logInfo("Student " + studentId + " unenrolled from class " + classroom.getClassName());
        } else {
            Logger.logError("Student " + studentId + " is not enrolled in class " + classroom.getClassName());
        }
    }

    public void displayEnrolledClassrooms() {
        if (enrolledClassrooms.isEmpty()) {
            System.out.println("No enrolled classrooms for student " + studentId + ".");
        } else {
            System.out.println("Enrolled Classrooms for student " + studentId + ":");
            enrolledClassrooms.forEach(classroom -> System.out.println("- " + classroom.getClassName()));
        }
    }
}
