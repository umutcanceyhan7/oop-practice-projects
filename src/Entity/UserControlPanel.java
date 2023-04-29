package Entity;
public class UserControlPanel implements ControlPanel{
    private Mediator smartHome;

    public UserControlPanel() {
    }

    @Override
    public void setTemperature(int desiredTemp) {
        getSmartHome().updateTemperature(desiredTemp);
    }

    @Override
    public void openLights() {
        getSmartHome().updateLights(true);
    }

    @Override
    public void closeLights() {
        getSmartHome().updateLights(false);
    }

    @Override
    public void lockTheDoor() {
        getSmartHome().updateDoor(false);
    }

    @Override
    public void unlockTheDoor() {
        getSmartHome().updateDoor(true);
    }

    public Mediator getSmartHome() {
        return smartHome;
    }

    public void setMediator(Mediator smartHome) {
        this.smartHome = smartHome;
    }
}
