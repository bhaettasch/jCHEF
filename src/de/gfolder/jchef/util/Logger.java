package de.gfolder.jchef.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

/**
 * Facade to access any kind of logger
 * Only this class has to be changed, when another kind of logger should be used
 */
public class Logger {
    private static Logger instance = new Logger();

    private java.util.logging.Logger logger;
    private Handler handler;

    /**
     * Constructor
     */
    public Logger() {
        //Edit here to change logging settings
        logger = java.util.logging.Logger.getGlobal();
        logger.setLevel(Level.ALL);
        handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
    }

    /**
     * Log the given message on INFO level
     *
     * @param msg msg to log
     */
    public void logInfo(String msg)
    {
        logger.info(msg);
    }

    /**
     * Log the given message on ERROR/SEVERE level
     *
     * @param msg msg to log
     * @param e error object
     */
    public void logError(String msg, Object e)
    {
        logger.log(Level.SEVERE, msg, e);
    }

    /**
     * Log the given message on WARNING level
     *
     * @param msg msg to log
     */
    public void logWarning(String msg)
    {
        logger.warning(msg);
    }

    /**
     * Log the given message with the given level
     *
     * @param level level of the message
     * @param msg message
     */
    public void log(Level level, String msg)
    {
        logger.log(level, msg);
    }

    /**
     * Log the given message with the given level
     *
     * @param level level of the message
     * @param msg message
     * @param o object to log
     */
    public void log(Level level, String msg, Object o)
    {
        logger.log(level, msg, o);
    }

    /**
     * Get static instance (Singleton)
     *
     * @return instance of the logger wrapping class
     */
    public static Logger getInstance() {
        return instance;
    }
}
