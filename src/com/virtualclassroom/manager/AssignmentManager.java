package com.virtualclassroom.manager;

import com.virtualclassroom.models.Assignment;
import com.virtualclassroom.utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class AssignmentManager {

    private Map<String, Assignment> assignments = new HashMap<>();

    public void scheduleAssignment(String className, String assignmentTitle, String dueDate) {
        Assignment newAssignment = new Assignment(assignmentTitle, dueDate);
        assignments.put(className + ":" + assignmentTitle, newAssignment);
        Logger.logInfo("Assignment for " + className + " has been scheduled: " + assignmentTitle + " (Due: " + dueDate + ")");
    }

    public void submitAssignment(String studentId, String className, String assignmentTitle) {
        String key = className + ":" + assignmentTitle;
        if (assignments.containsKey(key)) {
            Assignment assignment = assignments.get(key);
            assignment.submit(studentId);
            Logger.logInfo("Assignment '" + assignmentTitle + "' submitted by Student " + studentId + " for " + className + ".");
        } else {
            Logger.logError("Assignment '" + assignmentTitle + "' for " + className + " does not exist.");
        }
    }

    // Method to list all assignments for a specific class
    public void listAssignments(String className) {
        Logger.logInfo("Assignments for " + className + ":");
        assignments.keySet().stream()
            .filter(key -> key.startsWith(className + ":"))
            .forEach(key -> {
                Assignment assignment = assignments.get(key);
                Logger.logInfo("- " + assignment.getAssignmentTitle() + " (Due: " + assignment.getDueDate() + ", Submitted by: " + assignment.getSubmittedBy() + ")");
            });
    }
}
