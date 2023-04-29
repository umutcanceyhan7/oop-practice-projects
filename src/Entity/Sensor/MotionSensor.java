package Entity.Sensor;

import Entity.Sensor.Sensor;
import Helper.Helper;

public class MotionSensor implements Sensor {
    @Override
    public Boolean getReading() {
        return Helper.generateRandBooleanValue();
    }
}
