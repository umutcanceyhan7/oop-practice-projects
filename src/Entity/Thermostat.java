package Entity;

public class Thermostat implements Actuator{
    private int currentTemperature;
    private int desiredTemperature;

    public Thermostat(int currentTemperature) {
        this.currentTemperature = currentTemperature;
        this.desiredTemperature = currentTemperature;
    }

    @Override
    // Validate the value, if it passes validations, perform the action.
    // Otherwise, print current situation!
    public void performAction(Object desiredValue) {
        if((Integer) desiredValue == getCurrentTemperature()){
            System.out.println("Temperature is already in desired value!");
            return;
        }
        setDesiredTemperature((Integer) desiredValue);
        System.out.println("Thermostat will increase temperature to " + getDesiredTemperature() + " degrees");
        setCurrentTemperature(getDesiredTemperature());
        System.out.println("Temperature is increased to " + getCurrentTemperature() + " degrees");
    }
    private int getCurrentTemperature() {
        return currentTemperature;
    }

    private void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    private int getDesiredTemperature() {
        return desiredTemperature;
    }

    private void setDesiredTemperature(int desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }
}