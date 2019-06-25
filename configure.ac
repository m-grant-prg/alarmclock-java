#########################################################################
#									#
# Script ID: ./configure.ac						#
# Author: Copyright (C) 2018-2019  Mark Grant				#
#									#
# Released under the GPLv3 only.					#
# SPDX-License-Identifier: GPL-3.0					#
#									#
# Purpose:								#
# AutoConf script file to configure AlarmClock AutoTools project.	#
#									#
# configure cmd line syntax:-						#
# ./configure	[ STDJARLOC=/path/to/standard/jar/location ]		#
#		[ --enable-atonly=<yes|no> [default: no] ]		#
#		[ --enable-distcheckfake=<yes|no> [default: no] ]	#
#		[ --enable-testinghacks=<yes|no> [default: no] ]	#
#									#
# Parameters generic description. For specifics to this configure.ac	#
# please see inline comments at the point of definition:-		#
# STDJARLOC								#
#	This parameter should be used when an absolute jar location is	#
#	required, (eg to consume distro installed jars), that is not	#
#	the Debian location of /usr/share/java. If that is the desired	#
#	distro location use atonly.					#
#	Jar file location defaults to datadir/java for the AT build but	#
#	a jar file installed already (eg getopt) will be in the distro	#
#	production directory such as /usr/share/java (for Debian and	#
#	others). The -atonly option will set this explicitly (ie works	#
#	for Debian and others) but for distros using a different	#
#	location, setting this environment variable will override both	#
#	a standard AT build and the location used during an -atonly	#
#	build.								#
# --enable-atonly							#
#	Used to produce a fully working package just from the AT build	#
#	when the build references a (distro / external) static location	#
#	eg another package's config file in /etc (AOT AT's		#
#	/usr/local/etc), or an externally installed jar file in		#
#	/usr/share/jave (AOT AT's /usr/local/share/java).		#
#	In the case of jar files, atonly will set external jar		#
#	locations for Debian-like distros. For distros using a		#
#	different external jar location, please combine this option	#
#	with the STDJARLOC environment variable mentioned above.	#
# --enable-distcheckfake						#
#	Enables the replacement of an absolute directory path specified	#
#	in a variable, with a value based on AutoTools standard		#
#	directories. This enables the Makefile.am to use the AT		#
#	variable based value when running distcheck and the absolute	#
#	path for all else. Hence distcheck can now succeed when it	#
#	would normally fail.						#
# --enable-testinghacks							#
#	This option should be used when the AT testing environment, (ie	#
#	using the build directory), requires differences in invocation.	#
#	An example would be a shell script invoking a program / script 	#
#	/ jar file. In the AT build directory the script should invoke	#
#	the target in the build system, whereas in production it might	#
#	invoke the target in datadir, datadir/java or pkgdatadir. If	#
#	this was left unchanged the test invocation of the script would	#
#	end up testing any old installed version of the target or	#
#	failing because it cannot be found.				#
#									#
# Layout: (Only relevant sections will exist).				#
# ChangeLog : High level ChangeLog					#
# SECTION  1: Initialisation & Setup					#
# SECTION  2: Architecture, target and host checks			#
# SECTION  3: Command line arguments					#
# SECTION  4: Compiler setup						#
# SECTION  5: Check for programs					#
# SECTION  6: Check for libraries					#
# SECTION  7: Check for header files					#
# SECTION  8: Check for types						#
# SECTION  9: Check for structures					#
# SECTION 10: Check for compiler characteristics			#
# SECTION 11: Check for library functions				#
# SECTION 12: Check for pkg-config files				#
# SECTION 13: Check for system services					#
# SECTION 14: Additional checks & variables				#
# SECTION 15: Specify the output files					#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 14/07/2018	MG	1.0.1	AutoTools introduced to project.	#
# 08/03/2019	MG	1.0.2	Add --enable-atonly option.		#
#				Add --enable-testinghacks option.	#
#				Update to java-vm m4 macros v1.0.5	#
#				Pass bash path to scripts and Makefiles	#
#				Remove preceding v from package version	#
#				as it should not be there.		#
#				Re-vamp to new standard layout.		#
#				Add support for STDJARLOC environment	#
#				variable.				#
# 22/06/2019	MG	1.0.3	Add distcheckfake option.		#
#				Improve in-file comments on CLAs.	#
#									#
#########################################################################


#########################################
#					#
# SECTION  1: Initialisation & Setup	#
#					#
#########################################

AC_REVISION([$Revision: 1.0.3 $])

AC_PREREQ([2.69])

#
# The package version in ac init will be used to create an output variable which
# can be used by ac output and / or the sed setup below to substitute bookmarks
# in source files.
#
AC_INIT(MGE AlarmClock Java Package, 1.1.3,
	m.grant.prg@gmail.com, alarmclock-java)

AC_MSG_NOTICE(initialisation and setup)

AC_SUBST(package_version, $PACKAGE_VERSION)

#
# Passes the options to all am files. Puts objects in the sub-directory
# containing the source. Forces tar to use --format=posix in make dist.
# This also checks :-	BSD install	make variable set	mkdir -p
#			gawk
#
AM_INIT_AUTOMAKE([-Wall -Werror subdir-objects tar-pax])

#
# Standard macros will be automatically placed in m4.
# Programmer defined macros should be placed in, say, m4extra which allows us
# to exclude the standard macros from being git tracked. This other directory
# must be specified as an include option in the Makefile.am ACLOCAL_AMFLAGS
# e.g.
# ACLOCAL_AMFLAGS = -I m4 -I m4extra
#
AC_CONFIG_MACRO_DIR([m4])


#########################################
#					#
# SECTION  3: Command line arguments	#
#					#
#########################################

AC_MSG_NOTICE(checking command line arguments)

#
# The following allows for an enable-atonly=yes/no command line option. The
# conditional ATONLY is made available to the makefiles.
# This allows for a workaround where AutoTools normally has a prefix of
# /usr/local but anything pre-installed would normally be in /usr.
#
AC_ARG_ENABLE(atonly,
	--enable-atonly    Build for AT only testing or installation,
	[case "${enableval}" in
		yes) atonly=true ;;
		no)  atonly=false ;;
		*) AC_MSG_ERROR(bad value ${enableval} for --enable-atonly) ;;
	esac],atonly=false)
AM_CONDITIONAL(ATONLY, test x$atonly = xtrue)

if test "x${atonly}" = xtrue; then
	AC_MSG_NOTICE(Building for AT only testing or installing.)
	AC_SUBST(extjarloc,"/usr/share/java")
else
	AC_SUBST(extjarloc,"$datadir/java")
fi

#
# STDJARLOC can be passed on the configure command line, (preferable), or as a
# pre-set environment variable. If present, it should contain the path to the
# standard jar location, datadir/java on Debian but maybe somewhere else on
# other distros. If present it always overrides the Debian-based standard for
# extjarloc above.
#
if test "$STDJARLOC" != ""; then
	AC_SUBST(extjarloc, "$STDJARLOC")
fi

#
# If a file location has to be fixed, e.g. /etc/foo.conf and never
# /usr/local/etc/foo.conf, then make distcheck will fail. Setting this flag
# allows make distcheck to locate the file in an AT standard directory-based
# location.
# eg /usr/local/etc/foo.conf.
# and hence succeed.
#
AC_ARG_ENABLE([distcheckfake],
	[  --enable-distcheckfake    Enable running of distcheck],
	[case "${enableval}" in
		yes) distcheckfake=true ;;
		no)  distcheckfake=false ;;
		*) AC_MSG_ERROR([bad value ${enableval} for \
			--enable-distcheckfake]) ;;
	esac],[distcheckfake=false])
AM_CONDITIONAL([DISTCHECKFAKE], [test x$distcheckfake = xtrue])

if test "x${distcheckfake}" = xtrue; then
	AC_SUBST([desktoploc], ["$datadir/applications"])
	AC_MSG_NOTICE([Using substitute paths to facilitate distcheck.])
else
	AC_SUBST([desktoploc], ["/usr/share/applications"])
	AC_MSG_NOTICE([Using distcheck incompatible absolute based paths.])
fi

#
# The following allows for an enable-testinghacks=yes/no command line option.
# The conditional TESTINGHACKS is made available to the makefiles.
# This allows different variable substitutions depending on whether in a test
# environment or a production build / install environment.
#
AC_ARG_ENABLE(testinghacks,
	--enable-testinghacks    Build with testing hacks for local testing,
	[case "${enableval}" in
	yes) testinghacks=true ;;
	no)  testinghacks=false ;;
	*) AC_MSG_ERROR(bad value ${enableval} for --enable-testinghacks) ;;
	esac],testinghacks=false)
AM_CONDITIONAL(TESTINGHACKS, test x$testinghacks = xtrue)

if test "x${testinghacks}" = xtrue; then
	AC_MSG_NOTICE(Building with testing hacks for local testing.)
	AC_SUBST(projjarloc,"\$(builddir)/../java/src/alarmclock")
	AC_SUBST(projjarname,"alarmclock-java-$PACKAGE_VERSION.jar")
else
	# If STDJARLOC is supplied it overrides the alternative Debian-based
	# standard for jar file location.
	if test "$STDJARLOC" != ""; then
		AC_SUBST(projjarloc, "$STDJARLOC")
	else
		AC_SUBST(projjarloc,"$datadir/java")
	fi
	AC_SUBST(projjarname,"alarmclock-java.jar")
fi


#################################
#				#
# SECTION  4: Compiler setup	#
#				#
#################################

AC_MSG_NOTICE([checking Java compiler, jre and environment])

# Compiler checks.
AX_PROG_JAVAC

AX_TRY_COMPILE_JAVA

# Check for jar program.
AX_PROG_JAR

# VM checks.
AX_PROG_JAVA

# Compile and run in VM checks.
AX_TRY_RUN_JAVA

# Check for javadoc generator.
AX_PROG_JAVADOC


#########################################
#					#
# SECTION  5: Check for programs	#
#					#
#########################################

AC_MSG_NOTICE(checking for basic programs that have AutoConf checks)

#
# The small set of tools you can expect to find on any machine.
#
# awk		date		grep		od
# basename	diff		join		rm
# cat		dirname		ln		rmdir
# cc		egrep		ls		sed
# chgrp		expr		mkdir		sleep
# chown		expr (‘|’)	mkfifo		sort
# chmod		expr (‘:’)	mknod		tar
# cmp		fgrep		mktemp		touch
# cp		find		mv		tr
#
# (For further information including limitations to the above, see Section 11.15
# in the GNU AutoConf Manual).
#
# If using am init automake, gl early or lt init the following programs are
# automatically checked:-
#
# am init automake
#	BSD install	mkdir -p	gawk
#
# gl early
#	ar	grep	egrep	ranlib
#
# lt init
#	fgrep	ranlib	sed
#
# Basic and AutoTools program checks.
#
AC_PROG_AWK
AC_PROG_EGREP
AC_PROG_FGREP
AC_PROG_GREP
AC_PROG_LN_S
AC_PROG_MKDIR_P
AC_PROG_SED

AC_MSG_NOTICE(checking for some standard AutoTools required programs)
AC_PROG_INSTALL

AC_MSG_NOTICE(checking for particular programs required by this build)
AC_CHECK_PROG([TAR], [tar], [yes], [no])
if test "x$TAR" = "xno" ; then
	AC_MSG_ERROR([tar not found])
fi

AC_CHECK_PROG([TXT2MAN], [txt2man], [yes], [no])
if test "x$TXT2MAN" = "xno" ; then
	AC_MSG_ERROR([txt2man not found])
fi

AC_CHECK_PROG([TXT2MANWRAP], [txt2manwrap], [yes], [no])
if test "x$TXT2MANWRAP" = "xno" ; then
	AC_MSG_ERROR([txt2manwrap not found])
fi

AC_MSG_NOTICE(checking for particular programs required at build and run time)
AC_PATH_PROG([BASH], [bash], [no])
if test "x$BASH" = "xno" ; then
	AC_MSG_ERROR([bash not found])
fi

AC_MSG_NOTICE(checking for particular programs required at run time)
AC_CHECK_PROG(ECHO, echo, yes, no)
if test "x$ECHO" = "xno" ; then
	AC_MSG_WARN(echo not found - needed at run time)
fi

AC_CHECK_PROG(PRINTF, printf, yes, no)
if test "x$PRINTF" = "xno" ; then
	AC_MSG_WARN(printf not found - needed at run time)
fi

AC_CHECK_PROG([GETOPT], [getopt], [yes], [no])
if test "x$GETOPT" = "xno" ; then
	AC_MSG_WARN(getopt not found - needed at run time)
fi


#########################################################
#							#
# SECTION 10: Check for compiler characteristics	#
#							#
#########################################################

AC_MSG_NOTICE(checking for compiler characteristics)

# Specially written m4 macro.
JAVA_VERSION_OK(1.7, $srcdir)


#################################################
#						#
# SECTION 14: Additional checks & variables	#
#						#
#################################################

AC_MSG_NOTICE(processing additional checks and variables)

#
# Now set up a sed sequence to substitute bookmarks in script files with either
# standard GNU Directory Variables, or with programmer-defined variables set up
# using an AC_SUBST macro above. This sed sequence will be invoked at programmer
# discretion at sub-directory Makefile.am level.
# ----------------------
#
# prefix	/usr/local (typically)
#	exec_prefix	${prefix}
#		bindir	${exec_prefix}/bin	user executables
#		sbindir	${exec_prefix}/sbin	system admin executables
#		libexecdir	${exec_prefix}/libexec	program executables
#		libdir	${exec_prefix}/lib	object code libraries
#	sysconfdir	 ${prefix}/etc	read-only single-machine data
#	sharedstatedir	${prefix}/com	modifiable architecture-independent data
#	localstatedir	${prefix}/var	modifiable single-machine data
#	runstatedir	${localstatedir}/run
#	includedir	${prefix}/include	C header files
#	oldincludedir	$usr/include	C header files
#	datarootdir	${prefix}/share	read-only arch.-independent data root
#		localedir	${datarootdir}/locale	locale-dependent data
#		datadir	${datarootdir}	read-only architecture-independent data
#		mandir	${datarootdir}/man	man documentation
#		infodir	${datarootdir}/info	info documentation
#		docdir	${datarootdir}/doc/${PACKAGE}	documentation root
#			htmldir	${docdir}	html documentation
#			dvidir	${docdir}	dvi documentation
#			pdfdir	${docdir}	pdf documentation
#			psdir	${docdir}	ps documentation
#		lispdir	${datarootdir}/emacs/site-lisp
#	pkgdatadir	${datarootdir}/${PACKAGE}
#	pkgincludedir	${includedir}/${PACKAGE}
#	pkglibdir	${libdir}/${PACKAGE}
#	pkglibexecdir	${libexecdir}/${PACKAGE}
#
AC_SUBST([edit], ["sed \
		-e 's|@desktoploc[@]|\$(desktoploc)|g' \
		-e 's|@bashlocation[@]|\$(BASH)|g' \
		-e 's|@projjarloc[@]|\$(projjarloc)|g' \
		-e 's|@projjarname[@]|\$(projjarname)|g' \
		-e 's|@extjarloc[@]|\$(extjarloc)|g' \
		-e 's|@package_version[@]|\$(package_version)|g' \
		-e 's|@prefix[@]|\$(prefix)|g' \
		-e 's|@exec_prefix[@]|\$(exec_prefix)|g' \
		-e 's|@bindir[@]|\$(bindir)|g' \
		-e 's|@sbindir[@]|\$(sbindir)|g' \
		-e 's|@libexecdir[@]|\$(libexecdir)|g' \
		-e 's|@libdir[@]|\$(libdir)|g' \
		-e 's|@sysconfdir[@]|\$(sysconfdir)|g' \
		-e 's|@sharedstatedir[@]|\$(sharedstatedir)|g' \
		-e 's|@localstatedir[@]|\$(localstatedir)|g' \
		-e 's|@runstatedir[@]|\$(runstatedir)|g' \
		-e 's|@includedir[@]|\$(includedir)|g' \
		-e 's|@oldincludedir[@]|\$(oldincludedir)|g' \
		-e 's|@datarootdir[@]|\$(datarootdir)|g' \
		-e 's|@localedir[@]|\$(localedir)|g' \
		-e 's|@datadir[@]|\$(datadir)|g' \
		-e 's|@mandir[@]|\$(mandir)|g' \
		-e 's|@infodir[@]|\$(infodir)|g' \
		-e 's|@docdir[@]|\$(docdir)|g' \
		-e 's|@htmldir[@]|\$(htmldir)|g' \
		-e 's|@dvidir[@]|\$(dvidir)|g' \
		-e 's|@pdfdir[@]|\$(pdfdir)|g' \
		-e 's|@psdir[@]|\$(psdir)|g' \
		-e 's|@lispdir[@]|\$(lispdir)|g' \
		-e 's|@pkgdatadir[@]|\$(pkgdatadir)|g' \
		-e 's|@pkgincludedir[@]|\$(pkgincludedir)|g' \
		-e 's|@pkglibdir[@]|\$(pkglibdir)|g' \
		-e 's|@pkglibexecdir[@]|\$(pkglibexecdir)|g'"])


#########################################
#					#
# SECTION 15: Specify the output files	#
#					#
#########################################

AC_MSG_NOTICE(processing output files)

#
# Non-Makefile files to generate.
# AC_CONFIG_FILES should not be used to substitute AutoConf Installation
# Directory Variables, (bindir and friends), except in Makefiles and pkg-config
# files. See GNU AutoConf manual section 4.8.2 Installation Directory Variables.
#

# Project Makefiles to create.
AC_CONFIG_FILES([Makefile
		src/desktop/Makefile
		src/distobjects/Makefile
		src/man/1/Makefile
		src/prg/bash/Makefile
		src/prg/java/src/alarmclock/Makefile])

AC_OUTPUT

