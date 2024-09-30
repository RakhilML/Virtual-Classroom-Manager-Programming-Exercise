package StructuralPatterns.composite;

public abstract class CourseComponent {
    public void add(CourseComponent courseComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(CourseComponent courseComponent) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void displayCourseInfo() {
        throw new UnsupportedOperationException();
    }
}
