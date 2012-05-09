/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmclock;

/**
 *
 * @author mgrantprg
 */
public class PlaySoundThread implements Runnable {

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (!Thread.interrupted()) {
            try {
                PlaySound player = new PlaySound();
                player.playFile("alarm-clock-1.wav");
                thisThread.sleep(15000);
            }
            catch (InterruptedException e) {
                return;
            }
        }
    }
}
