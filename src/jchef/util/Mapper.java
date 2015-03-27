package jchef.util;

import jchef.iostate.Input;

/**
 * Map  and transform values (static helper methods)
 */
public class Mapper {

    /**
     * Map a value from the one given range to another
     *
     * @param outputMin minimal value the output should have
     * @param outputMax maximal value the output should have
     * @param val value to map
     * @param inputMin minimal value that the input might have
     * @param inputMax maximal value that the input might have
     * @return mapped value
     */
    public static float mapRange(float outputMin, float outputMax, float val, float inputMin, float inputMax)
    {
        //Transform to 0-1 range
        float tmpVal = (val - inputMin) / (float) (inputMax - inputMin);
        //Transform to output range (including rounding)
        return tmpVal * (outputMax - outputMin) + outputMin;
    }

    /**
     * Map a value from the one given range to another and round it to int
     *
     * @param outputMin minimal value the output should have
     * @param outputMax maximal value the output should have
     * @param val value to map
     * @param inputMin minimal value that the input might have
     * @param inputMax maximal value that the input might have
     * @return mapped value (rounded to next integer value)
     */
    public static int mapRangeRounded(int outputMin, int outputMax, int val, int inputMin, int inputMax)
    {
        return Math.round(mapRange(outputMin, outputMax, val, inputMin, inputMax));
    }

    /**
     * Map a value from the one given range to another
     * The value and the input range is taken directly from the input
     *
     * @param outputMin minimal value the output should have
     * @param outputMax maximal value the output should have
     * @param input Input object, providing interface to access minimal, maximal and current value
     * @return mapped value
     */
    public static float mapRange(float outputMin, float outputMax, Input<Integer> input)
    {
        float val = (float) input.getVal();
        float inputMin = (float) input.getMin();
        float inputMax = (float) input.getMax();

        return mapRange(outputMin, outputMax, val, inputMin, inputMax);
    }

    /**
     * Map a value from the one given range to another and round it to int
     * The value and the input range is taken directly from the input
     *
     * @param outputMin minimal value the output should have
     * @param outputMax maximal value the output should have
     * @param input Input object, providing interface to access minimal, maximal and current value
     * @return mapped value (rounded to next integer value)
     */
    public static int mapRangeRounded(int outputMin, int outputMax, Input<Integer> input)
    {
        int val = input.getVal();
        int inputMin = input.getMin();
        int inputMax = input.getMax();

        return mapRangeRounded(outputMin, outputMax, val, inputMin, inputMax);
    }

}
