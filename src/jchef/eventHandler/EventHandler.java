package jchef.eventHandler;

import jchef.events.Event;
import jchef.events.EventManager;
import jchef.observer.EventObserver;

public abstract class EventHandler implements EventObserver {

    /**
     * Constructor
     *
     * @param events events to register this handler to
     */
    public EventHandler(String... events) {
        if(events.length > 0)
            EventManager.getInstance().registerObserver(this, events);
    }

    @Override
    public void handleEvent(Event event) {
        useEventInformation(event);
        act();
    }

    protected abstract void useEventInformation(Event event);

    /**
     * Perform action after checking and setting of additional data
     * The individual methods can be changed without altering this function
     */
    protected void act()
    {
        if(checkPrerequisites())
        {
            setActionData();
            runAction();
        }
    }

    /**
     * Check additional conditions
     *
     * @return true if all conditions are met, false if not
     */
    protected abstract boolean checkPrerequisites();

    /**
     * Transfer runtime data to action
     * (Information that is not available at construction time)
     */
    protected abstract void setActionData();

    protected abstract void runAction();
}
