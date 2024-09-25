package com.virtualclassroom.manager;

import com.virtualclassroom.utils.Logger;

public class AssignmentManager {

    public void scheduleAssignment(String className, String assignmentDetails) {
        Logger.log("Assignment for " + className + " has been scheduled: " + assignmentDetails);
    }

    // Need to add the functionality, this class will also handle submission of assignments by students
}
