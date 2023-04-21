package Entity;

public class Thermostat implements Actuator{
    private Mediator mediator;
    private int currentTemperature;
    private int desiredTemperature;

    public Thermostat(int currentTemperature) {
        this.currentTemperature = currentTemperature;
        this.desiredTemperature = currentTemperature;
    }

    @Override
    public void performAction() {
        if(getDesiredTemperature() != getCurrentTemperature()){
            setCurrentTemperature(getDesiredTemperature());
            System.out.println("Thermostat increased temperature to " + getCurrentTemperature() + " degrees");

        }
    }

    @Override
    public String getType() {
        return "Thermostat";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public int getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(int desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }
}
