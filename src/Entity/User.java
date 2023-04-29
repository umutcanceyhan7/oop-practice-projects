package Entity;

public class User {
    private ControlPanel controlPanel;
    public User(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
    public void updateTemperature(int desiredTemp){
        controlPanel.setTemperature(desiredTemp);
    }
    public void openLights(){
        controlPanel.openLights();
    };
    public void closeLights(){
        controlPanel.closeLights();
    };
    public void lockTheDoor(){controlPanel.lockTheDoor();};
    public void unlockTheDoor(){
        controlPanel.unlockTheDoor();
    };
}
