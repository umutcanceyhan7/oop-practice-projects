package Entity;

public interface Sensor {
    public void getReading();
    public String getType();
    public void setMediator(Mediator mediator);
}
