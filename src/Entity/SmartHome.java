package Entity;

import Entity.Actuator.DoorLock;
import Entity.Actuator.LightBulb;
import Entity.Actuator.Thermostat;
import Entity.Sensor.LightSensor;
import Entity.Sensor.MotionSensor;
import Entity.Sensor.TemperatureSensor;

public class SmartHome implements Mediator{
    private TemperatureSensor temperatureSensor;
    private LightSensor lightSensor;
    private MotionSensor motionSensor;
    private Thermostat thermostat;
    private LightBulb lightBulb;
    private DoorLock doorLock;

    public SmartHome(TemperatureSensor temperatureSensor, LightSensor lightSensor, MotionSensor motionSensor, Thermostat thermostat, LightBulb lightBulb, DoorLock doorLock) {
        this.temperatureSensor = temperatureSensor;
        this.lightSensor = lightSensor;
        this.motionSensor = motionSensor;
        this.thermostat = thermostat;
        this.lightBulb = lightBulb;
        this.doorLock = doorLock;
    }

    public void regulateTemperature(){
        Integer currentTemperatureValue = getTemperatureSensor().getReading();
        getThermostat().performAction(currentTemperatureValue);
    }
    public void regulateLightBulb(){
        Boolean isLightNeeded = getLightSensor().getReading();
        getLightBulb().performAction(isLightNeeded);
    }
    public void regulateDoorLock(){
        Boolean isMotionDetected = getMotionSensor().getReading();
        getDoorLock().performAction(isMotionDetected);
    }
    @Override
    public void updateTemperature(int desiredValue) {
        getThermostat().performAction(desiredValue);
    }

    @Override
    public void updateLights(boolean isLightOpen) {
        getLightBulb().performAction(isLightOpen);
    }

    @Override
    public void updateDoor(boolean isDoorOpen) {
        getDoorLock().performAction(isDoorOpen);
    }

    public DoorLock getDoorLock() {
        return doorLock;
    }
    public LightSensor getLightSensor() {
        return lightSensor;
    }
    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public MotionSensor getMotionSensor() {
        return motionSensor;
    }

    public Thermostat getThermostat() {
        return thermostat;
    }


    public LightBulb getLightBulb() {
        return lightBulb;
    }
}
