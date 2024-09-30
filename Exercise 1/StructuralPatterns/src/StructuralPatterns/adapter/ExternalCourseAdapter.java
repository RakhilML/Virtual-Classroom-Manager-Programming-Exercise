package StructuralPatterns.adapter;

import CreationalPatterns.factory.EducationalContent;

public class ExternalCourseAdapter implements EducationalContent {
    private ExternalCourse externalCourse;

    public ExternalCourseAdapter(ExternalCourse externalCourse) {
        this.externalCourse = externalCourse;
    }

    @Override
    public void displayContent() {
        externalCourse.startCourse();
        externalCourse.playContent();
    }
}
