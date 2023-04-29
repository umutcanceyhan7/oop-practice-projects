package Entity.Sensor;

import Entity.Sensor.Sensor;
import Helper.Helper;

public class TemperatureSensor implements Sensor {
    @Override
    public Integer getReading() {
        return Helper.generateRandTemperatureValue();
    }
}
