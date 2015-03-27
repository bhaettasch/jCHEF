package jchef.eventHandler;

import jchef.actions.Action;

/**
 * Handle an event and run the given action if the test of
 * checkPrerequisites()
 * is successfully, otherwise run the secondary action
 */
public class IfElseHandler extends ActionEventHandler {
    Action actionElse;

    /**
     * Constructor
     *
     * @param actionIf primary action to be run if prerequisites hold
     * @param actionElse default action to be run otherwise
     */
    public IfElseHandler(Action actionIf, Action actionElse)
    {
        super(actionIf);
        this.actionElse = actionElse;
    }

    @Override
    protected void act()
    {
        if(checkPrerequisites())
        {
            setActionData();
            runAction();
        }
        else
        {
            setElseActionData();
            runElseAction();
        }
    }

    /**
     * Transfer runtime data to action
     * (Information that is not available at construction time)
     */
    protected void setElseActionData()
    {
        //Default: No additional data needed
    }

    /**
     * Perform the real action
     */
    protected void runElseAction()
    {
        //Normally, just call the run method of the Action
        //Should be changed only in very specific cases after a lot of consideration
        actionElse.run();
    }
}
