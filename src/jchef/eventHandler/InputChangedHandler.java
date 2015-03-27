package jchef.eventHandler;

import jchef.events.Event;
import jchef.events.InputChangedEvent;

public class InputChangedHandler extends EventHandlerWrapper {

    /**
     * Constructor
     *
     * @param wrappedHandler handler for the real actions
     * @param events names of the events to listen to
     */
    public InputChangedHandler(EventHandler wrappedHandler, String... events) {
        super(wrappedHandler, events);
    }

    @Override
    protected void useEventInformation(Event event) {
        useInputEventInformation((InputChangedEvent) event);
    }

    /**
     * Handle update about changed io value
     *
     * @param event event (downcasted to InputChangedEvent)
     */
    protected void useInputEventInformation(InputChangedEvent event)
    {
        //Super method will use wrappedHandler to fulfill action
        super.useEventInformation(event);
    }
}
