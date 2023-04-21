package Entity;

public class UserControlPanel implements ControlPanel{
    private Mediator mediator;
    @Override
    public void setTemperature(int desiredTemp) {
        mediator.setTemperature(desiredTemp);
    }
    @Override
    public void toggleLights() {
        mediator.toggleLights();
    }
    @Override
    public void toggleDoor() {
        mediator.toggleDoor();
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
