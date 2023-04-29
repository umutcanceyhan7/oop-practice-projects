package Entity;

public interface Mediator {
    public void regulateTemperature();
    public void regulateLightBulb();
    public void regulateDoorLock();
    public void updateTemperature(int desiredValue);
    public void updateLights(boolean isLightOpen);
    public void updateDoor(boolean isDoorOpen);
}
