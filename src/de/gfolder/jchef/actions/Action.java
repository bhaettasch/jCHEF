package de.gfolder.jchef.actions;

import de.gfolder.jchef.exceptions.ParamSizeMismatchException;

import java.util.HashMap;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public abstract class Action {

    private HashMap<String, Object> params;

    protected Action() {
        this.params = new HashMap<String, Object>();
    }

    /**
     * Perform action
     */
    public abstract void run();

    /**
     * Set Params for the action. Params are identified by string
     * Values for existing strings will be overwritten
     */
    public void setParams(String[] keys, Object[] values) throws ParamSizeMismatchException
    {
        if(keys.length != values.length)
            throw new ParamSizeMismatchException();

        for(int i=0;i<keys.length;i++)
        {
            setParam(keys[i], values[i]);
        }
    }

    /**
     * Set or replace a param
     *
     * @param key key to store the object with
     * @param val the real value
     */
    protected void setParam(String key, Object val)
    {
        params.put(key, val);
    }

    /**
     * Get value for given key
     *
     * @param key Key of the param
     * @param <T> Type of the param
     * @return Corresponding value
     */
    protected <T> T getParam(String key)
    {
        Object val = params.get(key);
            return (T) val;
    }
}
