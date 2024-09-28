## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

# **Behavioral Design Patterns in Java**

## **Overview**

This project demonstrates two behavioral design patterns — **Observer** and **Command** — in Java. Each pattern is implemented in a real-world scenario to provide a deeper understanding of how these patterns can be applied effectively.

### **Project Structure**
The project is structured as follows:

```plaintext
/BehavioralPatterns
    /observer
        DocumentEditor.java
        Observer.java
        UserObserver.java
        Main.java          // Test for Observer Pattern
    /command
        Command.java
        CommandInvoker.java
        TurnOnLightsCommand.java
        TurnOffLightsCommand.java
        SmartHomeController.java
        Light.java
        AIEngine.java
        Main.java          // Test for Command Pattern
```

* The Observer pattern demonstrates a real-time collaborative document editing system where multiple users (observers) are notified of changes to the document (subject).

* The Command pattern demonstrates an AI-driven smart home automation system where commands for turning on and off lights are issued based on AI-driven predictions.

# **Patterns Implemented**

## **1. Observer Pattern**

Use Case: Real-Time Collaborative Document Editing

* Scenario: Multiple users are editing the same document simultaneously. When one user makes changes, all other users are notified of the update.
* Key Classes:
    * Observer Interface: Defines the update method to be implemented by classes that need to be notified of changes.
    * UserObserver Class: Implements the Observer interface and reacts to document updates.
    * DocumentEditor Class: Acts as the subject that keeps track of document changes and notifies all subscribed observers when the document is modified.

### **How it Works**

1. Users subscribe to a document by adding themselves as observers.
2. When the document content is edited, all observers are notified of the change.
3. Each observer receives the new document content.

### **Main Class to Run**

* Run the <code>Main.java</code> in the <code>observer</code> package to test the collaborative document system.

### **Example Output**
```
User 1 received document update: First draft of the document.
User 2 received document update: First draft of the document.
User 1 received document update: Second draft of the document.
User 2 received document update: Second draft of the document.
```

## **2. Command Pattern**

**Use Case:** AI-Driven Smart Home Automation
* Scenario: A smart home system predicts whether the lights should be turned on or off using an AI engine. The prediction is encapsulated as a command, and the system executes the command (e.g., turning on or off the lights).
* **Key Classes:**
    * Command Interface: Defines the execute method for command actions (like turning on/off lights).
    * TurnOnLightsCommand Class: Implements the Command interface for turning the lights on.
    * TurnOffLightsCommand Class: Implements the Command interface for turning the lights off.
    * Light Class: Represents the light object that can be turned on/off.
    * AIEngine Class: Simulates AI predictions to decide whether the lights should be on or off.
    * CommandInvoker Class: Encapsulates the command execution logic.
    * SmartHomeController Class: Ties everything together, using the AI engine to choose the correct command and executing it through the invoker.

### **How it Works**

1. The AIEngine makes a prediction (turn on/off lights).
2. Based on the prediction, the appropriate command (TurnOnLightsCommand or TurnOffLightsCommand) is issued.
3. The command is executed, and the light is turned on or off accordingly.

### **Main Class to Run**
Run the <code>Main.java</command> in the <code>command</code> package to test the AI-driven smart home system.

### **Example Output**
```
Turning on lights in Living Room.
```
or
```
Turning off lights in Living Room.
```