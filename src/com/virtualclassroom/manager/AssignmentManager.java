package com.virtualclassroom.manager;

import com.virtualclassroom.factory.AssignmentFactory;
import com.virtualclassroom.models.Assignment;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class AssignmentManager {

    private static AssignmentManager instance;

    private Map<String, Map<String, Assignment>> assignmentsByClassroom = new HashMap<>();
    private Map<String, Map<String, String>> submissions = new HashMap<>();

    private AssignmentManager() {}

    public static AssignmentManager getInstance() {
        if (instance == null) {
            instance = new AssignmentManager();
        }
        return instance;
    }

    public void scheduleAssignment(String className, String title, String dueDate) {
        if (!InputValidator.isValidClassName(className) || !InputValidator.isValidAssignmentTitle(title) || !InputValidator.isValidDueDate(dueDate)) {
            Logger.logError("Invalid input for scheduling assignment.");
            return;
        }

        // Using AssignmentFactory to create assignment instances
        Assignment assignment = AssignmentFactory.createAssignment(title, dueDate);

        assignmentsByClassroom.computeIfAbsent(className, k -> new HashMap<>()).put(title, assignment);
        Logger.logInfo("Scheduled assignment: " + title + " for classroom: " + className + " (Due: " + dueDate + ")");
    }

    public void listAssignments(String className) {
        if (!InputValidator.isValidClassName(className)) {
            Logger.logError("Invalid class name.");
            return;
        }

        if (assignmentsByClassroom.containsKey(className)) {
            Map<String, Assignment> assignments = assignmentsByClassroom.get(className);
            Logger.logInfo("Assignments for " + className + ":");
            assignments.forEach((title, assignment) -> Logger.logInfo("- " + title + " (Due: " + assignment.getDueDate() + ")"));
        } else {
            Logger.logInfo("No assignments for " + className + ".");
        }
    }

    public void listAllAssignments() {
        if (assignmentsByClassroom.isEmpty()) {
            Logger.logInfo("No assignments scheduled.");
            return;
        }

        Logger.logInfo("All assignments:");
        assignmentsByClassroom.forEach((className, assignments) -> {
            Logger.logInfo("Class: " + className);
            assignments.forEach((title, assignment) -> Logger.logInfo("- " + title + " (Due: " + assignment.getDueDate() + ")"));
        });
    }

    public void submitAssignment(String studentId, String className, String title) {
        if (!InputValidator.isValidStudentId(studentId) || !InputValidator.isValidClassName(className) || !InputValidator.isValidAssignmentTitle(title)) {
            Logger.logError("Invalid input for submitting assignment.");
            return;
        }

        if (assignmentsByClassroom.containsKey(className) && assignmentsByClassroom.get(className).containsKey(title)) {
            submissions.computeIfAbsent(className, k -> new HashMap<>()).put(studentId, title);
            Logger.logInfo("Assignment: " + title + " submitted by student: " + studentId + " for class: " + className);
        } else {
            Logger.logError("Assignment: " + title + " does not exist in classroom: " + className);
        }
    }

    public void updateAssignmentDueDate(String className, String title, String newDueDate) {
        if (!InputValidator.isValidClassName(className) || !InputValidator.isValidAssignmentTitle(title) || !InputValidator.isValidDueDate(newDueDate)) {
            Logger.logError("Invalid input for updating due date.");
            return;
        }

        if (assignmentsByClassroom.containsKey(className) && assignmentsByClassroom.get(className).containsKey(title)) {
            Assignment assignment = assignmentsByClassroom.get(className).get(title);
            assignment.setDueDate(newDueDate);
            Logger.logInfo("Updated due date for assignment: " + title + " to " + newDueDate + " in class: " + className);
        } else {
            Logger.logError("Assignment: " + title + " does not exist in classroom: " + className);
        }
    }
}
