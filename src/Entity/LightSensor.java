package Entity;

import Helper.Helper;

public class LightSensor implements Sensor{
    private boolean isLightNeeded;
    public LightSensor() {
        this.isLightNeeded = false;
    }
    @Override
    public Boolean getReading() {
        setIsLightNeededValue(Helper.generateRandBooleanValue());
        return getIsLightNeededValue();
    }
    private void setIsLightNeededValue(boolean isLightNeeded) {
        this.isLightNeeded = isLightNeeded;
    }
    private boolean getIsLightNeededValue() {
        return this.isLightNeeded;
    }
}
