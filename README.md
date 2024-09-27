# Virtual-Classroom-Manager-Programming-Exercise
The task is to create a terminal-based Virtual Classroom Manager that handles class scheduling, student attendance, and assignment submissions.

# Virtual Classroom Manager

## Project Overview
The Virtual Classroom Manager is a terminal-based application designed for an EdTech platform that facilitates the management of virtual classrooms. It allows users to create classrooms, enroll students, and manage assignments effectively.

## Features
- **Classroom Management**: Add and list virtual classrooms.
- **Student Management**: Enroll students into classrooms and list students within each classroom.
- **Assignment Management**: Schedule assignments for classrooms and allow students to submit them.
- **Logging and Input Validation**: Implemented logging mechanisms for actions and input validations to enhance reliability.

## Functional Requirements
- Users can create classrooms using the command: `add_classroom [class_name]`
- Users can enroll students using the command: `add_student [student_id] [class_name]`
- Users can schedule assignments using the command: `schedule_assignment [class_name] [assignment_title] [due_date]`
- Users can list all classrooms and enrolled students.

## Current State
- **Number of Classrooms**: 0
- **Number of Students**: 0
- **Number of Assignments**: 0

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

