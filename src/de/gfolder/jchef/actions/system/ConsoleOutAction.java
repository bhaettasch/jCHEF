package de.gfolder.jchef.actions.system;

import de.gfolder.jchef.actions.Action;
import de.gfolder.jchef.connectors.system.output.ConsoleOutput;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class ConsoleOutAction extends Action {

    @Override
    public void run() {
        ConsoleOutput.getInstance().set(getParam("val"));
    }

    /**
     * Constructor
     *
     * @param val object to show (may also be replaced by setParam later)
     */
    public ConsoleOutAction(Object val)
    {
        setParam("val", val);
    }
}
