# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

import json
from urllib.request import Request, urlopen

rounds_randomness = []

# Fetch Last Randomness Number
req = Request("https://drand.cloudflare.com/public/latest", headers={"User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20130401 Firefox/31.0"}) 
data = urlopen(req).read()
rounds_data = json.loads(data)
rounds_randomness.append(rounds_data["randomness"])
last_round = rounds_data["round"]

# Fetch 99 Last Randomness Numbers before Last
for i in range(99):
    req = Request("https://drand.cloudflare.com/public/"+str(last_round-i-2), headers={"User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20130401 Firefox/31.0"})
    data = urlopen(req).read()
    rounds_data = json.loads(data)
    rounds_randomness.append(rounds_data["randomness"])

# Convert List to String and String to Binary 
hex_text = "".join(rounds_randomness)
# print(hex_text)
scale = 16
num_of_bits = 8
bin_text = bin(int(hex_text, scale))[2:].zfill(num_of_bits)
# print(bin_text)

# Calculation Zeros and Ones Max Consecutive 
max_zeros = 0
current_zeros = 0
max_ones = 0
current_ones = 0
for i in bin_text:
    if i == "0":
      current_zeros += 1
      if current_zeros > max_zeros:
        max_zeros = current_zeros
      current_ones = 0
    else:
      current_zeros = 0
      current_ones += 1
      if current_ones > max_ones:
        max_ones = current_ones

# Print Max Zeros and Ones Consecutive 
print("Max Zeros Consecutive:", max_zeros)
print("Max Ones Consecutive:", max_ones)