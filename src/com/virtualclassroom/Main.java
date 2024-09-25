package com.virtualclassroom;

import com.virtualclassroom.manager.ClassroomManager;
import com.virtualclassroom.manager.AssignmentManager;
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

            switch (parts[0]) {
                case "add_classroom":
                    if (parts.length == 2) {
                        String className = parts[1];
                        classroomManager.addClassroom(className);
                    } else {
                        System.out.println("Invalid command. Usage: add_classroom <class_name>");
                    }
                    break;

                case "add_student":
                    if (parts.length == 3) {
                        String studentId = parts[1];
                        String className = parts[2];
                        classroomManager.addStudentToClass(studentId, className);
                    } else {
                        System.out.println("Invalid command. Usage: add_student <student_id> <class_name>");
                    }
                    break;

                case "schedule_assignment":
                    if (parts.length >= 3) {
                        String className = parts[1];
                        String assignmentDetails = input.substring(input.indexOf(className) + className.length()).trim();
                        assignmentManager.scheduleAssignment(className, assignmentDetails);
                    } else {
                        System.out.println("Invalid command. Usage: schedule_assignment <class_name> <assignment_details>");
                    }
                    break;

                case "exit":
                    System.out.println("Exiting Virtual Classroom Manager.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }
}
