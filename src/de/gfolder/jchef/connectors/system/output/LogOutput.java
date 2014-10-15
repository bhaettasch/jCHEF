package de.gfolder.jchef.connectors.system.output;

import de.gfolder.jchef.iostate.Output;
import de.gfolder.jchef.util.Logger;

public class LogOutput extends Output<String> {
    private Logger logger;

    /**
     * Constructor
     */
    public LogOutput() {
        super("logger");

        logger = Logger.getInstance();
    }

    @Override
    public void set(String logstring)
    {
        logger.logInfo(logstring);
    }


}
