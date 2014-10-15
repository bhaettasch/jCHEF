package de.gfolder.jchef.connectors.system.output;

import de.gfolder.jchef.iostate.Output;
import de.gfolder.jchef.util.AudioFilePlayer;

public class SoundOutput extends Output<String> {
    private static SoundOutput instance;
    private AudioFilePlayer player;

    /**
     * Constructor
     */
    public SoundOutput() {
        super("sound");
        player = new AudioFilePlayer();
    }

    /**
     * Singleton including construction at first call
     *
     * @return instance of console output
     */
    public static SoundOutput getInstance()
    {
        if(instance==null)
            instance = new SoundOutput();
        return instance;
    }

    @Override
    public void set(String filename) {
        player.play(filename);
    }
}
