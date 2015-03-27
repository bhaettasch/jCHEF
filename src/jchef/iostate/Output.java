package jchef.iostate;

import jchef.manager.Managable;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public abstract class Output<T> implements Managable
{
    private String name;
    private T val;

    /**
     * Get name of this managable item
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Constructor
     *
     * @param name name of the output
     */
    public Output(String name)
    {
        this.name = name;
    }

    /**
     * Set new value for out put depending on the type
     *
     * @param val new value
     */
    public void set(T val)
    {
        this.val = val;
    }

    /**
     * get current output value
     *
     * @return current value
     */
    public T getVal()
    {
        return val;
    }
}
