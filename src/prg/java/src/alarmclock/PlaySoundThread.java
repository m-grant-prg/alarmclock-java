/*
 * Class ID: PlaySoundThread
 * Copyright (C) 2014-2018, 2020  Mark Grant
 *
 * Released under the GPLv3 or later.
 * SPDX-License-Identifier: GPL-3.0-or-later
 *
 */

/* **********************************************************************
 *									*
 * Changelog								*
 *									*
 * Date		Author	Version	Description				*
 *									*
 * 09/12/2015	MG	1.0.3	Introduced in-source ChangeLogs.	*
 * 25/01/2020	MG	1.0.4	Remove overloading for URL.		*
 *									*
 ************************************************************************
 */

package alarmclock;

import java.net.URL;

/**
 * Class implementing the Runnable interface to play a sound file in a separate
 * thread. Utilises PlaySoundFile class to support play and loop of sound files
 * embedded in the JAR or external files.
 *
 * @author Mark Grant
 * @version 1.0.4
 */
public class PlaySoundThread implements Runnable {

	private String fileToPlay;
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
	 * Implementation of Thread run() method as per the Runnable interface.
	 */
	public void run() {
		PlaySoundFile player = new PlaySoundFile();

		if (this.loop)
			player.playFileLoop(fileToPlay);
		else
			player.playFile(fileToPlay);

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
