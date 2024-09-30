package StructuralPatterns.adapter;

public class ExternalCourse {
    private String courseName;

    public ExternalCourse(String courseName) {
        this.courseName = courseName;
    }

    public void startCourse() {
        System.out.println("Starting the external course: " + courseName);
    }

    public void playContent() {
        System.out.println("Playing content for the external course: " + courseName);
    }
}
