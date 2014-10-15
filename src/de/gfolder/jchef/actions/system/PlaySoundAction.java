package de.gfolder.jchef.actions.system;

import de.gfolder.jchef.actions.Action;
import de.gfolder.jchef.connectors.ConnectorManager;
import de.gfolder.jchef.connectors.system.output.SoundOutput;
import de.gfolder.jchef.exceptions.ManagedObjectNotFoundException;

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
