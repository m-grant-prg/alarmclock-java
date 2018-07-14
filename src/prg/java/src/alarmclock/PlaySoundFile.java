/*
 * Copyright (C) 2014 Mark Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*########################################################################
##									##
## Class ID: PlaySoundFile      					##
## Author: Mark Grant							##
##									##
## Further Info:							##
##									##
##########################################################################

##########################################################################
##									##
## Changelog								##
##									##
## Date		Author	Version	Description				##
##									##
## 09/12/2015	MG	1.0.3	Introduced in-source ChangeLogs.	##
##									##
##########################################################################
*/

package alarmclock;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Class to play a sound file using the AudioClip player. Supports the playing
 * of JAR embedded files and of external files. Also supports play once or loop.
 *
 * @author Mark Grant
 * @version 1.0.3
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
