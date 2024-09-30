package com.virtualclassroom.models;

import java.util.ArrayList;
import java.util.List;

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
        }
    }

    public void displayEnrolledClassrooms() {
        if (enrolledClassrooms.isEmpty()) {
            System.out.println("No enrolled classrooms.");
        } else {
            System.out.println("Enrolled Classrooms:");
            enrolledClassrooms.forEach(classroom -> System.out.println("- " + classroom.getClassName()));
        }
    }
}
