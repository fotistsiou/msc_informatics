# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Bitcoin Prices in Euros, 10 Times and Print a Graph of These Prices #
from matplotlib import pyplot as plt
import urllib.request
import json
from time import sleep

btc_prices=[]
url="https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=EUR&e=CCCAGG"
for i in range(10):
    with urllib.request.urlopen(url) as response:
        html = response.read()
    data = json.loads(html)
    btc_prices.append(data['BTC']['EUR'])
    sleep(1)

fig = plt.figure(figsize=(10, 7))
plt.bar(list(range(10)),btc_prices)
plt.show()