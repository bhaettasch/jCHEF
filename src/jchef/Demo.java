package jchef;

import jchef.connectors.Connector;
import jchef.connectors.ConnectorBuilder;
import jchef.connectors.ConnectorManager;
import jchef.logic.LogicBuilder;
import jchef.util.JSONFileParser;

public class Demo {

    public static void main(String[] args)
    {
        /**
         * Read connector config file and generate a connector for each entry
         * This involves calling the constructor (with string argument),
         * calling the build method with additional information from the file encodes as JSON Object
         * and adding the connector to ConnectorManager
         */
        new JSONFileParser(new ConnectorBuilder()).parse("config/connectors.json");

        /**
         * Read logic config file and generate a Logic module for each entry
         * This involves calling the constructor,
         * calling the setup method to init the EventHandlers
         * and running the initial actions
         */
        new JSONFileParser(new LogicBuilder()).parse("config/logic.json");
    }

    /**
     * Give the individual connectors the ability to safely close
     * Afterwards stop VM
     */
    public static void close()
    {
        for(Connector c:ConnectorManager.getInstance().getEntries())
            c.close();

        System.exit(0);
    }
}
