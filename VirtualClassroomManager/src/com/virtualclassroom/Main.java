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
        printAvailableCommands();

        while (true) {
            System.out.println("\nPlease enter your command:");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            try {
                switch (parts[0].toLowerCase()) {
                    case "add_classroom":
                        handleAddClassroom(parts, classroomManager);
                        break;

                    case "remove_classroom":
                        handleRemoveClassroom(parts, classroomManager);
                        break;

                    case "add_student":
                        handleAddStudent(parts, classroomManager);
                        break;

                    case "listclassrooms":
                        handleListClassrooms(classroomManager);
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

                    case "liststudentsinclass":
                        handleListStudentsInClass(parts, classroomManager);
                        break;

                    case "markattendance":
                        handleMarkAttendance(parts, classroomManager);
                        break;

                    case "listattendance":
                        handleListAttendance(parts, classroomManager);
                        break;

                    case "removestudent":
                        handleRemoveStudent(parts, classroomManager);
                        break;

                    case "displayenrolledclassrooms":
                        handleDisplayEnrolledClassrooms(parts, classroomManager);
                        break;

                    case "assigngrade":
                        handleAssignGrade(parts, classroomManager);
                        break;

                    case "exit":
                        //System.out.println("Exiting Virtual Classroom Manager. Goodbye!");
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
                //System.out.println("An error occurred. Please try again.");
            }
        }
    }

    private static void printAvailableCommands() {
        System.out.println("Available Commands:");
        System.out.println("1. add_classroom <class_name>");
        System.out.println("2. remove_classroom <class_name>");
        System.out.println("3. add_student <student_id> <class_name>");
        System.out.println("4. listclassrooms");
        System.out.println("5. schedule_assignment <class_name> <assignment_title> <due_date>");
        System.out.println("6. submit_assignment <student_id> <class_name> <assignment_title>");
        System.out.println("7. list_assignments [class_name]");
        System.out.println("8. liststudentsinclass <class_name>");
        System.out.println("9. markattendance <student_id> <class_name>");
        System.out.println("10. listattendance <class_name>");
        System.out.println("11. removestudent <student_id> <class_name>");
        System.out.println("12. displayenrolledclassrooms <student_id>");
        System.out.println("13. assigngrade <student_id> <class_name> <grade> <assignment_title>");
        System.out.println("14. help - List all available commands.");
        System.out.println("15. exit - Exit the Virtual Classroom Manager.");
    }

    private static void handleAddClassroom(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.addClassroom(className);
            Logger.logInfo("Added classroom: " + className);
            // System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Invalid command. Usage: add_classroom <class_name>");
        }
    }

    private static void handleRemoveClassroom(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.removeClassroom(className);
            Logger.logInfo("Removed classroom: " + className);
            // System.out.println("Classroom " + className + " has been successfully removed.");
        } else {
            System.out.println("Invalid command. Usage: remove_classroom <class_name>");
        }
    }

    private static void handleAddStudent(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 3 && InputValidator.isValidStudentId(parts[1]) && InputValidator.isValidClassName(parts[2])) {
            String studentId = parts[1];
            String className = parts[2];
            classroomManager.addStudentToClass(studentId, className);
            Logger.logInfo("Added student: " + studentId + " to classroom: " + className);
            // System.out.println("Student " + studentId + " has been enrolled in " + className);
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
            Logger.logInfo("Scheduled assignment for classroom: " + className + " with title: " + assignmentTitle + " (Due: " + dueDate + ")");
            //System.out.println("Assignment " + assignmentTitle + " for " + className + " has been scheduled with due date " + dueDate);
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
            //Logger.logInfo("Assignment: " + assignmentTitle + " submitted by " + studentId + " in class: " + className);
            //System.out.println("Assignment " + assignmentTitle + " submitted by " + studentId + " in class " + className);
        } else {
            System.out.println("Invalid command. Usage: submit_assignment <student_id> <class_name> <assignment_title>");
        }
    }

    private static void handleListAssignments(String[] parts, AssignmentManager assignmentManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            assignmentManager.listAssignments(className);
            Logger.logInfo("Listed assignments for class: " + className);
        } else {
            System.out.println("Invalid command. Usage: list_assignments <class_name>");
        }
    }

    private static void handleListStudentsInClass(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.listStudentsInClass(className);
            Logger.logInfo("Listed students in class: " + className);
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
            Logger.logInfo("Attendance marked for student: " + studentId + " in classroom: " + className);
            //System.out.println("Attendance marked for student " + studentId + " in classroom " + className);
        } else {
            System.out.println("Invalid command. Usage: markattendance <class_name> <student_id>");
        }
    }

    private static void handleListAttendance(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidClassName(parts[1])) {
            String className = parts[1];
            classroomManager.listAttendance(className);
            Logger.logInfo("Listed attendance for class: " + className);
        } else {
            System.out.println("Invalid command. Usage: listattendance <class_name>");
        }
    }

    // private static void handleListAllAssignments(AssignmentManager assignmentManager) {
    //     assignmentManager.listAllAssignments();
    // }

    private static void handleRemoveStudent(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 3 && InputValidator.isValidStudentId(parts[1]) 
                               && InputValidator.isValidClassName(parts[2])) {
            String studentId = parts[1];
            String className = parts[2];
            classroomManager.removeStudent(studentId, className);
            Logger.logInfo("Removed student: " + studentId + " from classroom: " + className);
            //System.out.println("Student " + studentId + " has been removed from classroom " + className);
        } else {
            System.out.println("Invalid command. Usage: removestudent <student_id> <class_name>");
        }
    }

    private static void handleDisplayEnrolledClassrooms(String[] parts, ClassroomManager classroomManager) {
        if (parts.length == 2 && InputValidator.isValidStudentId(parts[1])) {
            String studentId = parts[1];
            classroomManager.displayEnrolledClassrooms(studentId);
            Logger.logInfo("Displayed enrolled classrooms for student: " + studentId); 
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
            String assignmentTitle = parts[4]; // New parameter
            classroomManager.assignGrade(studentId, className, grade, assignmentTitle);
            Logger.logInfo("Assigned grade " + grade + " to student: " + studentId + " in classroom: " + className + " for assignment: " + assignmentTitle);
            //System.out.println("Grade " + grade + " has been assigned to student " + studentId + " in classroom " + className + " for assignment " + assignmentTitle);
        } else {
            System.out.println("Invalid command. Usage: assigngrade <student_id> <class_name> <grade> <assignment_title>");
        }
    }
    
}
