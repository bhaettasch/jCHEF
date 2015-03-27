package jchef.connectors;

import jchef.util.JSONBuilder;
import org.json.simple.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConnectorBuilder implements JSONBuilder {
    @Override
    public void buildEntry(JSONObject entry) {
        try {
            //Get the correct class (by String)
            @SuppressWarnings("unchecked")
            Class<Connector> connectorClass = (Class<Connector>) Class.forName(entry.get("package") + "." + entry.get("className"));

            //Create an implicit constructor
            Constructor<Connector> constructor = connectorClass.getConstructor(String.class);

            //Create an instance with this constructor, allow it to build/init and add to connectorManager
            Connector connector = constructor.newInstance(entry.get("name"));
            connector.build(entry);
            ConnectorManager.getInstance().add(connector);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}