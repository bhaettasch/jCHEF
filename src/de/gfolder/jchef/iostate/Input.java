package de.gfolder.jchef.iostate;

import de.gfolder.jchef.events.EventManager;
import de.gfolder.jchef.events.InputChangedEvent;
import de.gfolder.jchef.manager.Managable;
import de.gfolder.jchef.observer.EventObserver;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class Input<T> extends Updatable<T> implements Managable
{
    protected InputChangedEvent event;
    private String name;

    protected T min;
    protected T max;

    /**
     * Constructor
     *
     * @param name unique identification name
     */
    public Input(String name) {
        this.name = name;
        createEvent();
    }

    /**
     * Get corresponding event
     *
     * @return event
     */
    public InputChangedEvent getEvent() {
        return event;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Get minimum for value of this input
     * (Used to map to other areas)
     *
     * @return minimum
     */
    public T getMin() {
        return min;
    }

    /**
     * Get maximum for value of this input
     * (Used to map to other areas)
     *
     * @return maximum
     */
    public T getMax() {
        return max;
    }

    /**
     * Set minimum for value of this input
     * (Used to map to other areas)
     *
     * @param min minimum
     */
    public void setMin(T min) {
        this.min = min;
    }

    /**
     * Set maximum for value of this input
     * (Used to map to other areas)
     *
     * @param max maximum
     */
    public void setMax(T max) {
        this.max = max;
    }

    /**
     * Create corresponding InputChangedEvent for this input
     * and register this event in the central event manager
     */
    protected void createEvent()
    {
        event = new InputChangedEvent(this.name, this);
        EventManager.getInstance().add(event);
    }

    /**
     * Fire the event
     * (This may be overidden to add additional checks or similar things)
     */
    @Override
    public void fireEvent()
    {
        event.update();
    }

    /**
     * Allow client to directly register to event without requesting the event object
     * (Facade)
     *
     * @param observer observer to register to event
     */
    public void registerToEvent(EventObserver observer)
    {
        event.register(observer);
    }
}
