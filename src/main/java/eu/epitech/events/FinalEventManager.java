package eu.epitech.events;

import eu.epitech.annotations.EventHandler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalEventManager {

    private List<Listener> listeners = new ArrayList<Listener>();

    public FinalEventManager(Listener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    public void callEvent(Event event) {
        listeners.forEach((l)->handleEvent(l, event));
    }

    private void handleEvent(Listener listener, Event event) {
        for( Method m : listener.getClass().getDeclaredMethods() ) {
            System.out.println("Methode : " + m.getName());
            if (m.isAnnotationPresent(EventHandler.class)) {
                System.out.println( "La methode " + m.getName() + " a l'annotation EventHandler");
                if (m.getParameterTypes().length == 1 && m.getParameterTypes()[0] == event.getClass()) {
                    System.out.println("La methode " + m.getName() + " possède un unique paramètre de type " + event.getClass().getName());
                    try {
                        System.out.println("On invoque la méthode en lui passant des arguments");
                        m.invoke(listener, event);
                    } catch (Exception e) {
                        System.err.println("Ah mince ça marche pas :/");
                    }
                }
            }
        }
    }
}
