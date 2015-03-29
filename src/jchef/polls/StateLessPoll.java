package jchef.polls;


import java.util.ListIterator;

/**
 * This kind of poll can be updated without detailed knowledge about the already processed votes.
 * It only depends on the current vote and the current poll value
 *
 * @param <T> type of the vote value (boolean, int, ...)
 */
public abstract class StateLessPoll<T> extends Poll<T> {

    /**
     * Constructor
     *
     * @param name         name of the poll
     * @param defaultValue default value (to be used during start of voting process or when no value is available)
     */
    public StateLessPoll(String name, T defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public void addVote(Vote<T> newVote) {
        this.votes.addLast(newVote);
        countVote(newVote.getValue());
    }

    @Override
    public void removeVote(String voterName) {
        //Reset poll to default value to allow a new calculation
        this.setDefaultValue();

        //Iterate through all votes in poll, remove the matching vote and update the value concurrently
        ListIterator<Vote<T>> iterator = this.votes.listIterator();
        while(iterator.hasNext())
        {
            Vote<T> vote = iterator.next();
            if(vote.getVoter().equals(voterName))
                iterator.remove();
            else
                this.countVote(vote.getValue());
        }
    }

    /**
     * Update the poll result using the current value of the poll and the new value given as param
     *
     * @param newValue value to use when updating
     */
    protected abstract void countVote(T newValue);
}
