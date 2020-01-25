/*
 * Class ID: PlaySoundFile
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
 * 22/01/2020	MG	1.0.4	Add getClassLoader to access resource.	*
 * 25/01/2020	MG	1.0.5	Replace deprecated AudioClip / Applet	*
 *				usage.					*
 *				Use buffered input stream to avoid some	*
 *				platforms throwing an IO exception due	*
 *				to mark / reset not supported on wav	*
 *				file.					*
 *									*
 ************************************************************************
 */

package alarmclock;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class to play a sound file using the AudioClip player. Supports the playing
 * of JAR embedded files and of external files. Also supports play once or loop.
 *
 * @author Mark Grant
 * @version 1.0.5
 */
public class PlaySoundFile {

	private AudioInputStream audioStream;
	private Clip audioClip;

	/**
	 * Plays the 'file' embedded in the JAR.
	 * Can be stopped using the stopPlayingFile Method.
	 * @param file Name of embedded file to play.
	 */
	public void playFile(String file) {
		try {
			BufferedInputStream bufAudioStream = new BufferedInputStream(this.getClass()
				.getClassLoader().getResourceAsStream(file));
			audioStream = AudioSystem.getAudioInputStream(bufAudioStream);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.start();
		} catch (UnsupportedAudioFileException ex) {
			Logger.getLogger(PlaySoundFile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (LineUnavailableException ex) {
			Logger.getLogger(PlaySoundFile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PlaySoundFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Plays the 'file' embedded in the JAR in a continuous loop.
	 * Can be stopped using the stopPlayingFile Method.
	 * @param file Name of the embedded file to play.
	 */
	public void playFileLoop(String file) {
		try {
			BufferedInputStream bufAudioStream = new BufferedInputStream(this.getClass()
				.getClassLoader().getResourceAsStream(file));
			audioStream = AudioSystem.getAudioInputStream(bufAudioStream);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.loop(LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException ex) {
			Logger.getLogger(PlaySoundFile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (LineUnavailableException ex) {
				Logger.getLogger(PlaySoundFile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PlaySoundFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Stops playing the current file.
	 */
	public void stopPlayingFile() {
		audioClip.stop();
	}
}
