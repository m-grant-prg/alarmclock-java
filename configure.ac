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
# ./configure	[--enable-atonly=<yes|no> [default: no]			#
#		 --enable-testinghacks=<yes|no> [default: no]]		#
#									#
#########################################################################

#########################################################################
#									#
# Changelog								#
#									#
# Date		Author	Version	Description				#
#									#
# 14/07/2018	MG	1.0.1	AutoTools introduced to project.	#
# 03/03/2019	MG	1.0.2	Add --enable-atonly option.		#
#				Add --enable-testinghacks option.	#
#				Update to java-vm m4 macros v1.0.5	#
#				Pass bash path to scripts and Makefiles	#
#									#
#########################################################################

AC_REVISION([$Revision: 1.0.2 $])

AC_PREREQ([2.69])


########################
#
# The package version in ac init will be used to create an output variable which
# can be used by ac output and / or the sed setup below to substitute bookmarks
# in source files.
#
########################

AC_INIT(MGE AlarmClock Java Package, v1.0.20,
	m.grant.prg@gmail.com, alarmclock-java)

AC_SUBST(package_version, $PACKAGE_VERSION)

########################
#
# Generating canonical information helps some of the AutoConf Archive macros.
#
########################

AC_CANONICAL_SYSTEM


########################
#
# The following allows for an enable-atonly=yes/no command line option. The
# conditional ATONLY is made available to the makefiles.
#
########################

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

########################
#
# The following allows for an enable-testinghacks=yes/no command line option.
# The conditional TESTINGHACKS is made available to the makefiles.
#
########################

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
	AC_SUBST(projjarloc,"$datadir/java")
	AC_SUBST(projjarname,"alarmclock-java.jar")
fi


########################
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
########################

AC_SUBST([edit], ["sed \
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


# Passes the options to all am files. Puts objects in the sub-directory
# containing the source. Forces tar to use --format=posix in make dist.
# This also checks :-	BSD install	make variable set	mkdir -p
#			gawk
AM_INIT_AUTOMAKE([-Wall -Werror subdir-objects tar-pax])


########################
#
# Standard macros will be automatically placed in m4.
# Programmer defined macros should be placed in, say, m4extra which allows us
# to exclude the standard macros from being git tracked. This other directory
# must be specified as an include option in the Makefile.am ACLOCAL_AMFLAGS
# e.g.
# ACLOCAL_AMFLAGS = -I m4 -I m4extra
#
########################

AC_CONFIG_MACRO_DIR([m4])


########################
#
# Checks for programs.
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
# Particular and generic program checks follow:
#
########################

AC_PROG_LN_S


AC_MSG_NOTICE([checking for particular programs required by this application])
AC_PROG_SED

AC_MSG_NOTICE([checking for generic programs required by this application])
AC_CHECK_PROG([TAR], [tar], [yes], [no])
if test "x$TAR" = "xno" ; then
	AC_MSG_ERROR([tar not found])
fi

AC_CHECK_PROG([GETOPT], [getopt], [yes], [no])
if test "x$GETOPT" = "xno" ; then
	AC_MSG_ERROR([getopt not found])
fi

AC_PATH_PROG([BASH], [bash], [no])
if test "x$BASH" = "xno" ; then
	AC_MSG_ERROR([bash not found])
fi

AC_CHECK_PROG([TXT2MAN], [txt2man], [yes], [no])
if test "x$TXT2MAN" = "xno" ; then
   	AC_MSG_ERROR([txt2man not found])
fi

AC_CHECK_PROG([TXT2MANWRAP], [txt2manwrap], [yes], [no])
if test "x$TXT2MANWRAP" = "xno" ; then
   	AC_MSG_ERROR([txt2manwrap not found])
fi

# Perform Java checks.
AX_PROG_JAVAC

AX_TRY_COMPILE_JAVA

AX_PROG_JAR

AX_PROG_JAVA

AX_TRY_RUN_JAVA

AX_PROG_JAVADOC

# Specially written m4 macro.
JAVA_VERSION_OK(1.7, $srcdir)


# Checks for libraries.

# Checks for C header files.

# Checks for C++ header files.

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.

# Checks for pkg-config files.

# Project Makefiles to create.
AC_CONFIG_FILES([Makefile
		src/desktop/Makefile
		src/distobjects/Makefile
		src/man/1/Makefile
		src/prg/bash/Makefile
		src/prg/java/src/alarmclock/Makefile])

AC_OUTPUT
