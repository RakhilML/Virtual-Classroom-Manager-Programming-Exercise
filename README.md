# Please find the DesignPatterns implemented with use cases in the Folder 'Exercise 1'
## Exercise 2 is as follows

# Virtual Classroom Manager - Programming Exercise

## Project Overview

The **Virtual Classroom Manager** is a console-based application designed for managing virtual classrooms in an EdTech environment. The application provides functionalities for classroom management, student enrollment, assignment scheduling, and tracking. It follows **SOLID principles** and uses various **design patterns** for a clean, maintainable codebase.

## Features

### 1. Classroom Management
- Create and remove virtual classrooms.
- Enroll students by prompting for their name and ID.
- List all students enrolled in a classroom.

### 2. Assignment Management
- Schedule assignments with due dates.
- Submit assignments for a specific classroom.
- Update due dates of assignments.
- List all assignments for a classroom or across all classrooms.

### 3. Logging and Input Validation
- Comprehensive logging using the custom `Logger` class, recording all operations and errors in `logs/application.log`.
- Input validation through `InputValidator` class, ensuring proper classroom names, student IDs, and assignment details.

### 4. Design Patterns Used
- **Factory Pattern**: Used in `AssignmentFactory.java` to create different types of assignments.
- **Singleton Pattern**: Used in `Logger.java` to ensure only one instance of the logging system is running.
- **Observer Pattern**: Could be extended for notifying students when a new assignment is added.
- **Strategy Pattern**: Used for handling different validation strategies in `InputValidator.java`.

## Project Structure

```
VirtualClassroomManager/
├── src/
│   ├── com/
│   │   └── virtualclassroom/
│   │       ├── Main.java
│   │       ├── manager/
│   │       │   ├── ClassroomManager.java
│   │       │   └── AssignmentManager.java
│   │       ├── models/
│   │       │   ├── Classroom.java
│   │       │   ├── Student.java
│   │       │   └── Assignment.java
│   │       ├── factory/
│   │       │   └── AssignmentFactory.java
│   │       └── utils/
│   │           ├── Logger.java
│   │           ├── InputValidator.java
├── logs/
│   └── application.log
```

### Key Files:
- `Main.java`: Entry point of the application.
- `ClassroomManager.java`: Manages classroom operations like creating and listing classrooms.
- `AssignmentManager.java`: Manages assignment operations, such as scheduling and updating assignments.
- `Classroom.java`: Model class for a virtual classroom.
- `Student.java`: Model class for a student.
- `Assignment.java`: Model class for assignments.
- `Logger.java`: Singleton class for logging.
- `InputValidator.java`: Handles validation of inputs.
- `AssignmentFactory.java`: Uses the Factory Pattern to create assignments.

## How to Run the Application


### Steps:
1. Clone the repository or download the project files to your machine.
```bash
git clone https://github.com/RakhilML/Virtual-Classroom-Manager-Programming-Exercise
cd VirtualClassroomManager
javac -d bin src/com/virtualclassroom/*.java
java -cp bin com.virtualclassroom.Main
```


## Commands and Functionalities

### Classroom Management:
- **Create a classroom**:
    ```bash
    add_classroom [class_name]
    ```
    Example: `add_classroom Mathematics`

- **Enroll a student**:
    ```bash
    add_student [student_id] [class_name]
    ```
    Example: `add_student 101 Mathematics`



### Assignment Management:
- **Schedule an assignment**:
    ```bash
    schedule_assignment [class_name] [assignment_title] [due_date]
    ```
    Example: `schedule_assignment Mathematics Algebra_Homework 2024-10-05`

- **Submit an assignment**:
    ```bash
    submit_assignment [student_id] [class_name] [assignment_title]
    ```
    Example: `submit_assignment 101 Mathematics Algebra_Homework`

## Logging and Error Handling
- All operations and errors are logged in `logs/application.log` using the `Logger` class. This ensures traceability of actions and helps in debugging.

## Sample console-output

### Commands description
# Please find the DesignPatterns implemented with use cases in the Folder 'Exercise 1'
## Exercise 2 is as follows

# Virtual Classroom Manager - Programming Exercise

## Project Overview

The **Virtual Classroom Manager** is a console-based application designed for managing virtual classrooms in an EdTech environment. The application provides functionalities for classroom management, student enrollment, assignment scheduling, and tracking. It follows **SOLID principles** and uses various **design patterns** for a clean, maintainable codebase.

## Features

### 1. Classroom Management
- Create and remove virtual classrooms.
- Enroll students by prompting for their name and ID.
- List all students enrolled in a classroom.

### 2. Assignment Management
- Schedule assignments with due dates.
- Submit assignments for a specific classroom.
- Update due dates of assignments.
- List all assignments for a classroom or across all classrooms.

### 3. Logging and Input Validation
- Comprehensive logging using the custom `Logger` class, recording all operations and errors in `logs/application.log`.
- Input validation through `InputValidator` class, ensuring proper classroom names, student IDs, and assignment details.

### 4. Design Patterns Used
- **Factory Pattern**: Used in `AssignmentFactory.java` to create different types of assignments.
- **Singleton Pattern**: Used in `Logger.java` to ensure only one instance of the logging system is running.
- **Observer Pattern**: Could be extended for notifying students when a new assignment is added.
- **Strategy Pattern**: Used for handling different validation strategies in `InputValidator.java`.

## Project Structure

```
VirtualClassroomManager/
├── src/
│   ├── com/
│   │   └── virtualclassroom/
│   │       ├── Main.java
│   │       ├── manager/
│   │       │   ├── ClassroomManager.java
│   │       │   └── AssignmentManager.java
│   │       ├── models/
│   │       │   ├── Classroom.java
│   │       │   ├── Student.java
│   │       │   └── Assignment.java
│   │       ├── factory/
│   │       │   └── AssignmentFactory.java
│   │       └── utils/
│   │           ├── Logger.java
│   │           ├── InputValidator.java
├── logs/
│   └── application.log
```

### Key Files:
- `Main.java`: Entry point of the application.
- `ClassroomManager.java`: Manages classroom operations like creating and listing classrooms.
- `AssignmentManager.java`: Manages assignment operations, such as scheduling and updating assignments.
- `Classroom.java`: Model class for a virtual classroom.
- `Student.java`: Model class for a student.
- `Assignment.java`: Model class for assignments.
- `Logger.java`: Singleton class for logging.
- `InputValidator.java`: Handles validation of inputs.
- `AssignmentFactory.java`: Uses the Factory Pattern to create assignments.

## How to Run the Application


### Steps:
1. Clone the repository or download the project files to your machine.
```bash
git clone https://github.com/RakhilML/Virtual-Classroom-Manager-Programming-Exercise/tree/main
cd Virtual-Classroom-Manager-Programming-Exercise
cd VirtualClassroomManager
java -cp bin com.virtualclassroom.Main
```


## Commands and Functionalities

### Classroom Management:
- **Create a classroom**:
    ```bash
    add_classroom [class_name]
    ```
    Example: `add_classroom Mathematics`

- **Enroll a student**:
    ```bash
    add_student [student_id] [class_name]
    ```
    Example: `add_student 101 Mathematics`



### Assignment Management:
- **Schedule an assignment**:
    ```bash
    schedule_assignment [class_name] [assignment_title] [due_date]
    ```
    Example: `schedule_assignment Mathematics Algebra_Homework 2024-10-05`

- **Submit an assignment**:
    ```bash
    submit_assignment [student_id] [class_name] [assignment_title]
    ```
    Example: `submit_assignment 101 Mathematics Algebra_Homework`

## Logging and Error Handling
- All operations and errors are logged in `logs/application.log` using the `Logger` class. This ensures traceability of actions and helps in debugging.

## Sample console-output

### Commands description
![image](https://github.com/user-attachments/assets/521d7e61-88bb-4f0f-bdb3-36cf855b6a4c)


### adding classrooms
![image](https://github.com/user-attachments/assets/a5c27533-302f-49e8-bde9-01bc8e7d9be0)


### adding students
![image](https://github.com/user-attachments/assets/5ac77d8f-c0dd-41bc-a673-fb6c3b4e07fe)


### schedule assignments
![image](https://github.com/user-attachments/assets/b4bdb9aa-b6f1-44ed-bb55-0f330f581cb4)


### submit assignments
![image](https://github.com/user-attachments/assets/5286b05a-cd49-45b5-a63d-27cc757d2571)


## Additional Implementations

- **List of all classrooms**:
    ```bash
    listclassrooms
    ```

- **List all students in a classroom**:
    ```bash
    list_students [class_name]
    ```

- **Remove a classroom**:
    ```bash
    remove_classroom [class_name]
    ```

- **List all assignments for a classroom or all classrooms**:
    ```bash
    list_assignments [class_name (optional)]
    ```
    Example: `list_assignments Mathematics`

- **Mark Attendance for students**:
    ```bash
     markattendance <class_name> <student_id>
    ```
    Example: `markattendance BatchA S1`

- **Assigning grade**:
    ```bash
     assigngrade <student_id> <class_name> <grade> <assignment_title>
    ```
    Example: `markattendance BatchA S1`

## Sample console-output

### list of classrooms
![image](https://github.com/user-attachments/assets/d28c25e8-6adc-493c-a4c6-e2f8470bc6f5)


### list of assignments
![image](https://github.com/user-attachments/assets/3797610e-9648-4992-a3d7-08aa3e94f39b)


### list of students in class
![image](https://github.com/user-attachments/assets/ee5a31be-5f1a-415c-8892-db2162de03cf)


Gives the student enrolled classes.

### mark attendance
![image](https://github.com/user-attachments/assets/026a0794-5ac9-462f-a339-261e64897498)


### assigning grade
![image](https://github.com/user-attachments/assets/d85b9672-ee7c-42d5-9712-611897e95b1a)


