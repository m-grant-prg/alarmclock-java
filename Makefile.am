#! /usr/bin/env bash
#########################################################################
#									#
# Script ID: ./Makefile.am						#
# Author: Copyright (C) 2018  Mark Grant				#
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
#									#
#########################################################################


ACLOCAL_AMFLAGS = -I m4 -I m4extra


SUBDIRS = src/desktop src/distobjects
SUBDIRS += src/man/1
SUBDIRS += src/prg/bash src/prg/java/src/alarmclock


EXTRA_DIST = JavaVersionCheckDist Version.java.template

srctarball:
	@cwd="$${PWD}" && \
	cd @srcdir@ && \
	echo "making srctarball from @srcdir@" && \
	echo "GA	@builddir@/@PACKAGE_TARNAME@-@PACKAGE_VERSION@.tar.gz" \
	&& \
	git archive --format=tar.gz \
		--prefix=@PACKAGE_TARNAME@-@PACKAGE_VERSION@/ \
		--output=$${cwd}/@PACKAGE_TARNAME@-@PACKAGE_VERSION@.tar.gz \
		HEAD && \
	cd -
