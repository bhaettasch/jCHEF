package jchef.logic;

import jchef.actions.Action;

public abstract class Logic {

    protected Action[] initialActions;

    /**
     * Constructor
     */
    protected Logic() {
        this.initialActions = new Action[]{};
    }

    /**
     * Setup
     * Create EventHandlers, helper objects, ...
     */
    public abstract void setup();

    /**
     * Run initial actions
     */
    public void runInitialActions()
    {
        for(Action action: initialActions)
        {
            action.run();
        }
    }
}
