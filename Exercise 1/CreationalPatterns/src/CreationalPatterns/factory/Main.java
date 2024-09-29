package CreationalPatterns.factory;

public class Main {
    public static void main(String[] args) {
        ContentFactory factory = new ContentFactory();

        // Creating differnt types of content based on learning style
        EducationalContent textContent = factory.createContent("textual");
        EducationalContent videoContent = factory.createContent("video");
        EducationalContent interactiveContent = factory.createContent("interactive");

        // Display content
        textContent.displayContent();
        videoContent.displayContent();
        interactiveContent.displayContent();
    }
}
