#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      91973
#
# Created:     30-11-2021
# Copyright:   (c) 91973 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------

from cx_Freeze import setup, Executable

base = None

executables = [Executable("TestCasesParsing_V5.py", base=base)]

packages = ["idna"]
options = {
    'build_exe': {
        'packages':packages,
    },
}

setup(
    name = "Py2Exe",
    options = options,
    version = "1",
    description = 'TestCasesParser',
    executables = executables
)