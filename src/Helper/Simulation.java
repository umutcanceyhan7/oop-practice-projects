package Helper;

import Entity.ControlPanel;
import Entity.Mediator;
import Entity.User;
import Entity.UserControlPanel;

public class Simulation {
    static final int SIMULATION_DURATION = 20;
    static final int INITIAL_MAXIMUM_TEMP_VALUE = 25;
    static final int INITIAL_MINIMUM_TEMP_VALUE = 20;
    public void run(){
        Helper helper = new Helper();
        Mediator smartHome = helper.setUpMediator();
        ControlPanel userControlPanel = new UserControlPanel();
        userControlPanel.setMediator(smartHome);
        User user = new User(userControlPanel);
        for (int i = 0; i < SIMULATION_DURATION; i++) {
            // Control panel directives from user
            // Helper calculates the possibility for user action if it is true user sends a command
            boolean shouldUserUpdateDoor = Helper.generateRandBooleanValue();
            boolean shouldUserUpdateLightBulb = Helper.generateRandBooleanValue();
            boolean shouldUserUpdateTemperature = Helper.generateRandBooleanValue();

            // If user wants to change something from control panel, program accepts user value and denies sensor value.
            // Otherwise, sensor value is read and necessary action is performed.

            // User Temperature Command
            if(shouldUserUpdateTemperature){
                user.updateTemperature(Helper.generateRandTemperatureValue());
            }
            // Sensor check
            else{
                smartHome.regulateTemperature();
            }

            // User Light Command
            if(shouldUserUpdateLightBulb){
                if (Helper.generateRandBooleanValue()) {
                    user.openLights();
                } else {
                    user.closeLights();
                }
            }
            // Sensor check
            else {
                smartHome.regulateLightBulb();
            }
            // User Door Command
            if (shouldUserUpdateDoor) {
                if (Helper.generateRandBooleanValue()) {
                    user.unlockTheDoor();
                } else {
                    user.lockTheDoor();
                }
            }
            // Sensor Check
            else {
                smartHome.regulateDoorLock();
            }
        }
    }
}
