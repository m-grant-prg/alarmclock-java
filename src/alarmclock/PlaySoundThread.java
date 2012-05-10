/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmclock;

import java.net.URL;

/**
 * Runnable Class to play a sound file in a separate thread. Utilises
 * PlaySoundFile class to support play and loop of sound files embedded in the
 * JAR or external files.
 * @author mgrantprg
 */
public class PlaySoundThread implements Runnable {

    private String fileToPlay;
    private URL fileToPlayURL;
    private boolean playFile;
    private boolean loop;

    /**
     * Public constructor used to build an object that plays a file embedded
     * in the JAR.
     * @param file Name of JAR embedded file to play.
     * @param loop True means play in a continuous loop, false means play once.
     */
    public PlaySoundThread(String file, boolean loop) {
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
        this.fileToPlayURL = fileToPlayURL;
        this.playFile = false;
        this.loop = loop;
    }

    /**
     * Override of Thread run() method.
     */
    public void run() {
        Thread thisThread = Thread.currentThread();
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
                thisThread.sleep(20000);
            }
            catch (InterruptedException e) {
                player.stopPlayingFile();
                return;
            }
        }
        player.stopPlayingFile();
    }
}
