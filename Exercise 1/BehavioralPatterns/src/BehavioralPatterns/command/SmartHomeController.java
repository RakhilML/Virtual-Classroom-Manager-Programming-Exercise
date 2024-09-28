package BehavioralPatterns.command;

public class SmartHomeController {
    private CommandInvoker invoker;
    private AIEngine aiEngine;
    private Light light;

    public SmartHomeController() {
        this.invoker = new CommandInvoker();
        this.aiEngine = new AIEngine();
        this.light = new Light("Living Room");
    }

    public void controlLights() {
        if (aiEngine.predictTurnOn()) {
            invoker.setCommand(new TurnOnLightsCommand(light));
        } else {
            invoker.setCommand(new TurnOffLightsCommand(light));
        }
        invoker.executeCommand();
    }
}
