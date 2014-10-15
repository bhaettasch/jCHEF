package de.gfolder.jchef.connectors.system;

import de.gfolder.jchef.connectors.Connector;
import de.gfolder.jchef.connectors.system.output.ConsoleOutput;
import de.gfolder.jchef.connectors.system.output.LogOutput;
import de.gfolder.jchef.connectors.system.output.SoundOutput;
import de.gfolder.jchef.iostate.Input;
import de.gfolder.jchef.iostate.Output;
import org.json.simple.JSONObject;

public class SystemConnector extends Connector<Input, Output> {

    /**
     * Constructor
     *
     * @param name name of the connector
     */
    public SystemConnector(String name) {
        super(name);
    }

    @Override
    public void build(JSONObject json) {
        LogOutput logOutput = new LogOutput();
        outputs.add(logOutput);

        ConsoleOutput consoleOutput = new ConsoleOutput();
        outputs.add(consoleOutput);

        SoundOutput soundOutput = new SoundOutput();
        outputs.add(soundOutput);
    }
}
