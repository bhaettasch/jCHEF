package de.gfolder.jchef.events;

import de.gfolder.jchef.iostate.StateValue;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class StateValueChangedEvent<T> extends Event {
    StateValue<T> stateValue;

    /**
     * Constructor
     *
     * @param name name of the event (must be unique)
     */
    public StateValueChangedEvent(String name, StateValue<T> stateValue) {
        super(name);
        this.stateValue = stateValue;
    }

    /**
     * Get changed value
     *
     * @return value of the corresponding state value object
     */
    public T getChangedValue()
    {
        return stateValue.getVal();
    }

}
