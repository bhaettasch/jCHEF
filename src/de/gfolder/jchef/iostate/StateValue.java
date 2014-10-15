package de.gfolder.jchef.iostate;

import de.gfolder.jchef.events.EventManager;
import de.gfolder.jchef.events.StateValueChangedEvent;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class StateValue<T> extends Updatable<T> {
    StateValueChangedEvent<T> event;

    /**
     * Constructor
     *
     * @param val initial value
     * @param eventName name of the corresponding event
     */
    public StateValue(T val, String eventName) {
        super();
        this.val = val;
        createEvent(eventName);
    }

    /** {@inheritDoc} */
    @Override
    public void fireEvent() {
        event.update();
    }

    /**
     * Create and register a corresponding event
     *
     * @param name of the event
     * @return the corresponding event
     */
    private void createEvent(String name)
    {
        this.event =  new StateValueChangedEvent<T>(name, this);
        EventManager.getInstance().add(this.event);
    }
}
