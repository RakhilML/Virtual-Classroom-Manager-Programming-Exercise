package com.virtualclassroom.models;

import java.util.HashMap;
import java.util.Map;

public class Assignment {

    private String assignmentTitle;
    private String dueDate;
    private String submittedBy;
    private Map<String, String> grades;  // New map to store grades for each student

    public Assignment(String assignmentTitle, String dueDate) {
        this.assignmentTitle = assignmentTitle;
        this.dueDate = dueDate;
        this.submittedBy = null;
        this.grades = new HashMap<>();  // Initialize the grades map
    }

    public void submit(String studentId) {
        this.submittedBy = studentId;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;  // Allow updating due date
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    // New method to assign a grade to a student
    public void assignGrade(String studentId, String grade) {
        grades.put(studentId, grade);
    }

    // New method to get a student's grade
    public String getGrade(String studentId) {
        return grades.get(studentId);
    }
}
