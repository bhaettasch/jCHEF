package jchef.observer;

import jchef.events.Event;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public interface EventObserver {
    public void handleEvent(Event event);
}
