package jchef.events;

public class TimerEvent extends Event {
    /**
     * Constructor
     *
     * @param name name of the event (must be unique)
     */
    public TimerEvent(String name) {
        super(name);
    }
}
