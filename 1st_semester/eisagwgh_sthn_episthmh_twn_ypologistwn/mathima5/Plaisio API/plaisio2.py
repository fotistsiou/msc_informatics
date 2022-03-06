# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Product from Plaisio as Browser and Print Products' Prices from Specific Page #
from urllib.request import Request, urlopen
from bs4 import BeautifulSoup

url="https://www.plaisio.gr/tilefonia-tablet/tilefona/page-33"
# Because Cloudflare performs a rudimentary check on who is requesting data so that it isn't a bot, 
# you need to put a "User-Agent" in the "headers" so that the call appears to be from a browser.
req = Request(url, headers={"User-Agent": "Mozilla/5.0 (Windows NT 6.1; wow64; rv:31.0) Gecko/20130401 Firefox/31.0"}) 
html = urlopen(req).read()
soup = BeautifulSoup(html, "html.parser")
divs = soup.find_all("div", {"class": "price"})
for div in divs:
    print("Price:", div.text)