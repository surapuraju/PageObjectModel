#-------------------------------------------------------------------------------
# Name:        JiraExportTestCasesParsing
# Purpose:
#
# Author:      Raju Surapuraju
#
# Created:     30-11-2021
# Copyright:   (c) Raju Surapuraju 2021
# Licence:     Raju Surapuraju
#-------------------------------------------------------------------------------

import os
from configparser import ConfigParser
import datetime

fileDir = os.path.dirname(os.path.realpath('__file__'))
config = ConfigParser()
configFN = "configJiraMetricsBugs.ini"

config.read(configFN)
jiraUser = config.get('section', 'JIRA_USERNAME')
jiraPassword = config.get('section', 'JIRA_PASSWORD')
BaseURL = config.get('section', 'BASE_URL')
JIRASprintName = config.get('section', 'JIRASprintName')


def writeTestCases():



def parseXLSX():





def main():
    parseXLSX()

if __name__ == '__main__':
    main()