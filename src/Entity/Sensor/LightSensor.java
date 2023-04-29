package Entity.Sensor;

import Entity.Sensor.Sensor;
import Helper.Helper;

public class LightSensor implements Sensor {
    @Override
    public Boolean getReading() {
        return Helper.generateRandBooleanValue();
    }
}
