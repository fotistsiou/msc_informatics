# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Data and Print Numbers of Last 10 Draws #
import urllib.request
import json

with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/last-result-and-active") as response: 
    data_in_json = response.read()
data_in_python = json.loads(data_in_json)
win_numbers = data_in_python["last"]["winningNumbers"]["list"]
last_drawId = data_in_python["last"]["drawId"]

# Loop for last 9 draws and add them to last draw from above
for i in range(9):
    with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/"+str(last_drawId-i-1)) as response:
        data_in_json = response.read()
    data_in_python = json.loads(data_in_json)
    win_numbers += data_in_python["winningNumbers"]["list"]
print("Numbers of 10 Last Draws :",win_numbers)