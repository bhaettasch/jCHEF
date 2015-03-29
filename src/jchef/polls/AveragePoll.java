package jchef.polls;

public class AveragePoll extends StateBasedPoll<Double> {
    private double tmpValue;
    private int count;

    /**
     * Constructor
     *
     * @param name name of the poll
     */
    public AveragePoll(String name) {
        super(name, 0.0);
    }

    @Override
    protected void startPollComputation() {
        tmpValue = 0.0;
        count = 0;
    }

    @Override
    protected void countVote(Double value) {
        tmpValue += value;
        count++;
    }

    @Override
    protected void finishPollComputation() {
        this.value = tmpValue / count;
    }
}
