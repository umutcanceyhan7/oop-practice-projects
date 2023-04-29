package Entity;

public class LightBulb implements Actuator{
    private boolean isOpen;
    public LightBulb() {
        this.isOpen = false;
    }
    @Override
    // Validate the value, if it passes validations, perform the action.
    // Otherwise, print current situation!
    public void performAction(Object isLightNeeded) {
        boolean lightIsNeededAndLightIsOpen = (Boolean) isLightNeeded && getIsOpen();
        boolean lightIsNotNeededAndLightIsNotOpen = !((Boolean) isLightNeeded && getIsOpen());
        if(lightIsNeededAndLightIsOpen || lightIsNotNeededAndLightIsNotOpen){
            System.out.println("Light bulb is already " + (getIsOpen() ? "open" : "closed") + "!");
            return;
        }
        setIsOpen((Boolean) isLightNeeded);
        System.out.println("Light bulb is now " + (getIsOpen() ? "open" : "closed"));
    }

    private boolean getIsOpen() {
        return this.isOpen;
    }

    private void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
