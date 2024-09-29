package CreationalPatterns.factory;

public class ContentFactory {

    public EducationalContent createContent(String learningStyle) {
        switch (learningStyle.toLowerCase()) {
            case "textual":
                return new TextualLesson();
            case "video":
                return new VideoLesson();
            case "interactive":
                return new InteractiveExercise();
            default:
                throw new IllegalArgumentException("Unknown learning style: " + learningStyle);
        }
    }
}
