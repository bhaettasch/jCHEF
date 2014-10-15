package de.gfolder.jchef.iostate;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public abstract class Updatable<T> {
    protected T val;

    /**
     * Get input value
     *
     * @return val
     */
    public T getVal() {
        return val;
    }

    /**
     * Set a new value
     * This may cause the event to fire
     *
     * @param newVal the new value to set
     */
    public void update(T newVal)
    {
        if(hasChanged(val, newVal))
        {
            val = newVal;
            fireEvent();
        }
    }

    /**
     * Check if the given value differs from the one already known
     *
     * @param val old value
     * @param newVal new value
     * @return true if the given value differ, false if not
     */
    public boolean hasChanged(T val, T newVal)
    {
        return !val.equals(newVal);
    }

    public abstract void fireEvent();
}
