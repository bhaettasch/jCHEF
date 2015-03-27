package jchef.actions.system;

import jchef.actions.Action;
import jchef.connectors.ConnectorManager;
import jchef.connectors.system.output.SoundOutput;
import jchef.exceptions.ManagedObjectNotFoundException;

public class PlaySoundAction extends Action {
    private SoundOutput soundOutput;

    /**
     * Constructor
     *
     * @param soundfile Path to soundfile that should be played
     */
    public PlaySoundAction(String soundfile) {
        setParam("soundfile", soundfile);

        try {
            soundOutput = (SoundOutput) ConnectorManager.getInstance().getOutput("system", "sound");
        } catch (ManagedObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //Play the sound file using a new thread
        // to prevent the program from stopping until the sound finished playing
        Thread t=new Thread() {
            public void run() {
                soundOutput.set((String) getParam("soundfile"));
            }
        };
        t.start();
    }
}
