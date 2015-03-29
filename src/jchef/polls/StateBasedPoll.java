package jchef.polls;


import java.util.ListIterator;

/**
 * This kind of poll cannot be updated without detailed knowledge about the already processed votes.
 * Every time a new vote is cast, the whole computation has to be run again.
 * It may also be necessary to perform actions before and after the computation takes place.
 *
 * @param <T> type of the vote value (boolean, int, ...)
 */
public abstract class StateBasedPoll<T> extends Poll<T> {
    /**
     * Constructor
     *
     * @param name         name of the poll
     * @param defaultValue default value (to be used during start of voting process or when no value is available)
     */
    public StateBasedPoll(String name, T defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public void addVote(Vote<T> newVote) {
        this.votes.addLast(newVote);

        loopOverList(null, false);
    }

    @Override
    public void removeVote(String voterName) {
        loopOverList(voterName, true);
    }

    /**
     * Loop over list, recalculate value and remove vote if necessary
     *
     * @param voterName name of the voter which vote is to be removed
     * @param remove whether to remove a vote or not
     */
    private void loopOverList(String voterName, Boolean remove)
    {
        startPollComputation();

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

        finishPollComputation();
    }

    /**
     * Init everything needed to calculate poll value
     */
    protected abstract void startPollComputation();

    /**
     * Take current vote into account
     *
     * @param value value of current vote
     */
    protected abstract void countVote(T value);

    /**
     * Finalize poll computation
     */
    protected abstract void finishPollComputation();
}
