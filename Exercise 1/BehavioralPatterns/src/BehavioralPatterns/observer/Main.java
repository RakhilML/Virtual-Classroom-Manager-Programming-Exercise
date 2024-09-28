package BehavioralPatterns.observer;

public class Main {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();

        Observer user1 = new UserObserver("User 1");
        Observer user2 = new UserObserver("User 2");

        editor.subscribe(user1);
        editor.subscribe(user2);

        editor.editDocument("First draft of the document.");
        editor.editDocument("Second draft of the document.");
    }
}
