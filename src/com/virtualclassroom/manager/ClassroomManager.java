package com.virtualclassroom.manager;

import com.virtualclassroom.models.Classroom;
import com.virtualclassroom.utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {

    private Map<String, Classroom> classrooms = new HashMap<>();

    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            Classroom newClassroom = new Classroom(className);
            classrooms.put(className, newClassroom);
            Logger.log("Classroom " + className + " has been created.");
        } else {
            Logger.log("Classroom " + className + " already exists.");
        }
    }

    public void addStudentToClass(String studentId, String className) {
        if (classrooms.containsKey(className)) {
            Classroom classroom = classrooms.get(className);
            classroom.addStudent(studentId);
            Logger.log("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            Logger.log("Classroom " + className + " does not exist.");
        }
    }

    // need to add more methods as needed for listing/removing classrooms and students
}
