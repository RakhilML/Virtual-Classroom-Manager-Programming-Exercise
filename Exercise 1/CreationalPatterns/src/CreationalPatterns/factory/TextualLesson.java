package CreationalPatterns.factory;

public class TextualLesson implements EducationalContent {
    @Override
    public void displayContent() {
        System.out.println("Displaying textual lesson content.");
    }
}
