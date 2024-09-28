package BehavioralPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    private String content;
    private List<Observer> observers;

    public DocumentEditor() {
        this.observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void editDocument(String newContent) {
        this.content = newContent;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(content);
        }
    }
}
