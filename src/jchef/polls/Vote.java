package jchef.polls;

/**
 * Class representing a vote
 * A vote may not be changed, but only added and removed to a poll
 *
 * @param <T> type of the vote value (boolean, int, ...)
 */
public class Vote<T> {
    private final String voter;
    private final T value;

    /**
     * Constructor
     *
     * @param voter name of the voter (to identify vote when revoking)
     * @param value constant value this vote is voting for
     */
    public Vote(String voter, T value) {
        this.voter = voter;
        this.value = value;
    }

    /**
     * Get voter name (constant)
     *
     * @return voter name
     */
    public String getVoter() {
        return voter;
    }

    /**
     * Get value of this vote (constant)
     *
     * @return value
     */
    public T getValue() {
        return value;
    }
}
