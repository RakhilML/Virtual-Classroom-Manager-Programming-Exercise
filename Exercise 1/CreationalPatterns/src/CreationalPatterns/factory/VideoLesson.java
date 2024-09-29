package CreationalPatterns.factory;

public class VideoLesson implements EducationalContent {
    @Override
    public void displayContent() {
        System.out.println("Displaying video lesson contnt.");
    }
}
