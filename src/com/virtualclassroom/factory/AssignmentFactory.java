package com.virtualclassroom.factory;

import com.virtualclassroom.models.Assignment;
import com.virtualclassroom.utils.Logger;

public class AssignmentFactory {
    
    public static Assignment createAssignment(String title, String dueDate) {
        Logger.logInfo("Creating assignment: " + title + " with due date: " + dueDate);
        return new Assignment(title, dueDate);
    }
}