# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Product from Plaisio and Print Products' Prices from Specific Page #
import urllib.request
from bs4 import BeautifulSoup

url="https://www.plaisio.gr/tilefonia-tablet/tilefona/page-33"
with urllib.request.urlopen(url) as response:
    html = response.read()
soup = BeautifulSoup(html, 'html.parser') # Beautify HTML code
divs = soup.find_all("div", {"class": "price"})
for div in divs:
    print('Price:', div.text)