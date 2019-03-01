#! /usr/bin/env bash
#########################################################################
#									#
# Script ID: src/prg/java/src/alarmclock/Makefile.am			#
# Author: Copyright (C) 2018-2019  Mark Grant				#
#									#
# Released under the GPLv3 or later.					#
# SPDX-License-Identifier: GPL-3.0-or-later				#
#									#
# Purpose:								#
# AutoMake script file to install alarmclock jar.			#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 15/07/2018	MG	1.0.1	Introduced AutoTools to the project.	#
# 01/03/2019	MG	1.0.2	Change this project jar treatment to	#
#				normal and use new extjarloc configure	#
#				variable for the getopt jar location.	#
#									#
#########################################################################


AlarmClock.png AlarmClock.wav AlarmClockAbout.txt: Makefile
	cp $(@) $(pkgpath)


noinst_DATA = AlarmClock.png AlarmClock.wav AlarmClockAbout.txt


JAVAROOT = .

jarfile = $(PACKAGE_TARNAME)-$(PACKAGE_VERSION).jar

jardir = $(datadir)/java

pkgpath = alarmclock


Version.java: Makefile
	$(edit) $(top_srcdir)/$@.template > $@


AM_JAVACFLAGS = -cp $(extjarloc)/gnu-getopt.jar

$(jarfile): classnoinst.stamp AlarmClock.png AlarmClock.wav AlarmClockAbout.txt
	$(JAR) cf $(JARFLAGS) $@ $(pkgpath)

jar_DATA = $(jarfile)


# Convention requires a link to the jar file without the version information.
install-data-hook:
	cd $(DESTDIR)$(jardir); \
	$(LN_S) $(jarfile) $(PACKAGE_TARNAME).jar

uninstall-local:
	rm -f $(DESTDIR)$(jardir)/$(PACKAGE_TARNAME).jar


dist_noinst_JAVA = AlarmClock.java AlarmClockHelpAboutJDialog.java \
		PlaySoundFile.java PlaySoundThread.java Version.java


EXTRA_DIST = $(srcdir)/AlarmClock.png $(srcdir)/AlarmClock.wav \
		$(srcdir)/AlarmClockAbout.txt


CLEANFILES = $(jarfile) $(pkgpath)/* Version.java
