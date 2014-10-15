package de.gfolder.jchef.actions.system;

import de.gfolder.jchef.actions.Action;
import de.gfolder.jchef.connectors.ConnectorManager;
import de.gfolder.jchef.exceptions.ManagedObjectNotFoundException;
import de.gfolder.jchef.util.Logger;

public class LogAction extends Action {
    @Override
    public void run() {
        try {
            ConnectorManager.getInstance().getOutput("system", "logger").set(getParam("logString"));
        } catch (ManagedObjectNotFoundException e) {
            Logger.getInstance().logError("LogOutput not found", e);
        }
    }
}
