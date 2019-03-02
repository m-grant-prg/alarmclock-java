#! /usr/bin/env bash
#########################################################################
#									#
# Macro ID: m4extra/java-vm.m4						#
# Author: Copyright (C) 2014-2019  Mark Grant				#
#									#
# Released under the GPLv3 or later.					#
# SPDX-License-Identifier: GPL-3.0-or-later				#
#									#
# Purpose:								#
# Macros pertaining to the Java VM.					#
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
# 02/03/2019	MG	1.0.5	Change to better macro and file name.	#
#				Exit from here on error, no need for	#
#				error testing in configure.ac		#
#									#
#########################################################################


# JAVA_VERSION_OK(Required_Java_Version, Start_Dir)
# -----------------------------------------------
AC_DEFUN([JAVA_VERSION_OK],
[echo -n "checking for java version >= "$1" ... "
if ! java -jar $2/JavaVersionCheckDist/JavaVersionCheck.jar -m $1; then
   	AC_MSG_ERROR([java jre not suitable])
fi])
