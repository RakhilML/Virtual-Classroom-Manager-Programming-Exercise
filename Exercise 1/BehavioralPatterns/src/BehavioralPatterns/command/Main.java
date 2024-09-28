package BehavioralPatterns.command;

public class Main {
    public static void main(String[] args) {
        SmartHomeController smartController = new SmartHomeController();
        smartController.controlLights();
    }
}

