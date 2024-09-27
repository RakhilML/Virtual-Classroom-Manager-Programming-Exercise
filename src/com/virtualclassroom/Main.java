package com.virtualclassroom;

import com.virtualclassroom.manager.ClassroomManager;
import com.virtualclassroom.manager.AssignmentManager;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassroomManager classroomManager = new ClassroomManager();
        AssignmentManager assignmentManager = new AssignmentManager();

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.println("\nEnter your command:");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            try {
                switch (parts[0]) {
                    case "add_classroom":
                        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
                            String className = parts[1];
                            classroomManager.addClassroom(className);
                            Logger.logInfo("Added classroom: " + className);
                        } else {
                            System.out.println("Invalid command. Usage: add_classroom <class_name>");
                        }
                        break;

                    case "add_student":
                        if (parts.length == 3 && InputValidator.isValidStudentId(parts[1]) && InputValidator.isValidClassName(parts[2])) {
                            String studentId = parts[1];
                            String className = parts[2];
                            classroomManager.addStudentToClass(studentId, className);
                            Logger.logInfo("Added student: " + studentId + " to classroom: " + className);
                        } else {
                            System.out.println("Invalid command. Usage: add_student <student_id> <class_name>");
                        }
                        break;

                        case "schedule_assignment":
                        if (parts.length >= 4 && InputValidator.isValidClassName(parts[1])) {
                            String className = parts[1];
                            String assignmentTitle = parts[2];
                            String dueDate = parts[3]; // Get the due date from the command
                            assignmentManager.scheduleAssignment(className, assignmentTitle, dueDate);
                            Logger.logInfo("Scheduled assignment for classroom: " + className + " with title: " + assignmentTitle + " (Due: " + dueDate + ")");
                        } else {
                            System.out.println("Invalid command. Usage: schedule_assignment <class_name> <assignment_title> <due_date>");
                        }
                    
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
}
