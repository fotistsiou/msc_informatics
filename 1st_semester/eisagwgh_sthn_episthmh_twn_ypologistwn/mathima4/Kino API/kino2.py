# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Data and Print Last and Previous Draw #
import urllib.request
import json

with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/last-result-and-active") as response: 
    data_in_json = response.read()
data_in_python = json.loads(data_in_json)
win_numbers = data_in_python["last"]["winningNumbers"]["list"]
last_drawId = data_in_python["last"]["drawId"]

# Add dynamic parameter in the endpoint
with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/"+str(last_drawId-1)) as response:
    data_in_json = response.read()
data_in_python = json.loads(data_in_json)
new_win_numbers = data_in_python["winningNumbers"]["list"]
print("Last Draw :",win_numbers,"\nPrevious Draw :",new_win_numbers)