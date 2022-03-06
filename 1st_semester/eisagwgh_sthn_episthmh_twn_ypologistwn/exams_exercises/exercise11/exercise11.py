# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

import json
from urllib.request import Request, urlopen
from math import log

rounds_randomness = []

# Fetch Last Randomness Number
req = Request("https://drand.cloudflare.com/public/latest", headers={"User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20130401 Firefox/31.0"}) 
data = urlopen(req).read()
rounds_data = json.loads(data)
rounds_randomness.append(rounds_data["randomness"])
last_round = rounds_data["round"]

# Fetch 19 Last Randomness Numbers before Last
for i in range(19):
    req = Request("https://drand.cloudflare.com/public/"+str(last_round-i-1), headers={"User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20130401 Firefox/31.0"})
    data = urlopen(req).read()
    rounds_data = json.loads(data)
    rounds_randomness.append(rounds_data["randomness"])

# Convert List to String and Display
text = "".join(rounds_randomness)
print("Text:", text)

# Finding Characters and Calculation Probability Occurrence of Characters
text_len = len(text)
dict = {}
for char in text:
    if char in dict:
        dict[char] += 1
    else:
        dict[char] = 1
for char in dict:
    prob = dict[char]/text_len
    dict[char] = prob*log(prob)
values = dict.values()

# Calculate Shannon Entropy and Display 
entropy = -1*sum(values)
print("Shannon Entropy:", entropy)