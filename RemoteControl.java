interface Command {
    void execute();
    void undo();
}

class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command lastCommand;

    public void setCommand(Command command) {
        this.lastCommand = command;
    }

    public void pressExecute() {
        lastCommand.execute();
    }

    public void pressUndo() {
        lastCommand.undo();
    }
}

// Usage
Light livingRoomLight = new Light();
Command lightOn = new TurnOnLightCommand(livingRoomLight);
RemoteControl remote = new RemoteControl();

remote.setCommand(lightOn);
remote.pressExecute(); // Turns light ON
remote.pressUndo();    // Turns light OFF