interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Usage
Light livingRoomLight = new Light();
Command lightsOn = new TurnOnLightCommand(livingRoomLight);
RemoteControl remote = new RemoteControl();
remote.setCommand(lightsOn);
remote.pressButton();