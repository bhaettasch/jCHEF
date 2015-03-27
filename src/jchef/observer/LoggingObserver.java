package jchef.observer;

import jchef.connectors.ConnectorManager;
import jchef.events.EventManager;
import jchef.exceptions.ManagedObjectNotFoundException;

public abstract class LoggingObserver implements EventObserver {

    /**
     * Constructor
     *
     * @param events events to listen to
     */
    public LoggingObserver(String... events) {
        EventManager.getInstance().registerObserver(this, events);
    }

    /**
     * log the given string
     *
     * @param logstring string to log
     */
    private void log(String logstring)
    {
        try {
            ConnectorManager.getInstance().getOutput("system", "logger").set(logstring);
        } catch (ManagedObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}
