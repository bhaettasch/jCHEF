package jchef.connectors.system.output;

import jchef.iostate.Output;
import jchef.util.Logger;

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
