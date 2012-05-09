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
public class PlaySound {

    public void playFile(String file) {
        URL fileToPlay = getClass().getResource(file);
        AudioClip player = Applet.newAudioClip(fileToPlay);
        player.play();
    }
}
