package de.gfolder.jchef.connectors;

import de.gfolder.jchef.exceptions.ManagedObjectNotFoundException;
import de.gfolder.jchef.iostate.Input;
import de.gfolder.jchef.iostate.Output;
import de.gfolder.jchef.manager.Manager;

public class ConnectorManager extends Manager<Connector> {

    private static ConnectorManager instance;

    /**
     * Get Input directly based upon input and connector name
     *
     * @param connectorName name of the connector the input belongs to
     * @param inputName name of the input
     * @return the desired input
     * @throws ManagedObjectNotFoundException
     */
    public Input getInput(String connectorName, String inputName) throws ManagedObjectNotFoundException {
        Connector c = getByName(connectorName);
        return c.getInputByName(inputName);
    }

    /**
     * Get Output directly based upon input and connector name
     *
     * @param connectorName name of the connector the output belongs to
     * @param outoputName name of the output
     * @return the desired output
     * @throws ManagedObjectNotFoundException
     */
    public Output getOutput(String connectorName, String outoputName) throws ManagedObjectNotFoundException {
        Connector c = getByName(connectorName);
        return c.getOutputByName(outoputName);
    }

    /**
     * Singleton: Get instance
     *
     * @return instance
     */
    public static ConnectorManager getInstance()
    {
        if(instance == null)
            instance = new ConnectorManager();
        return instance;
    }
}
