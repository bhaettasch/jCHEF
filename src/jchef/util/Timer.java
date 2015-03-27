package jchef.util;

import jchef.events.EventManager;
import jchef.events.TimerEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer implements ActionListener {

    String name;
    javax.swing.Timer timer;
    TimerEvent event;

    /**
     * Constructor
     *
     * @param name name of the timer
     * @param delay delay until the timer fires
     * @param repeat true if the timer should repeat after it fired for the first time, false if not
     */
    public Timer(String name, int delay, boolean repeat)
    {
        this.name = name;
        timer = new javax.swing.Timer(delay, this);
        timer.setRepeats(repeat);
        createEvent(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        event.update();
    }

    /**
     * Create the corresponding event for this timer
     *
     * @param name name of the timer/the event
     */
    private void createEvent(String name)
    {
        event = new TimerEvent(name);
        EventManager.getInstance().add(event);
    }

    /**
     * Start timer
     */
    public void start()
    {
        timer.start();
    }

    /**
     * Stop timer
     */
    public void stop()
    {
        timer.stop();
    }

    /**
     * Is the timer already running?
     *
     * @return true if timer is running, false if not
     */
    public boolean isRunning()
    {
        return timer.isRunning();
    }
}
