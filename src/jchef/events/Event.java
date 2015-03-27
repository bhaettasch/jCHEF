package jchef.events;

import jchef.manager.Managable;
import jchef.observer.EventObserver;

import java.util.LinkedList;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class Event implements Managable
{
    LinkedList<EventObserver> observers;

    private String name;

    public String getName()
    {
        return name;
    }

    /**
     * Constructor
     *
     * @param name name of the event (must be unique)
     */
    public Event(String name) {
        this.name = name;
        observers = new LinkedList<>();
    }

    /**
     * Add a new observer to this event
     *
     * @param observer Observer to add
     */
    public void register(EventObserver observer)
    {
        if(!observers.contains(observer))
            observers.add(observer);
    }

    /**
     * Remove the given observer from observer list
     *
     * @param observer Observer to remove
     */
    public void unregister(EventObserver observer)
    {
       observers.remove(observer);
    }

    /**
     * Notify all observers about changes
     */
    public void update()
    {
        for(EventObserver observer:observers)
        {
            observer.handleEvent(this);
        }
    }

    @Override
    public String toString() {
        return "Event '" + getName() + "' fired.";
    }
}
