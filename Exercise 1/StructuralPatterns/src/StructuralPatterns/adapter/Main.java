package StructuralPatterns.adapter;

import CreationalPatterns.factory.EducationalContent;

public class Main {
    public static void main(String[] args) {
        // External course coming from a third-party platform
        ExternalCourse externalCourse = new ExternalCourse("Mathematics for Beginners");
        
        // Adapting the external course to fit into our EducationalContent interface
        EducationalContent adaptedCourse = new ExternalCourseAdapter(externalCourse);
        
        // Displaying the content via the adapter
        adaptedCourse.displayContent();
    }
}
