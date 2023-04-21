package Entity;

public interface Actuator {
    public void performAction();
    public String getType();
    public void setMediator(Mediator mediator);
}
