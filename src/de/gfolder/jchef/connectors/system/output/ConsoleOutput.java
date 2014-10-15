package de.gfolder.jchef.connectors.system.output;

import de.gfolder.jchef.iostate.Output;

public class ConsoleOutput extends Output<Object> {
    private static ConsoleOutput instance;

    /**
     * Constructor
     */
    public ConsoleOutput() {
        super("console");
    }

    /**
     * Singleton including construction at first call
     *
     * @return instance of console output
     */
    public static ConsoleOutput getInstance()
    {
        if(instance==null)
            instance = new ConsoleOutput();
        return instance;
    }

    @Override
    public void set(Object val) {
        super.set(val);
        System.out.println(val);
    }
}
