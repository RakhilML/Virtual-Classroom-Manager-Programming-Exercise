# Please find the DesignPatterns implemented with use cases in the Folder 'Exercise 1'
## Exercise 2 is as follows
# Virtual-Classroom-Manager-Programming-Exercise
The task is to create a terminal-based Virtual Classroom Manager that handles class scheduling, student attendance, and assignment submissions.

# Virtual Classroom Manager

## Project Overview
The Virtual Classroom Manager is a terminal-based application designed for an EdTech platform that facilitates the management of virtual classrooms. It allows users to create classrooms, enroll students, manage assignments, and track student progress effectively.

## Features
- **Classroom Management**: 
  - Add, list, and remove virtual classrooms.
  - Enroll students in classrooms by dynamically prompting for the student's name.
  - View the list of students in a classroom.
- **Assignment Management**: 
  - Schedule assignments for classrooms.
  - Submit assignments as a student.
  - List all assignments for a specific classroom or across all classrooms.
  - Update the due date of assignments.
- **Logging and Input Validation**: 
  - Comprehensive logging for all actions with error handling.
  - Input validation for classroom names, student IDs, assignment titles, and due dates.
  - Dynamic user input for student names during enrollment.

## Functional Requirements
- Users can create classrooms using the command: 
  ``` 
  add_classroom [class_name]
  ```
- Users can enroll students using the command: 
  ``` 
  add_student [student_id] [class_name]
  ```
  The application will dynamically prompt for the student's name.
- Users can schedule assignments using the command: 
  ``` 
  schedule_assignment [class_name] [assignment_title] [due_date]
  ```
- Users can submit assignments using the command: 
  ``` 
  submit_assignment [student_id] [class_name] [assignment_title]
  ```
- Users can list all assignments for a specific classroom or all classrooms using the command: 
  ``` 
  list_assignments [class_name (optional)]
  ```
- Users can update the due date of assignments using the command: 
  ``` 
  update_assignment_due_date [class_name] [assignment_title] [new_due_date]
  ```

## Current State
- **Number of Classrooms**: Dynamic, based on usage.
- **Number of Students**: Dynamic, based on enrollment.
- **Number of Assignments**: Dynamic, based on assignment scheduling.

## How to Run
1. Navigate to the project directory:
    ``` 
    cd [project_directory]
    ```
2. Compile and run the Java application:
    ``` 
    javac -d bin src/com/virtualclassroom/*.java
    java -cp bin com.virtualclassroom.Main
    ```

## Additional Information
- Ensure all logs are saved in `logs/application.log`.

