package Entity;

public class LightBulb implements Actuator{
    private boolean isOpen;
    private Mediator mediator;

    public LightBulb() {
        this.isOpen = false;
    }

    @Override
    public void performAction() {
        // Toggles light bulb
        setIsOpen(!getIsOpen());
        System.out.println("Light bulb is now " + (getIsOpen() ? "open" : "closed"));

    }

    @Override
    public String getType() {
        return "Light Bulb";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
