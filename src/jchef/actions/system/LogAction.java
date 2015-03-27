package jchef.actions.system;

import jchef.actions.Action;
import jchef.connectors.ConnectorManager;
import jchef.exceptions.ManagedObjectNotFoundException;
import jchef.util.Logger;

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
