package eu.epitech.events;

public class MyEvent implements Event {

    String message;

    public MyEvent() {
        this.message = "Hello World";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
