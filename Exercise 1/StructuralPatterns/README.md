
## **Folder Structure**

The workspace contains two folders by default:

- `src`: the folder to maintain sources.
- `lib`: the folder to maintain dependencies.

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

# **Structural Design Patterns in Java**

## **Overview**
This project demonstrates the implementation of two **Structural Design Patterns** – **Adapter Pattern** and **Composite Pattern**. Both patterns are used in the context of handling educational content

## **Directory Structure**

```plaintext
/StructuralPatterns
    /adapter
        ExternalCourse.java
        ExternalCourseAdapter.java
        Main.java
    /composite
        CourseComponent.java
        Course.java
        Lesson.java
        Main.java
```

# **Patterns Implemented**

## **1. Adapter Pattern**

### **Overview**
The Adapter Pattern is used to integrate external educational content (such as courses from a third-party platform) into the Ei Study platform. This pattern helps convert the external content into a format that is compatible with the system, making it flexible to integrate different types of external courses.

### **Components**
* **ExternalCourse**: Represents a third-party course.
* **EducationalContent Interface**: Defines a method `displayContent()` that should be implemented by all educational content types.
* **ExternalCourseAdapter**: Implements `EducationalContent` by wrapping around the `ExternalCourse` class, adapting its functionality to fit into the Ei Study system.

### **Usage**

1. The system adapts external courses so that they can be displayed alongside native content.
2. This pattern allows easy integration of new external courses without major changes to the system.

### **How to run**

```bash
javac StructuralPatterns/adapter/*.java
java StructuralPatterns.adapter.Main
```

### **Sample output**

```plaintext
Starting the external course: Mathematics for Beginners
Playing content for the external course: Mathematics for Beginners
```

---

## **2. Composite Pattern**

### **Overview**
The Composite Pattern is used to represent complex hierarchical structures such as a course containing multiple lessons and quizzes. Each component of the course (like lessons) can be treated uniformly whether it's a single lesson or an entire course with multiple subcomponents.

### **Components**
* **CourseComponent**: Abstract class that defines methods to add/remove components and display content.
* **Lesson**: Leaf node representing a single lesson in a course.
* **Course**: Composite node that can contain multiple lessons or even sub-courses.

### **Usage**

1. The system can now treat individual lessons and composite courses uniformly.
2. The Composite pattern allows for flexible management of nested educational content.

### **How to run**

```bash
javac StructuralPatterns/composite/*.java
java StructuralPatterns.composite.Main
```

### **Sample output**

```plaintext
Module: Advanced Java Programming
Lesson: Advanced Java Concepts
Module: Java Programming Basics
Lesson: Introduction to Java
Lesson: Object-Oriented Programming in Java
```
