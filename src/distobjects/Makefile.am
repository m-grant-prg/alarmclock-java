#########################################################################
#									#
# Script ID: src/distobjects/Makefile.am				#
# Author: Copyright (C) 2012-2019  Mark Grant				#
#									#
# Released under the GPLv3 or later.					#
# SPDX-License-Identifier: GPL-3.0-or-later				#
#									#
# Purpose:								#
# AutoMake script file to install alarmclock icon.			#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 19/06/2014	MG	1.0.1	Started versioning of this script.	#
# 08/12/2014	MG	1.0.2	Add distribution of GNU getopt library.	#
# 03/10/2015	MG	1.0.3	Change to conform to AutoTools Template	#
#				version 1.0.4.				#
# 07/10/2015	MG	1.0.4	Re-structure progs area.		#
# 23/10/2015	MG	1.0.5	Restructure to conform to AutoTools	#
#				General Template v1.0.6.		#
# 04/12/2017	MG	1.0.6	Add SPDX license tags to source files.	#
# 09/02/2018	MG	1.0.7	Change file's header for new directory	#
#				names.					#
# 18/07/2018	MG	1.0.8	Manual merge with Java project.		#
# 03/03/2019	MG	1.0.9	Remove unnecessary shebang.		#
#									#
#########################################################################


AlarmClock.png: Makefile
	mkdir -p $(@D)
	rm -f $(@)
	cp $(srcdir)/$(@F).in $@

AlarmClock.png: $(srcdir)/AlarmClock.png.in

pkgdata_DATA = AlarmClock.png

EXTRA_DIST = $(srcdir)/AlarmClock.png.in

CLEANFILES = *.tmp AlarmClock.png

