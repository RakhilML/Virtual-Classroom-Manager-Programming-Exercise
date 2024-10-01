package com.virtualclassroom.models;

import java.util.ArrayList;
import java.util.List;
import com.virtualclassroom.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class Classroom {

    private String className;
    private List<Student> students; 
    private Map<String, Assignment> assignments;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
        this.assignments = new HashMap<>();
    }

    public void addStudent(Student student) {  // Accept a Student object
        if (!students.contains(student)) {
            students.add(student);
            //Logger.logInfo("Student " + student.getStudentId() + " added to class " + className);
        } else {
            Logger.logError("Student " + student.getStudentId() + " is already in class " + className);
        }
    }

    public void removeStudent(Student student) {  // Accept a Student object
        if (students.contains(student)) {
            students.remove(student);
            //Logger.logInfo("Student " + student.getStudentId() + " removed from class " + className);
        } else {
            Logger.logError("Student " + student.getStudentId() + " not found in class " + className);
        }
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }
    public Assignment getAssignment(String assignmentTitle) {
        return assignments.get(assignmentTitle);
    }
}
