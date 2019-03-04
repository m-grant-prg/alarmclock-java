#########################################################################
#									#
# Script ID: ./Makefile.am						#
# Author: Copyright (C) 2018, 2019  Mark Grant				#
#									#
# Released under the GPLv3 or later.					#
# SPDX-License-Identifier: GPL-3.0-or-later				#
#									#
# Purpose:								#
# AutoMake script file to generate AlarmClock project from source.	#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 14/07/2018	MG	1.0.1	AutoTools introduced to the project.	#
# 27/10/2018	MG	1.0.2	Change srctarball target to build with	#
#				src between package name and version in	#
#				filename.				#
# 04/03/2019	MG	1.0.3	Remove unnecessary shebang.		#
#				Change source tarball name to be the	#
#				same as that in GitHub releases. This	#
#				aids integrating with rpm generation.	#
#									#
#########################################################################


ACLOCAL_AMFLAGS = -I m4 -I m4extra


SUBDIRS = src/desktop src/distobjects
SUBDIRS += src/man/1
SUBDIRS += src/prg/bash src/prg/java/src/alarmclock


EXTRA_DIST = JavaVersionCheckDist Version.java.template

srctarball:
	@cwd="$${PWD}" && \
	targ="$${cwd}/@PACKAGE_TARNAME@-@PACKAGE_VERSION@.tar.gz" && \
	cd @srcdir@ && \
	echo "making srctarball from @srcdir@" && \
	echo "GA	$${targ}" && \
	git archive --format=tar.gz \
		--prefix=@PACKAGE_TARNAME@-@PACKAGE_VERSION@/ \
		--output=$${targ} \
		HEAD && \
	cd -

