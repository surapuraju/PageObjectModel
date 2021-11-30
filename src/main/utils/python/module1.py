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

import json

# some JSON:
x =  '{ "name":"John", "age":30, "city":"New York"}'

# parse x:
y = json.loads(x)

# the result is a Python dictionary:
print(y["city"])


