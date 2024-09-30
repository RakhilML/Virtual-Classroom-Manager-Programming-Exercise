package StructuralPatterns.composite;

public class Lesson extends CourseComponent {
    private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String getName() {
        return lessonName;
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Lesson: " + lessonName);
    }
}
