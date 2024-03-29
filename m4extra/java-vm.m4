#! /usr/bin/env bash
#########################################################################
#									#
# Macro ID: m4extra/java-vm.m4						#
# Author: Copyright (C) 2014-2019, 2021-2023  Mark Grant		#
#									#
# This file is maintained in the project at:-				#
#	https://github.com/m-grant-prg/project-misc			#
#		new versions are merely copied to consumer projects.	#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0-only					#
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
# 21/11/2021	MG	1.0.6	Tighten SPDX tag.			#
# 06/06/2022	MG	1.1.1	Add MG_ namespace.			#
# 22/02/2023	MG	1.1.2	Add a comment that this file is		#
#				maintained in another project.		#
#									#
#########################################################################


# MG_JAVA_VERSION_OK(Required_Java_Version, Start_Dir)
# ----------------------------------------------------
AC_DEFUN([MG_JAVA_VERSION_OK],
[echo -n "checking for java version >= "$1" ... "
if ! java -jar $2/JavaVersionCheckDist/JavaVersionCheck.jar -m $1; then
   	AC_MSG_ERROR([java jre not suitable])
fi])
