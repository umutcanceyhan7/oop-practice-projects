package Entity;

public class ConcreateMediator implements Mediator{
    final private LightSensor lightSensor;
    final private MotionSensor motionSensor;
    final private TemperatureSensor temperatureSensor;
    final private DoorLock doorLock;
    final private LightBulb lightBulb;
    final private Thermostat thermostat;

    public ConcreateMediator(LightSensor lightSensor, MotionSensor motionSensor, TemperatureSensor temperatureSensor, DoorLock doorLock, LightBulb lightBulb, Thermostat thermostat) {
        this.lightSensor = lightSensor;
        this.motionSensor = motionSensor;
        this.temperatureSensor = temperatureSensor;
        this.doorLock = doorLock;
        this.lightBulb = lightBulb;
        this.thermostat = thermostat;
    }

    @Override
    public void setTemperature(int desiredValue) {
        this.thermostat.setDesiredTemperature(desiredValue);
        System.out.println("Thermostat will increase temperature to " + desiredValue + " degrees");
        this.thermostat.performAction();
    }

    @Override
    public void toggleLights() {
        this.lightBulb.performAction();
    }

    @Override
    public void toggleDoor() {
        this.doorLock.performAction();
    }
}
