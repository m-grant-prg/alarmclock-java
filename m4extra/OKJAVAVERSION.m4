#! /usr/bin/env bash
#########################################################################
#									#
# Macro ID: ./m4extra/OKJAVAVERSION.m4					#
# Author: Copyright (C) 2012-2017  Mark Grant				#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0					#
#									#
# Purpose:								#
# Macro to test for a required java version.				#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 29/06/2014	MG	1.0.1	Initial version.			#
# 07/07/2014	MG	1.0.2	Changed to use new upstream version of	#
#				JavaVersionCheck - v1.0.1		#
# 30/09/2015	MG	1.0.3	Change to use $srcdir from AutoConf so	#
#				it works from whatever build directory.	#
# 04/12/2017	MG	1.0.4	Add SPDX license tags to source files.	#
#									#
#########################################################################


# OKJAVAVERSION(Required_Java_Version, Start_Dir)
# -----------------------------------------------
AC_DEFUN([OKJAVAVERSION],
[echo -n "checking java version "$1"..."
status=notok
if java -jar $2/JavaVersionCheckDist/JavaVersionCheck.jar -m $1; then
	status=ok
fi])
