package de.gfolder.jchef.eventHandler;

import de.gfolder.jchef.actions.Action;
import de.gfolder.jchef.events.Event;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class ActionEventHandler extends EventHandler {

    protected Action action;

    public ActionEventHandler(Action action, String... events)
    {
        super(events);
        this.action = action;

    }

    /**
     * Perform the real action
     */
    protected void runAction()
    {
        //Normally, just call the run method of the Action
        //Should be changed only in very specific cases after a lot of consideration
        action.run();
    }

    @Override
    protected boolean checkPrerequisites()
    {
        //Default: No other conditions
        return true;
    }

    @Override
    protected void setActionData()
    {
        //Default: No additional data needed
    }

    @Override
    protected void useEventInformation(Event event) {
        //Default: No data is extracted from the event
    }
}