/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmclock;

import java.net.URL;
import java.applet.*;

/**
 *
 * @author mgrantprg
 */
public class PlaySoundFile {

    private AudioClip player;

    public void playFile(String file) {
        URL fileToPlay = this.getClass().getResource(file);
        player = Applet.newAudioClip(fileToPlay);
        player.play();
    }

    public void playFile(URL file) {
        player = Applet.newAudioClip(file);
        player.play();
    }

    public void playFileLoop(String file) {
        URL fileToPlay = this.getClass().getResource(file);
        player = Applet.newAudioClip(fileToPlay);
        player.loop();
    }

    public void playFileLoop(URL file) {
        player = Applet.newAudioClip(file);
        player.loop();
    }

    public void stopFile() {
        player.stop();
    }
}
