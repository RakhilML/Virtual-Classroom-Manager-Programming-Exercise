package com.virtualclassroom.models;

import java.util.HashMap;
import java.util.Map;
import com.virtualclassroom.utils.Logger;

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
        if (submittedBy == null) {
            this.submittedBy = studentId;
            Logger.logInfo("Assignment " + assignmentTitle + " submitted by student " + studentId);
        } else {
            Logger.logError("Assignment " + assignmentTitle + " has already been submitted by " + submittedBy);
        }
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
        Logger.logInfo("Grade " + grade + " assigned to student " + studentId + " for assignment " + assignmentTitle);
    }

    public String getGrade(String studentId) {
        return grades.get(studentId);
    }
}

