package de.gfolder.jchef.events;

import de.gfolder.jchef.exceptions.EventNotFoundException;
import de.gfolder.jchef.manager.Manager;
import de.gfolder.jchef.observer.EventObserver;

import java.util.HashMap;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class EventManager extends Manager<Event> {
    static EventManager eventManger;

    HashMap<String, Event> events;

    /**
     * Constructor
     */
    public EventManager()
    {
        super();
        events = objs;
    }

    /**
     * Get a event object with the given name
     *
     * @param name name of the event
     * @return event with the given name
     * @throws EventNotFoundException
     */
    public Event getEventByName(String name) throws EventNotFoundException
    {
        Event event = events.get(name);
        if(event == null)
            throw new EventNotFoundException();
        return event;
    }

    /**
     * Directly register observer to events without the need to individually return the events
     *
     * @param observer observer to register
     * @param eventNames one or more names of events to register to
     */
    public void registerObserver(EventObserver observer, String... eventNames)
    {
        //Find the corresponding events and register observer
        for(String eventName:eventNames)
        {
            try {
                Event event = getEventByName(eventName);
                event.register(observer);
            } catch (EventNotFoundException e) {
                System.err.println("Event '"+eventName+"' not found. Could not register observer.");
            }
        }
    }

    /**
     * Directly unregister observer to events without the need to individually return the events
     *
     * @param observer observer to unregister
     * @param eventNames one or more names of events to unregister from
     */
    public void unregisterObserver(EventObserver observer, String... eventNames)
    {
        //Find the corresponding events and unregister observer
        for(String eventName:eventNames)
        {
            try {
                Event event = getEventByName(eventName);
                event.unregister(observer);
            } catch (EventNotFoundException e) {
                System.err.println("Event "+eventName+" not found. Could not register observer.");
            }
        }
    }

    /**
     * Get the running instance of the event manager
     *
     * @return the running event manager
     */
    public static EventManager getInstance()
    {
        if(eventManger == null)
            eventManger = new EventManager();
        return eventManger;
    }
}
