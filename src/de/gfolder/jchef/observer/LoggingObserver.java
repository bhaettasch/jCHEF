package de.gfolder.jchef.observer;

import de.gfolder.jchef.connectors.ConnectorManager;
import de.gfolder.jchef.events.EventManager;
import de.gfolder.jchef.exceptions.ManagedObjectNotFoundException;

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
