package com.virtualclassroom.manager;

import com.virtualclassroom.models.Assignment;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class AssignmentManager {

    private Map<String, Assignment> assignments = new HashMap<>();

    public void scheduleAssignment(String className, String assignmentTitle, String dueDate) {
        // Validate assignment details
        if (!InputValidator.isValidClassName(className) || !InputValidator.isValidAssignmentTitle(assignmentTitle) || !InputValidator.isValidDueDate(dueDate)) {
            Logger.logError("Invalid input for scheduling assignment.");
            return;
        }
        
        Assignment newAssignment = new Assignment(assignmentTitle, dueDate);
        assignments.put(className + ":" + assignmentTitle, newAssignment);
        Logger.logInfo("Assignment for " + className + " has been scheduled: " + assignmentTitle + " (Due: " + dueDate + ")");
    }

    public void submitAssignment(String studentId, String className, String assignmentTitle) {
        // Validate inputs
        if (!InputValidator.isValidStudentId(studentId) || !InputValidator.isValidClassName(className) || !InputValidator.isValidAssignmentTitle(assignmentTitle)) {
            Logger.logError("Invalid input for submitting assignment.");
            return;
        }

        String key = className + ":" + assignmentTitle;
        if (assignments.containsKey(key)) {
            Assignment assignment = assignments.get(key);
            assignment.submit(studentId);
            Logger.logInfo("Assignment '" + assignmentTitle + "' submitted by Student " + studentId + " for " + className + ".");
        } else {
            Logger.logError("Assignment '" + assignmentTitle + "' for " + className + " does not exist.");
        }
    }

    public void listAssignments(String className) {
        // Validate class name
        if (!InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid class name for listing assignments.");
            return;
        }

        Logger.logInfo("Assignments for " + className + ":");
        assignments.keySet().stream()
            .filter(key -> key.startsWith(className + ":"))
            .forEach(key -> {
                Assignment assignment = assignments.get(key);
                Logger.logInfo("- " + assignment.getAssignmentTitle() + " (Due: " + assignment.getDueDate() + ", Submitted by: " + assignment.getSubmittedBy() + ")");
            });
    }

    public void listAllAssignments() {
        if (assignments.isEmpty()) {
            Logger.logInfo("No assignments available.");
            return;
        }

        Logger.logInfo("All Assignments:");
        assignments.forEach((key, assignment) -> {
            String[] parts = key.split(":");
            String className = parts[0];
            Logger.logInfo("- Class: " + className + " | Assignment: " + assignment.getAssignmentTitle() + " (Due: " + assignment.getDueDate() + ", Submitted by: " + assignment.getSubmittedBy() + ")");
        });
    }
}
