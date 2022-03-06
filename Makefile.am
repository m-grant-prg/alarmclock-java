#########################################################################
#									#
# Script ID: ./Makefile.am						#
# Author: Copyright (C) 2018-2022  Mark Grant				#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0-only					#
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
#				Add install of standard GNU files like	#
#				AUTHORS, etc.				#
# 22/06/2019	MG	1.0.4	To enable make distcheck to work, any	#
#				hard-coded paths requiring permissions	#
#				such as /etc or fixed locations such as	#
#				/usr/share/java must be accommodated,	#
#				so set the configure flags to be used	#
#				by make distcheck.			#
# 22/01/2020	MG	1.0.5	Add jarobjects directory.		#
# 08/11/2021	MG	1.0.6	Add misc directory to DIST.		#
# 29/11/2021	MG	1.0.7	Tighten SPDX tag.			#
# 03/03/2022	MG	1.0.8	Add config file.			#
#									#
#########################################################################


ACLOCAL_AMFLAGS = -I m4 -I m4extra


AM_DISTCHECK_CONFIGURE_FLAGS = --enable-distcheckfake=yes --enable-atonly=yes


SUBDIRS = src/conf/etc
SUBDIRS += src/desktop src/distobjects
SUBDIRS += src/man/1 src/man/5
SUBDIRS += src/prg/bash
SUBDIRS += src/prg/java/src/jarobjects src/prg/java/src/alarmclock


doc_DATA = AUTHORS ChangeLog COPYING NEWS README


EXTRA_DIST = JavaVersionCheckDist Version.java.template \
		$(srcdir)/AUTHORS $(srcdir)/ChangeLog $(srcdir)/COPYING \
		$(srcdir)/NEWS $(srcdir)/README $(srcdir)/misc


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

