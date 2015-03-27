package jchef.manager;

import jchef.exceptions.ManagedObjectNotFoundException;

import java.util.Collection;
import java.util.HashMap;

/**
 * controller
 *
 * @author Benjamin Haettasch <Benjamin.Haettasch@googlemail.com>
 * @version 0.1
 */

public class Manager<T extends Managable> {
    protected HashMap<String, T> objs;

    /**
     * Constructor
     */
    public Manager()
    {
        this.objs = new HashMap<String, T>();
    }

    /**
     * Add the given io to the list of managed inputs
     *
     * @param entry object to add
     */
    public void add(T entry)
    {
        objs.put(entry.getName(), entry);
    }

    /**
     * Get Input by name
     *
     * @param name name of the io object
     * @return The io with the given name
     * @throws jchef.exceptions.ManagedObjectNotFoundException
     */
    public T getByName(String name) throws ManagedObjectNotFoundException
    {
        T obj = objs.get(name);
        if(obj == null)
            throw new ManagedObjectNotFoundException();
        return (T) obj;
    }

    /**
     * Get a collection of all entries stored in this manager
     *
     * @return collection of entries
     */
    public Collection<T> getEntries()
    {
        return objs.values();
    }

    /**
     * Remove the entry with the given name from managed list/table
     *
     * @param entryName name of the event to remove
     */
    public void remove(String entryName)
    {
        objs.remove(entryName);
    }
}
