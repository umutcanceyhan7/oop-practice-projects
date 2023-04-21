import Entity.*;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = null;
        Actuator lightBulb = new LightBulb();
        Actuator doorLock = new DoorLock();
        Actuator thermostat = new Thermostat(25);
        Sensor temperatureSensor =  new TemperatureSensor();
        Sensor lightSensor = new LightSensor();
        Sensor motionSensor = new MotionSensor();
        mediator = new ConcreateMediator(
                (LightSensor) lightSensor,
                (MotionSensor) motionSensor,
                (TemperatureSensor) temperatureSensor,
                (DoorLock) doorLock,
                (LightBulb) lightBulb,
                (Thermostat) thermostat
        );
        mediator.setTemperature(32);
        mediator.setTemperature(48);
        mediator.toggleDoor();
        mediator.toggleLights();
    }
}