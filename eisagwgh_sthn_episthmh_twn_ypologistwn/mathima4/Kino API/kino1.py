# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Data and Print Useful Information #
import urllib.request
import json

# Fetch Kino data from OPAP endpoint and assignment to "data_in_json" variable
with urllib.request.urlopen('https://api.opap.gr/draws/v3.0/1100/last-result-and-active') as response: 
    data_in_json = response.read()
# Convert from JSON to Python
data_in_python = json.loads(data_in_json)
# Pull list of winning numbers and assignment to "win_numbers" variable
win_numbers = data_in_python["last"]["winningNumbers"]["list"]
# Print list of winning numbers
print(win_numbers)