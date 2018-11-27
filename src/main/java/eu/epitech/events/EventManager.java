package eu.epitech.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventManager {

    private List<Listener> listeners = new ArrayList<Listener>();

    public EventManager(Listener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    public void callEvent(Event event) {
    }
}
