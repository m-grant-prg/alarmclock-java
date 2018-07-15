#! /usr/bin/env bash
#########################################################################
#									#
# Script ID: src/prg/bash/Makefile.am					#
# Author: Copyright (C) 2012-2018  Mark Grant				#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0					#
#									#
# Purpose:								#
# AutoMake script file to generate alarmclock script from source.	#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 19/06/2014	MG	1.0.1	Started versioning of this script.	#
# 25/11/2014	MG	1.0.2	Add script substitution variable for	#
#				overall package version.		#
# 03/10/2015	MG	1.0.3	Change to conform to AutoTools Template	#
#				version 1.0.4.				#
# 07/10/2015	MG	1.0.4	Re-structure progs area.		#
# 29/04/2017	MG	1.0.5	Rename source file extension .sh.in	#
# 04/12/2017	MG	1.0.6	Add SPDX license tags to source files.	#
# 09/02/2018	MG	1.0.7	Change file's header for new directory	#
#				names.					#
# 18/07/2018	MG	1.0.8	Manual merge with the Java project.	#
#									#
#########################################################################


alarmclock: Makefile
	mkdir -p $(@D)
	rm -f $@ $@.tmp
	test -f ./$@.sh.in || srcdir=$(srcdir)/; \
	$(edit) $${srcdir}$(@F).sh.in > $@.tmp
	mv $@.tmp $@
	chmod a+x $@

alarmclock: $(srcdir)/alarmclock.sh.in

bin_SCRIPTS = alarmclock

EXTRA_DIST = $(srcdir)/alarmclock.sh.in

CLEANFILES = *.tmp alarmclock
