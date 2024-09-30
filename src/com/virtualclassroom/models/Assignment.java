package com.virtualclassroom.models;

import java.util.HashMap;
import java.util.Map;

public class Assignment {

    private String assignmentTitle;
    private String dueDate;
    private String submittedBy;
    private Map<String, String> grades;

    public Assignment(String assignmentTitle, String dueDate) {
        this.assignmentTitle = assignmentTitle;
        this.dueDate = dueDate;
        this.submittedBy = null;
        this.grades = new HashMap<>();
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
        this.dueDate = dueDate;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void assignGrade(String studentId, String grade) {
        grades.put(studentId, grade);
    }

    public String getGrade(String studentId) {
        return grades.get(studentId);
    }
}
