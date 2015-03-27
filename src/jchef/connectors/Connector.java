package jchef.connectors;

import jchef.exceptions.ManagedObjectNotFoundException;
import jchef.iostate.Input;
import jchef.manager.Managable;
import jchef.manager.Manager;
import jchef.iostate.Output;
import org.json.simple.JSONObject;


public abstract class Connector<I extends Input, O extends Output> implements Managable {

    private String name;

    protected Manager<I> inputs;
    protected Manager<O> outputs;

    /**
     * Constructor
     */
    protected Connector(String name) {
        inputs = new Manager<I>();
        outputs  = new Manager<O>();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract void build(JSONObject json);

    /**
     * Perform all necessary actions to safely end this connection
     */
    public void close()
    {
        //Normally nothing has to be done
    }

    public void addInput(I input)
    {
        inputs.add(input);
    }

    public I getInputByName(String name) throws ManagedObjectNotFoundException {
        return inputs.getByName(name);
    }

    public void addOutput(O output)
    {
        outputs.add(output);
    }

    public O getOutputByName(String name) throws ManagedObjectNotFoundException {
        return outputs.getByName(name);
    }

    public <T> T getInputValue(String inputName)
    {
        try {
            I input = inputs.getByName(inputName);
            return (T) input.getVal();
        } catch (ManagedObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
