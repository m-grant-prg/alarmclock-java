/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmclock;

import java.net.URL;

/**
 *
 * @author mgrantprg
 */
public class PlaySoundThread implements Runnable {

    private String fileToPlay;
    private URL fileToPlayURL;
    private boolean playFile;
    private boolean loop;

    public PlaySoundThread(String file, boolean loop) {
        this.fileToPlay = file;
        this.playFile = true;
        this.loop = loop;
    }

    public  PlaySoundThread(URL fileToPlayURL, boolean  loop) {
        this.fileToPlayURL = fileToPlayURL;
        this.playFile = false;
        this.loop = loop;
    }

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

        while (!Thread.interrupted()) {
            try {
                thisThread.sleep(20000);
            }
            catch (InterruptedException e) {
                player.stopFile();
                return;
            }
        }
        player.stopFile();
    }
}
