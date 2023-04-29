package Entity.ControlPanel;

import Entity.Mediator;

public interface ControlPanel {
    public void setTemperature(int desiredTemp);
    public void openLights();
    public void closeLights();
    public void lockTheDoor();
    public void unlockTheDoor();
    public void setMediator(Mediator mediator);
}
