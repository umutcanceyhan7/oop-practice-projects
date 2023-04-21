package Entity;

public class DoorLock implements Actuator{
    private Mediator mediator;
    private boolean isLocked;

    public DoorLock() {
        this.isLocked = true;
    }

    @Override
    public void performAction() {
        setIsLocked(!getIsLocked());
        System.out.println("The door is " + (getIsLocked() ? "locked" : "unlocked"));
    }

    @Override
    public String getType() {
        return "Door Lock";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean getIsLocked() {
        return this.isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
