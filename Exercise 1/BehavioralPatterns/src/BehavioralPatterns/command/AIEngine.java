package BehavioralPatterns.command;

import java.util.Random;

public class AIEngine {

    public boolean predictTurnOn() {
        // Simulating a AI prediction for lght control
        return new Random().nextBoolean();
    }
}
