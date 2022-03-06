# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Data and Print How Many Times Each Number is displayed in the Last 10 Draws #
import urllib.request
import json

with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/last-result-and-active") as response: 
    data_in_json = response.read()
data_in_python = json.loads(data_in_json)
win_numbers = data_in_python["last"]["winningNumbers"]["list"]
last_drawId = data_in_python["last"]["drawId"]

for i in range(9):
    with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/"+str(last_drawId-i-1)) as response:
        data_in_json = response.read()
    data_in_python = json.loads(data_in_json)
    win_numbers += data_in_python["winningNumbers"]["list"]

# Print how many times each number is displayed in the last 10 draws
for i in range(1,81):
    print("Number ",i," display ", win_numbers.count(i), "times in the Last 10 Draws")