package eu.epitech;


import eu.epitech.annotations.EventHandler;
import eu.epitech.events.EventManager;
import eu.epitech.events.Listener;
import eu.epitech.events.MyEvent;

public class App extends Listener
{
    public static void main( String[] args )
    {
        App app = new App();
        MyEvent event = new MyEvent();
        EventManager manager = new EventManager(app);
        manager.callEvent(event);
    }

    @EventHandler
    public void onMyEvent(MyEvent event) {
        System.out.println(event.getMessage());
    }
}
