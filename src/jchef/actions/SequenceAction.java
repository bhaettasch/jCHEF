package jchef.actions;

import jchef.exceptions.ParamSizeMismatchException;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class SequenceAction extends Action {
    private Action[] actions;

    @Override
    public void run() {
        for(Action a:actions)
        {
            a.run();
        }
    }

    /**
     * Create a new SequenceAction out of several single actions
     *
     * @param actions Actions to run sequentially
     */
    public SequenceAction(Action... actions)
    {
        this.actions = actions;
    }

    @Override
    public void setParams(String[] keys, Object[] values) throws ParamSizeMismatchException
    {
        //Forward all params to every action to allow setting of params also for SequenceActions
        //The EventHandler can set params without knowing that the actions are called indirectly
        for(Action a:actions)
        {
            a.setParams(keys, values);
        }
    }
}
