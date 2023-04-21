package Entity;

public interface ControlPanel {
    public void setTemperature(int desiredTemp);
    public void toggleLights();
    public void toggleDoor();
    public void setMediator(Mediator mediator);
}
