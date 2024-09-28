# Virtual-Classroom-Manager-Programming-Exercise
The task is to create a terminal-based Virtual Classroom Manager that handles class scheduling, student attendance, and assignment submissions.

# Virtual Classroom Manager

## Project Overview
The Virtual Classroom Manager is a terminal-based application designed for an EdTech platform that facilitates the management of virtual classrooms. It allows users to create classrooms, enroll students, and manage assignments effectively.

## Features
- **Classroom Management**: 
  - Add, list, and remove virtual classrooms.
  - Enroll students in classrooms by dynamically prompting for the student name.
- **Assignment Management**: 
  - Schedule assignments for classrooms.
  - Submit assignments as a student.
  - List all assignments for a specific classroom or all classrooms.
- **Logging and Input Validation**: 
  - Comprehensive logging for all actions.
  - Input validation for classroom names, student IDs, assignment titles, and due dates.
  - Dynamic user input for student names when enrolling students.

## Functional Requirements
- Users can create classrooms using the command: `add_classroom [class_name]`
- Users can enroll students using the command: `add_student [student_id] [class_name]`, where the application will prompt for the student's name.
- Users can schedule assignments using the command: `schedule_assignment [class_name] [assignment_title] [due_date]`
- Users can submit assignments using the command: `submit_assignment [student_id] [class_name] [assignment_title]`
- Users can list all classrooms, assignments for a class, and all assignments across classrooms.

## Current State
- **Number of Classrooms**: 0 (dynamic, based on usage)
- **Number of Students**: 0 (dynamic, based on usage)
- **Number of Assignments**: 0 (dynamic, based on usage)

## How to Run
Navigate to the project directory:
``` 
cd [project_directory]
```
Compile and run the Java application:
``` 
javac VirtualClassroomManager.java
```

```  
java VirtualClassroomManager
```

