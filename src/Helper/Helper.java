package Helper;

import Entity.*;
import com.sun.tools.javac.Main;

import java.util.Random;

public class Helper {
    private static final int INITIAL_MAXIMUM_TEMP_VALUE = Simulation.INITIAL_MAXIMUM_TEMP_VALUE;
    private static final int INITIAL_MINIMUM_TEMP_VALUE = Simulation.INITIAL_MINIMUM_TEMP_VALUE;
    private static Random random = new Random();
    public Helper(){
    }
    public static int generateRandTemperatureValue(){
        return random.nextInt(15,30);
    }
    public static boolean generateRandBooleanValue(){
        return random.nextBoolean();
    }

    public static Mediator setUpMediator(){
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        LightSensor lightSensor = new LightSensor();
        MotionSensor motionSensor = new MotionSensor();
        Thermostat thermostat = new Thermostat((INITIAL_MAXIMUM_TEMP_VALUE + INITIAL_MINIMUM_TEMP_VALUE) / 2);
        LightBulb lightBulb = new LightBulb();
        DoorLock doorLock = new DoorLock();
        Mediator smartHome = new SmartHome(temperatureSensor,lightSensor,motionSensor,thermostat,lightBulb,doorLock);
        return smartHome;
    }
}
