#########################################################################
#									#
# Script ID: src/conf/etc/Makefile.am					#
# Author: Copyright (C) 2022 Mark Grant					#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0-only					#
#									#
# Purpose:								#
# AutoMake script file to build the alarmclock-java configuration file.	#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 03/03/2022	MG	1.0.1	Initial release.			#
#									#
#########################################################################


confdir = $(sysconfdir)

alarmclock-java.conf: Makefile
	mkdir -p $(@D)
	rm -f $@ $@.tmp
	test -f ./$@.in || srcdir=$(srcdir)/; \
	$(edit) $${srcdir}$(@F).in > $@.tmp
	mv $@.tmp $@
alarmclock-java.conf: $(srcdir)/alarmclock-java.conf.in

conf_DATA = alarmclock-java.conf

EXTRA_DIST = $(srcdir)/alarmclock-java.conf.in

CLEANFILES = *.tmp alarmclock-java.conf

