#########################################################################
#									#
# Script ID: src/desktop/Makefile.am					#
# Author: Copyright (C) 2012-2019, 2021  Mark Grant			#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0-only					#
#									#
# Purpose:								#
# AutoMake script file to generate alarmclock.desktop file from source.	#
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
# 23/10/2015	MG	1.0.4	Restructure to conform to AutoTools	#
#				General Template v1.0.6.		#
# 04/12/2017	MG	1.0.5	Add SPDX license tags to source files.	#
# 09/02/2018	MG	1.0.6	Change file's header for new directory	#
#				names.					#
# 18/07/2018	MG	1.0.7	Manual merge with Java project which	#
#				cannot support make distcheck so remove	#
#				support here.				#
# 03/03/2019	MG	1.0.8	Remove unnecessary shebang.		#
# 22/06/2019	MG	1.0.9	Add support for make distcheck.		#
# 29/11/2021	MG	1.0.10	Tighten SPDX tag.			#
#									#
#########################################################################


# desktoploc is set in configure.ac to provide a conditional target depending
# on whether distcheck is being run.

desktopdir = $(desktoploc)


alarmclock.desktop: Makefile
	mkdir -p $(@D)
	rm -f $@ $@.tmp
	test -f ./$@.in || srcdir=$(srcdir)/; \
	$(edit) $${srcdir}$(@F).in > $@.tmp
	mv $@.tmp $@

alarmclock.desktop: $(srcdir)/alarmclock.desktop.in

desktop_DATA = alarmclock.desktop

EXTRA_DIST = $(srcdir)/alarmclock.desktop.in

CLEANFILES = *.tmp alarmclock.desktop
