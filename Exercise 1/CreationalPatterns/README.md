## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

# **Creational Design Patterns in java**

## **Overview**
This project demonstrates the implementation of two **Creational Design Patterns** – **Factory Method** and **Singleton**. The examples are tailored to handle educational content dynamically and manage global performance data efficiently.

## Directory Structure

```plaintext
/CreationalPatterns
    /factory
        ContentFactory.java
        EducationalContent.java
        TextualLesson.java
        VideoLesson.java
        InteractiveExercise.java
        Main.java
    /singleton
        PerformanceTracker.java
        Main.java
```

# **Patterns Implemented**

## **1. Factory Method Pattern: Dynamic Educational Content Creation**

### **Overview**
The Factory Method Pattern is used to create different types of educational content (text, video, and interactive exercises) based on the student's learning style. This pattern provides a flexible approach to dynamically generate content without tightly coupling the client code to specific content types.

### **Components**
* EducationalContent Interface: Defines a common method displayContent() for all content types.
* TextualLesson: Implements EducationalContent to display textual content.
* VideoLesson: Implements EducationalContent to display video content.
* InteractiveExercise: Implements EducationalContent to display interactive exercises.
* ContentFactory: A factory class that dynamically creates content based on the learning style input.

### **Usage**

1. The system creates content based on the student's learning style, allowing for extensibility and flexibility.
2. New content types can easily be added without changing the factory or client code.

### **How to run**

```
javac CreationalPatterns/factory/*.java
java CreationalPatterns.factory.Main
```

### **Sample output**

```
Displaying textual lesson content.
Displaying video lesson content.
Displaying interactive exercise.
```

## **2. Singleton Pattern: Global Performance Tracker**

### **Overview**
The Singleton Pattern ensures that only one instance of the PerformanceTracker class exists across the entire platform. This is useful for maintaining consistent performance data (e.g., completed courses, quiz scores) globally across different parts of the system.

### **Components**
* PerformanceTracker Singleton: A class that tracks the performance of students across the platform, such as completed courses and quiz scores.
* getInstance() Method: Ensures thread-safe access to the singleton instance.

### **Usage**
1. The Singleton pattern ensures that the same instance of PerformanceTracker is used across the system.
2. All performance data is tracked globally, ensuring consistency and accuracy.

### **How to run**

```
javac CreationalPatterns/singleton/*.java
java CreationalPatterns.singleton.Main
```

The program will simulate performance tracking for a student and show that only one instance of PerformanceTracker is used throughout.

### **Sample output**
```
Courses completed: 1
Current total quiz score: 85
Courses completed: 2
Current total quiz score: 175
Performance Data -> Completed Courses: 2, Total Quiz Scores: 175
Performance Data -> Completed Courses: 2, Total Quiz Scores: 175
```

# **Use cases for both the Patters**
1. Factory Method:

    * Flexibility to add new content types (e.g., quizzes, live sessions) in the future.
    * Dynamically provides different types of content to suit the needs of individual students' learning preferences.
2. Singleton:

    * Ensures consistency in performance data across the platform.
    * Suitable for real-time performance tracking across various modules like courses, quizzes, and progress reports.
