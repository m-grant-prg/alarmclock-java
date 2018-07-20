#! /usr/bin/env bash
#########################################################################
#									#
# Script ID: src/man/1/Makefile.am					#
# Author: Copyright (C) 2012-2018  Mark Grant				#
#									#
# Released under the GPLv3 or later.					#
# SPDX-License-Identifier: GPL-3.0-or-later				#
#									#
# Purpose:								#
# AutoMake script file to generate AlarmClock manual pages from		#
# source.								#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 19/06/2014	MG	1.0.1	Started versioning of this script.	#
# 03/10/2015	MG	1.0.2	Change to conform to AutoTools Template	#
#				version 1.0.4.				#
# 07/10/2015	MG	1.0.3	Re-structure progs area.		#
# 29/04/2017	MG	1.0.4	Output from $(edit) was being ignored.	#
#				Rename source file extension .man.in	#
# 04/12/2017	MG	1.0.5	Determine the manual section from the	#
#				target suffix. If the suffix is blank	#
#				(foo.) or if there is no suffix (foo)	#
#				then error out.				#
#				Add SPDX license tags to source files.	#
# 09/02/2018	MG	1.0.6	Change file's header for new directory	#
#				names.					#
# 18/07/2018	MG	1.0.7	Manual merge with Java project.		#
#									#
#########################################################################


alarmclock.1: Makefile
	mkdir -p $(@D)
	rm -f $@ $@.tmp
	$(edit) $(srcdir)/$(@F).man.in > $@.tmp
	targfile=$(@F);	\
	if [[ $$targfile == *"."* ]]; then \
		if [[ $${targfile##*.} == "" ]]; then \
			echo "Source file suffix used as section but empty."; \
			exit 1; \
		else \
			section=$${targfile##*.}; \
		fi; \
	else \
		echo "Source file suffix used as section but no dot & empty."; \
		exit 1; \
	fi; \
	txt2manwrap $(@F) $$section "AlarmClock Manual" $@.tmp $@
	rm -f $@.tmp

alarmclock.1: $(srcdir)/alarmclock.1.man.in

man_MANS = alarmclock.1

EXTRA_DIST = $(srcdir)/alarmclock.1.man.in

CLEANFILES = *.tmp alarmclock.1
