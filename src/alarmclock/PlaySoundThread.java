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
## Class ID: PlaySoundThread    					##
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

import java.net.URL;

/**
 * Class implementing the Runnable interface to play a sound file in a separate
 * thread. Utilises PlaySoundFile class to support play and loop of sound files
 * embedded in the JAR or external files.
 *
 * @author Mark Grant
 * @version 1.0.3
 */
public class PlaySoundThread implements Runnable {

    private String fileToPlay;
    private URL fileToPlayURL;
    private boolean playFile;
    private boolean loop;

    /**
     * Thread to be used for playing a sound.
     */
    public Thread playThread;

    /**
     * Public constructor used to build an object that plays a file embedded
     * in the JAR.
     * @param file Name of JAR embedded file to play.
     * @param loop True means play in a continuous loop, false means play once.
     */
    public PlaySoundThread(String file, boolean loop) {
        playThread = new Thread(this);
        this.fileToPlay = file;
        this.playFile = true;
        this.loop = loop;
    }

    /**
     * Public constructor used to build an object that plays an external file
     * pointed at by an URL.
     * @param fileToPlayURL Path to the external file to play.
     * @param loop True means play in a continuous loop, false means play once.
     */
    public  PlaySoundThread(URL fileToPlayURL, boolean  loop) {
        playThread = new Thread(this);
        this.fileToPlayURL = fileToPlayURL;
        this.playFile = false;
        this.loop = loop;
    }

    /**
     * Implementation of Thread run() method as per the Runnable interface.
     */
    public void run() {
        PlaySoundFile player = new PlaySoundFile();

        if (this.playFile)
            if (this.loop)
                player.playFileLoop(fileToPlay);
            else
                player.playFile(fileToPlay);
        else
            if (this.loop)
                player.playFileLoop(fileToPlayURL);
            else
                player.playFile(fileToPlayURL);

        // This loop allows for the thread to be interrupted.
        while (!Thread.interrupted()) {
            try {
                playThread.sleep(20000);
            }
            catch (InterruptedException e) {
                player.stopPlayingFile();
                return;
            }
        }
        player.stopPlayingFile();
    }
}
