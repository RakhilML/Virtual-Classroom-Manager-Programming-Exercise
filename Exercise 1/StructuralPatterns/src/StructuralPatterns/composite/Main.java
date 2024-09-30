package StructuralPatterns.composite;

public class Main {
    public static void main(String[] args) {
        // Creating individual lessons
        Lesson lesson1 = new Lesson("Introduction to Java");
        Lesson lesson2 = new Lesson("Object-Oriented Programming in Java");
        Lesson lesson3 = new Lesson("Advanced Java Concepts");

        // Creating a module and adding lessons to it
        Module module1 = new Module("Java Programming Basics");
        module1.add(lesson1);
        module1.add(lesson2);

        // Creating another module and adding both lessons and another module
        Module module2 = new Module("Advanced Java Programming");
        module2.add(lesson3);
        module2.add(module1); // Nested module

        // Displaying the full course structure
        module2.displayCourseInfo();
    }
}
