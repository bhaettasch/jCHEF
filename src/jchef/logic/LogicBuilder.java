package jchef.logic;

import jchef.util.JSONBuilder;
import org.json.simple.JSONObject;

public class LogicBuilder implements JSONBuilder {
    @Override
    public void buildEntry(JSONObject entry) {
        try {
            //Get the correct class (by String)
            @SuppressWarnings("unchecked")
            Class<Logic> logicClass = (Class<Logic>) Class.forName(entry.get("package") + "." + entry.get("className"));

            //Create an instance, setup the EventHandlers and call the initial actions
            Logic logic = logicClass.newInstance();
            logic.setup();
            logic.runInitialActions();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}