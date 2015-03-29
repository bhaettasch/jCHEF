package jchef.polls;

public class OrPoll extends StateLessPoll<Boolean> {
    /**
     * Constructor
     *
     * @param name name of the poll
     */
    public OrPoll(String name) {
        super(name, false);
    }

    @Override
    protected void countVote(Boolean newValue) {
        this.value = newValue || this.value;
    }
}
