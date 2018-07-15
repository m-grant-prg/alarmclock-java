#! /usr/bin/env bash
#########################################################################
#									#
# Script ID: src/prg/java/src/alarmclock/Makefile.am			#
# Author: Copyright (C) 2018  Mark Grant				#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0					#
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
#									#
#########################################################################


AlarmClock.png AlarmClock.wav AlarmClockAbout.txt: Makefile
	cp $(@) $(pkgpath)


noinst_DATA = AlarmClock.png AlarmClock.wav AlarmClockAbout.txt


JAVAROOT = .

jarfile = $(PACKAGE_TARNAME)-$(PACKAGE_VERSION).jar

# Obviously for this externally installed jar library, something like
# /usr/local/share/java wouldn't work.
if DEBUG
jardir = /usr/share/java
else
jardir = $(datadir)/java
endif

pkgpath = alarmclock


Version.java: Makefile
	$(edit) $(top_srcdir)/$@.template > $@


AM_JAVACFLAGS = -cp $(jardir)/gnu-getopt.jar

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
