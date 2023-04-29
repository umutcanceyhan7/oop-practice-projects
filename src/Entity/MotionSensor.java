package Entity;

import Helper.Helper;

public class MotionSensor implements Sensor {
    private boolean isMotionDetected;

    public MotionSensor() {
        this.isMotionDetected = false;
    }

    @Override
    public Boolean getReading() {
        setIsMotionDetectedValue(Helper.generateRandBooleanValue());
        return getIsMotionDetectedValue();
    }

    private boolean getIsMotionDetectedValue() {
        return isMotionDetected;
    }

    private void setIsMotionDetectedValue(boolean isMotionDetected) {
        this.isMotionDetected = isMotionDetected;
    }
}
