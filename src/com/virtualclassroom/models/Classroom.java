package com.virtualclassroom.models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private String className;
    private List<String> students;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentId) {
        if (!students.contains(studentId)) {
            students.add(studentId);
        }
    }

    public List<String> getStudents() {
        return students;
    }

    public String getClassName() {
        return className;
    }
}
