#########################################################################
#									#
# Script ID: src/prg/java/src/alarmclock/Makefile.am			#
# Author: Copyright (C) 2018-2020  Mark Grant				#
#									#
# Released under the GPLv3 or later.					#
# SPDX-License-Identifier: GPL-3.0-or-later				#
#									#
# Purpose:								#
# AutoMake script file for alarmclock jar.				#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 15/07/2018	MG	1.0.1	Introduced AutoTools to the project.	#
# 08/03/2019	MG	1.0.2	Change this project jar treatment to	#
#				normal and use new extjarloc configure	#
#				variable for the standard jar location	#
#				for use in the ClassPath.		#
#				Remove unnecessary shebang.		#
# 30/03/2019	MG	1.0.3	Add build of javadoc.			#
# 23/06/2019	MG	1.0.4	Add classpath to javadoc to find getopt.#
#				Fix make distcheck issues.		#
# 22/01/2020	MG	1.0.5	Additional jarobjects moved up to	#
#				jarobjects directory.			#
#				Set compile for jdk 8.			#
#									#
#########################################################################


pkgpath = alarmclock


JAVAROOT = .

jarfile = $(PACKAGE_TARNAME)-$(PACKAGE_VERSION).jar

jardir = $(datadir)/java

Version.java: Makefile
	$(edit) $(top_srcdir)/$@.template > $@

AM_JAVACFLAGS = --release 8 -cp "$(extjarloc)/*"

$(jarfile): classnoinst.stamp $(srcdir)/../jarobjects/AlarmClock.png \
	$(srcdir)/../jarobjects/AlarmClock.wav \
	$(srcdir)/../jarobjects/AlarmClockAbout.txt
	$(JAR) cfe $(JARFLAGS) $@ alarmclock.AlarmClock \
		$(srcdir)/../jarobjects $(pkgpath)
	$(JAVADOC) -classpath "$(extjarloc)/*" -sourcepath $(srcdir)/*.java \
		-d ./docs

jar_DATA = $(jarfile)

dist_noinst_JAVA = AlarmClock.java AlarmClockHelpAboutJDialog.java \
		PlaySoundFile.java PlaySoundThread.java Version.java


# Convention requires a link to the jar file without the version information.
install-data-hook:
	cd $(DESTDIR)$(jardir); \
	$(LN_S) $(jarfile) $(PACKAGE_TARNAME).jar

uninstall-local:
	rm -f $(DESTDIR)$(jardir)/$(PACKAGE_TARNAME).jar

clean-local:
	rm -rf ./docs


CLEANFILES = $(jarfile) $(pkgpath)/* Version.java

