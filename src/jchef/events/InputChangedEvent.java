package jchef.events;

import jchef.iostate.Input;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class InputChangedEvent extends Event {
    private Input input;

    /**
     * Constructor
     *
     * @param name name of the event (must be unique)
     * @param input corresponding io
     */
    public InputChangedEvent(String name, Input input) {
        super(name);
        this.input = input;
    }

    /**
     * Get the changed value
     *
     * @param <T> Expected type of the value
     * @return the value that changed
     */
    public <T> T getChangedValue()
    {
        return (T) input.getVal();
    }

    /**
     * Get source of the InputChangedEvent
     *
     * @return io that changed
     */
    public Input getSource()
    {
        return input;
    }

    @Override
    public String toString() {
        return "Event: Input '" + getName() + "' changed to value '" + getChangedValue() + "'";
    }
}
