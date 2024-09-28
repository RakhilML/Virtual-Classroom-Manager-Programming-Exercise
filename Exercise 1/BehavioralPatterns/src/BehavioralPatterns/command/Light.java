package BehavioralPatterns.command;

public class Light {
    private String room;

    public Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        System.out.println("Turning on lights in " + room);
    }

    public void turnOff() {
        System.out.println("Turning off lights in " + room);
    }
}
