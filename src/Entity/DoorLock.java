package Entity;

public class DoorLock implements Actuator{
    private boolean isLocked;

    public DoorLock() {
        this.isLocked = true;
    }

    @Override
    // Validate the value, if it passes validations, perform the action.
    // Otherwise, print current situation!
    public void performAction(Object isMotionDetected) {
        // Validations
        boolean theDoorIsUnlockedAndMotionIsDetected = ((Boolean) isMotionDetected && !getIsLocked());
        boolean theDoorIsLockedAndMotionIsNotDetected = (!(Boolean)isMotionDetected && getIsLocked());
        // Control
        if(theDoorIsUnlockedAndMotionIsDetected || theDoorIsLockedAndMotionIsNotDetected){
            if(!getIsLocked()) {
                System.out.println("The door is already " + (getIsLocked() ? "locked" : "unlocked") + "!");
                return;
            }
        }
        // Handle
        setIsLocked(!(Boolean)isMotionDetected);
        System.out.println("The door is " + (getIsLocked() ? "locked" : "unlocked"));
    }
    private boolean getIsLocked() {
        return this.isLocked;
    }
    private void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
