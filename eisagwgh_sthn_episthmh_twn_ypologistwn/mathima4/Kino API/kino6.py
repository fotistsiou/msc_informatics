# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Data With Use Different CoreS of My PC #
import urllib.request
import json
from matplotlib import pyplot as plt
from p_tqdm import p_map
from time import time 

with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/last-result-and-active") as response: 
    data_in_json = response.read()
data_in_python = json.loads(data_in_json)
win_numbers1 = data_in_python["last"]["winningNumbers"]["list"]
win_numbers2 = data_in_python["last"]["winningNumbers"]["list"]
last_drawId = data_in_python["last"]["drawId"]

def get_draw(id):
    with urllib.request.urlopen("https://api.opap.gr/draws/v3.0/1100/"+str(id)) as response:
        data_in_json = response.read()
    data_in_python = json.loads(data_in_json)
    return data_in_python["winningNumbers"]["list"]

# First way and more slow (linear)
ts1 = time()
for i in range(9):
    win_numbers1 += get_draw(last_drawId-i-1)
print("First way needs:", time()-ts1, "sec")

# Second way and more fast (with threads)
ts2 = time()
my_draws = list(range(last_drawId-9,last_drawId)) # list of last 10 draws
draws = p_map(get_draw, [id for id in my_draws]) # use "p_map" built in function for distribute of processes in threads 
for draw in draws:
    win_numbers2 += draw
print("Second way needs:", time()-ts2, "sec")