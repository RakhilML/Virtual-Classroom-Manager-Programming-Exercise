package com.virtualclassroom.models;

public class Assignment {

    private String assignmentTitle;
    private String dueDate;
    private String submittedBy;

    public Assignment(String assignmentTitle, String dueDate) {
        this.assignmentTitle = assignmentTitle;
        this.dueDate = dueDate;
        this.submittedBy = null;
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
}
