#-------------------------------------------------------------------------------
# Name:        Automation Statistical Data
# Purpose:     Automation Statistical Data
#
# Author:      Raju Surapuraju
#
# Created:     16/12/2021
# Copyright:   (c) Raju Surapuraju 2021
# Licence:     Raju Surapuraju
#-------------------------------------------------------------------------------

import os
import pathlib
import pymysql

#global filePath

#filePath = "C:\\Tools\\GitHub\\Temp\\AutomationFrameWork\\LSHawkEyes\\Scripts\\com\\arisglobal\\scripts\\testscripts\\lsmv\\L10_1_0_1\\"
filePath = "C:\\QEDev\GitHub\\Tools\\CodeParser\\Source\\AutomationFrameWork\\LSHawkEyes\\Scripts\\com\\arisglobal\\scripts\\testscripts\\lsmv\\L10_3"
#filePath = "C:\\QEDev\GitHub\\Tools\\CodeParser\\Source\\Temp"

Product = "LSMV"
Version = "103"
#TestName = "001 Sample Test"
#TestDesc = "001 Sample Test Description"
#Priority = 0

global idw
idw = 100000

db = pymysql.connect("192.168.111.41", "root", "Password1$", "dashboard")
cursor = db.cursor()

def updateAutomationTable(Product, Version, Module, FileName, TestName, TestDesc, Priority):

    cursor.execute("""
           INSERT INTO automation
           SET Product=%s, Version=%s, Module=%s, FileName=%s, TestName=%s, TestDesc=%s, Priority=%s

        """, (Product, Version, Module, FileName, TestName, TestDesc, Priority))
    db.commit()

def find_all(a_str, sub):
    start = 0
    while True:
        start = a_str.find(sub, start)
        if start == -1: return
        yield start
        start += len(sub) # use start += 1 to find overlapping matches


def extractTestCaseData(fileN, FileName, Module): # to parse and get test case data
    global idw
    print(fileN)
    with open(fileN, encoding="utf-8") as f:
        for line in f:
            #print(line)
            if '@Test' in line:
                if '//' not in line:
                    if '/*' not in line:
                        if '*' not in line:
                            #print(result)
                            #print(line)
                            indexW = list(find_all(line, '"')) # to find all quotes in the current line - it would return four sritng indices in a list
                            print (indexW[0])
                            print (indexW[1])
                            print (indexW[2])
                            print (indexW[3])

                            TestName = line[indexW[0]+1:indexW[1]] # get Test Case Name
                            TestDesc = line[indexW[2]+1:indexW[3]] # get Test Case Description
                            print(TestName)
                            print(TestDesc)

                            word = 'priority'
                            wordStartIndex = line.index(word) + len(word) + 3
                            priorityValue = line[wordStartIndex:wordStartIndex+1]
                            #print(priorityValue)
                            Priority = priorityValue

                            idw = idw + 1
                            Id = idw

                            updateAutomationTable(Product, Version, Module, FileName, TestName, TestDesc, Priority)

def getData():
    flist = []

    for fileDir in pathlib.Path(filePath).iterdir(): # loop to get automation directories
        if fileDir.is_dir(): # each is dir represents a Module
            #print(fileDir)
            fullPath, ModuleName = os.path.split(fileDir) # split the string and get Modules Name
            Module = ModuleName

            for fileN in pathlib.Path(fileDir).iterdir(): # use the fullPath with fileName to get access to file and subsequently read
                if fileN.is_file():
                    #print(fileN)
                    fullPath, FileName = os.path.split(fileN)

                    #print("Full File Path: " + str(fileN))
                    #print("Module Name : " + Module)
                    #print("Full Name: " + FileName)
                    #print(" ")

                    extractTestCaseData(fileN, FileName, Module) # fileN = Full path and fileName :: FileName = file name :: Module is Folder Name

def main():
    getData()

if __name__ == '__main__':
    main()
