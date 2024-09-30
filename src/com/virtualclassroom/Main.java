package com.virtualclassroom;

import com.virtualclassroom.manager.ClassroomManager;
import com.virtualclassroom.manager.AssignmentManager;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassroomManager classroomManager = ClassroomManager.getInstance(); // Singleton pattern
        AssignmentManager assignmentManager = AssignmentManager.getInstance(); // Singleton pattern

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.println("\nEnter your command:");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            try {
                switch (parts[0].toLowerCase()) {
                    case "add_classroom":
                        handleAddClassroom(parts, classroomManager);
                        break;

                    case "add_student":
                        handleAddStudent(parts, classroomManager);
                        break;

                    case "schedule_assignment":
                        handleScheduleAssignment(parts, assignmentManager);
                        break;

                    case "submit_assignment":
                        handleSubmitAssignment(parts, assignmentManager);
                        break;

                    case "list_assignments":
                        handleListAssignments(parts, assignmentManager);
                        break;

                    case "update_assignment_due_date":
                        handleUpdateAssignmentDueDate(parts, assignmentManager);
                        break;

                    case "exit":
                        System.out.println("Exiting Virtual Classroom Manager.");
                        Logger.logInfo("Exited the Virtual Classroom Manager.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Unknown command. Please try again.");
                        break;
                }
            } catch (Exception e) {
                Logger.logError("An error occurred: " + e.getMessage());
                System.out.println("An error occurred. Please try again.");
            }
        }
    }

    // Handlers for different commands

    private static void handleAddClassroom(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.addClassroom(className);
            Logger.logInfo("Added classroom: " + className);
        } else {
            System.out.println("Invalid command. Usage: add_classroom <class_name>");
        }
    }

    private static void handleAddStudent(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 3 && InputValidator.isValidStudentId(parts[1]) && InputValidator.isValidClassName(parts[2])) {
            String studentId = parts[1];
            String className = parts[2];
            classroomManager.addStudentToClass(studentId, className);
            Logger.logInfo("Added student: " + studentId + " to classroom: " + className);
        } else {
            System.out.println("Invalid command. Usage: add_student <student_id> <class_name>");
        }
    }

    private static void handleScheduleAssignment(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length >= 4 && InputValidator.isValidClassName(parts[1]) && InputValidator.isValidAssignmentTitle(parts[2]) && InputValidator.isValidDueDate(parts[3])) {
            String className = parts[1];
            String assignmentTitle = parts[2];
            String dueDate = parts[3];
            assignmentManager.scheduleAssignment(className, assignmentTitle, dueDate);  // Uses AssignmentFactory internally
            Logger.logInfo("Scheduled assignment for classroom: " + className + " with title: " + assignmentTitle + " (Due: " + dueDate + ")");
        } else {
            System.out.println("Invalid command. Usage: schedule_assignment <class_name> <assignment_title> <due_date>");
        }
    }

    private static void handleSubmitAssignment(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length == 4 && InputValidator.isValidStudentId(parts[1]) && InputValidator.isValidClassName(parts[2]) && InputValidator.isValidAssignmentTitle(parts[3])) {
            String studentId = parts[1];
            String className = parts[2];
            String assignmentTitle = parts[3];
            assignmentManager.submitAssignment(studentId, className, assignmentTitle);
            Logger.logInfo("Submitted assignment: " + assignmentTitle + " by student: " + studentId + " for class: " + className);
        } else {
            System.out.println("Invalid command. Usage: submit_assignment <student_id> <class_name> <assignment_title>");
        }
    }

    private static void handleListAssignments(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            assignmentManager.listAssignments(className);
        } else if (parts.length == 1) {
            assignmentManager.listAllAssignments();
        } else {
            System.out.println("Invalid command. Usage: list_assignments [class_name]");
        }
    }

    private static void handleUpdateAssignmentDueDate(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length == 4 && InputValidator.isValidClassName(parts[1]) && InputValidator.isValidAssignmentTitle(parts[2]) && InputValidator.isValidDueDate(parts[3])) {
            String className = parts[1];
            String assignmentTitle = parts[2];
            String newDueDate = parts[3];
            assignmentManager.updateAssignmentDueDate(className, assignmentTitle, newDueDate);
            Logger.logInfo("Updated due date for assignment: " + assignmentTitle + " in class: " + className);
        } else {
            System.out.println("Invalid command. Usage: update_assignment_due_date <class_name> <assignment_title> <new_due_date>");
        }
    }
}
