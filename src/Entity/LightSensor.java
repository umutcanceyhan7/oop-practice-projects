package Entity;

public class LightSensor implements Sensor{
    private double lightValue;
    private Mediator mediator;

    public LightSensor() {
        this.lightValue = 0;
    }

    @Override
    public void getReading() {
    }

    @Override
    public String getType() {
        return "lightBulb";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public double getLightValue() {
        return lightValue;
    }

    public void setLightValue(double lightValue) {
        this.lightValue = lightValue;
    }
}
