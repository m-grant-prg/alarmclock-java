/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmclock;

import java.net.URL;
import java.applet.*;

/**
 * Class to play a sound file using the AudioClip player. Supports the playing
 * of JAR embedded files and of external files. Also supports play once or loop.
 * 
 * @author Mark Grant
 * @version 0.1
 */
public class PlaySoundFile {

    private AudioClip player;

    /**
     * Plays the 'file' embedded in the JAR.
     * Can be stopped using the stopPlayingFile Method.
     * @param file Name of embedded file to play.
     */
    public void playFile(String file) {
        URL fileToPlay = this.getClass().getResource(file);
        player = Applet.newAudioClip(fileToPlay);
        player.play();
    }

    /**
     * Plays the file as detailed in the URL.
     * Can be stopped using the stopPlayingFile Method.
     * @param file URL of the path to the file to play.
     */
    public void playFile(URL file) {
        player = Applet.newAudioClip(file);
        player.play();
    }

    /**
     * Plays the 'file' embedded in the JAR in a continuous loop.
     * Can be stopped using the stopPlayingFile Method.
     * @param file Name of the embedded file to play.
     */
    public void playFileLoop(String file) {
        URL fileToPlay = this.getClass().getResource(file);
        player = Applet.newAudioClip(fileToPlay);
        player.loop();
    }

    /**
     * Plays the file as detailed in the URL in a continuous loop.
     * Can be stopped using the stopPlayingFile Method.
     * @param file URL of the path to the file to play.
     */
    public void playFileLoop(URL file) {
        player = Applet.newAudioClip(file);
        player.loop();
    }

    /**
     * Stops playing the current file.
     */
    public void stopPlayingFile() {
        player.stop();
    }
}
