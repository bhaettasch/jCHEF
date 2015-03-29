package jchef.polls;

import jchef.manager.Managable;
import java.util.LinkedList;

/**
 * Determine a value by taking votes from different parties (logic modules) into account
 *
 * @param <T> type of the vote value (boolean, int, ...)
 */
public abstract class Poll<T> implements Managable {

    private String name;

    protected T value;
    protected T defaultValue;

    protected LinkedList<Vote<T>> votes;

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Constructor
     *
     * @param name name of the poll
     * @param defaultValue default value (to be used during start of voting process or when no value is available)
     */
    public Poll(String name, T defaultValue)
    {
        this.name = name;
        this.defaultValue = value;
        this.value = defaultValue;
        this.votes = new LinkedList<>();
    }

    /**
     * Set value to default value
     */
    protected void setDefaultValue()
    {
        this.value = this.defaultValue;
    }

    /**
     * Get Value
     *
     * @return return voting value of this vote
     */
    public T getValue()
    {
        return this.value;
    }

    /**
     * Add a new vote and trigger recalculation of value
     *
     * @param newVote vote to add
     */
    public abstract void addVote(Vote<T> newVote);

    /**
     * Remove vote by given voter and trigger recalculation of value
     * @param voterName name of the voter
     */
    public abstract void removeVote(String voterName);
}
