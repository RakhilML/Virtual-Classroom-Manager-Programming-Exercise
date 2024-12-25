package com.virtualclassroom;

import com.virtualclassroom.manager.ClassroomManager;
import com.virtualclassroom.manager.AssignmentManager;
import com.virtualclassroom.utils.InputValidator;
import com.virtualclassroom.utils.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassroomManager classroomManager = ClassroomManager.getInstance(); 
        AssignmentManager assignmentManager = AssignmentManager.getInstance(); 

        System.out.println("Welcome to the Virtual Classroom Manager!");
        printAvailableCommands();
        String userRole = getUserRole(scanner); 

        while (true) {
            System.out.println("\nPlease enter your command:");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            try {
                // Handle command based on user role
                switch (parts[0].toLowerCase()) {
                    case "1":
                        if (userRole.equals("teacher")) {
                            handleAddClassroom(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "2":
                        if (userRole.equals("teacher")) {
                            handleRemoveClassroom(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "3":
                        if (userRole.equals("teacher")) {
                            handleAddStudent(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "4":
                        if (userRole.equals("teacher")) {
                            handleListClassrooms(classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "5":
                        if (userRole.equals("teacher")) {
                            handleScheduleAssignment(parts, assignmentManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "6":
                        if (userRole.equals("student")) {
                            handleSubmitAssignment(parts, assignmentManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "7":
                        handleListAssignments(parts, assignmentManager);
                        break;

                    case "8":
                        if (userRole.equals("teacher")) {
                            handleListStudentsInClass(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "9":
                        if (userRole.equals("teacher")) {
                            handleMarkAttendance(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "10":
                        handleListAttendance(parts, classroomManager);
                        break;

                    case "11":
                        if (userRole.equals("teacher")) {
                            handleRemoveStudent(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "12":
                        handleDisplayEnrolledClassrooms(parts, classroomManager);
                        break;

                    case "13":
                        if (userRole.equals("teacher")) {
                            handleAssignGrade(parts, classroomManager);
                        } else {
                            handleUnauthorizedCommand();
                        }
                        break;

                    case "exit":
                        Logger.logInfo("Exited the Virtual Classroom Manager.");
                        scanner.close();
                        return;

                    case "help":
                        printAvailableCommands();
                        break;

                    default:
                        System.out.println("Unknown command. Please try again or type 'help' to see available commands.");
                        break;
                }
            } catch (Exception e) {
                Logger.logError("An error occurred: " + e.getMessage());
            }

            // Clear terminal and print available commands
            try {
                Thread.sleep(2000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                Logger.logError("Sleep interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }

            clearTerminal();
            printAvailableCommands();
        }
    }

    private static String getUserRole(Scanner scanner) {
        System.out.println("Enter your role (teacher/student):");
        return scanner.nextLine().trim().toLowerCase();
    }

    private static void handleUnauthorizedCommand() {
        System.out.println("You do not have permission to execute this command.");
    }

    private static void printAvailableCommands() {
        System.out.println("Available Commands:");
        System.out.println("Teacher Commands:");
        System.out.println("1. add_classroom [ 1 <class_name> ]");
        System.out.println("2. remove_classroom [ 2 <class_name> ]");
        System.out.println("3. add_student [ 3 <student_id> <class_name> ]");
        System.out.println("4. listclassrooms [ 4 ]");
        System.out.println("5. schedule_assignment [ 5 <class_name> <assignment_title> <due_date> ]");
        System.out.println("8. liststudentsinclass [ 8 <class_name> ]");
        System.out.println("9. markattendance [ 9 <student_id> <class_name> ]");
        System.out.println("11. removestudent [ 11 <student_id> <class_name> ]");
        System.out.println("13. assigngrade [ 13 <student_id> <class_name> <grade> <assignment_title> ]");

        System.out.println("\nStudent Commands:");
        System.out.println("6. submit_assignment [ 6 <student_id> <class_name> <assignment_title> ]");
        System.out.println("7. list_assignments [ 7 <class_name> ]");
        System.out.println("10. listattendance [ 10 <class_name> ]");
        System.out.println("12. displayenrolledclassrooms [ 12 <student_id> ]");

        System.out.println("\nOther Commands:");
        System.out.println("14. help - List all available commands.");
        System.out.println("15. exit - Exit the Virtual Classroom Manager.");
    }

    private static void clearTerminal() {
        // Print several newlines to simulate clearing the terminal
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Forces console to flush output
    }

    // Handle methods (unchanged)
    private static void handleAddClassroom(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.addClassroom(className);
        } else {
            System.out.println("Invalid command. Usage: add_classroom <class_name>");
        }
    }

    private static void handleRemoveClassroom(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.removeClassroom(className);
        } else {
            System.out.println("Invalid command. Usage: remove_classroom <class_name>");
        }
    }

    private static void handleAddStudent(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 3 && InputValidator.isValidStudentId(parts[1]) && InputValidator.isValidClassName(parts[2])) {
            String studentId = parts[1];
            String className = parts[2];
            classroomManager.addStudentToClass(studentId, className);
        } else {
            System.out.println("Invalid command. Usage: add_student <student_id> <class_name>");
        }
    }

    private static void handleListClassrooms(ClassroomManager classroomManager) {
        classroomManager.listClassrooms();
        Logger.logInfo("Listed all classrooms.");
    }

    private static void handleScheduleAssignment(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length >= 4 && InputValidator.isValidClassName(parts[1]) 
                               && InputValidator.isValidAssignmentTitle(parts[2]) 
                               && InputValidator.isValidDueDate(parts[3])) {
            String className = parts[1];
            String assignmentTitle = parts[2];
            String dueDate = parts[3];
            assignmentManager.scheduleAssignment(className, assignmentTitle, dueDate);
        } else {
            System.out.println("Invalid command. Usage: schedule_assignment <class_name> <assignment_title> <due_date>");
        }
    }

    private static void handleSubmitAssignment(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length == 4 && InputValidator.isValidStudentId(parts[1]) 
                               && InputValidator.isValidClassName(parts[2]) 
                               && InputValidator.isValidAssignmentTitle(parts[3])) {
            String studentId = parts[1];
            String className = parts[2];
            String assignmentTitle = parts[3];
            assignmentManager.submitAssignment(studentId, className, assignmentTitle);
        } else {
            System.out.println("Invalid command. Usage: submit_assignment <student_id> <class_name> <assignment_title>");
        }
    }

    private static void handleListAssignments(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            assignmentManager.listAssignments(className);
        } else {
            System.out.println("Invalid command. Usage: list_assignments <class_name>");
        }
    }

    private static void handleListStudentsInClass(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.listStudentsInClass(className);
        } else {
            System.out.println("Invalid command. Usage: liststudentsinclass <class_name>");
        }
    }

    private static void handleMarkAttendance(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 3 && InputValidator.isValidClassName(parts[1]) 
                               && InputValidator.isValidStudentId(parts[2])) {
            String className = parts[1];
            String studentId = parts[2];
            boolean isPresent = true;
            classroomManager.markAttendance(className, studentId, isPresent);
            //Logger.logInfo("Attendance marked for student: " + studentId + " in classroom: " + className);
            //System.out.println("Attendance marked for student " + studentId + " in classroom " + className);
        } else {
            System.out.println("Invalid command. Usage: markattendance <class_name> <student_id>");
        }
    }

    private static void handleListAttendance(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.listAttendance(className);
        } else {
            System.out.println("Invalid command. Usage: listattendance <class_name>");
        }
    }

    private static void handleRemoveStudent(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 3 && InputValidator.isValidStudentId(parts[1]) 
                               && InputValidator.isValidClassName(parts[2])) {
            String studentId = parts[1];
            String className = parts[2];
            classroomManager.removeStudent(studentId, className);
            //Logger.logInfo("Removed student: " + studentId + " from classroom: " + className);
            //System.out.println("Student " + studentId + " has been removed from classroom " + className);
        } else {
            System.out.println("Invalid command. Usage: removestudent <student_id> <class_name>");
        }
    }


    private static void handleDisplayEnrolledClassrooms(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidStudentId(parts[1])) {
            String studentId = parts[1];
            classroomManager.displayEnrolledClassrooms(studentId);
        } else {
            System.out.println("Invalid command. Usage: displayenrolledclassrooms <student_id>");
        }
    }

    private static void handleAssignGrade(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 5 && InputValidator.isValidStudentId(parts[1]) 
                               && InputValidator.isValidClassName(parts[2]) 
                               && InputValidator.isValidGrade(parts[3]) 
                               && InputValidator.isValidAssignmentTitle(parts[4])) {
            String studentId = parts[1];
            String className = parts[2];
            String grade = parts[3];
            String assignmentTitle = parts[4];
            classroomManager.assignGrade(studentId, className, grade, assignmentTitle);
        } else {
            System.out.println("Invalid command. Usage: assigngrade <student_id> <class_name> <grade> <assignment_title>");
        }
    }
}
