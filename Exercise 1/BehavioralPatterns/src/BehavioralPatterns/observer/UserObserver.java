package BehavioralPatterns.observer;

public class UserObserver implements Observer {
    private String username;

    public UserObserver(String username) {
        this.username = username;
    }

    @Override
    public void update(String documentContent) {
        System.out.println(username + " received document update: " + documentContent);
    }
}
