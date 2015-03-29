package jchef.polls;

public class AndPoll extends StateLessPoll<Boolean> {
    /**
     * Constructor
     *
     * @param name name of the poll
     */
    public AndPoll(String name) {
        super(name, true);
    }

    @Override
    protected void countVote(Boolean newValue) {
        this.value = newValue && this.value;
    }
}
