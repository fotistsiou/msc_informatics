# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Product from Plaisio as Browser and Print Products' Name and Prices from Specific Page #
from urllib.request import Request, urlopen
from bs4 import BeautifulSoup

url="https://www.plaisio.gr/tilefonia-tablet/tilefona/page-33"
req = Request(url, headers={"User-Agent": "Mozilla/5.0 (Windows NT 6.1; wow64; rv:31.0) Gecko/20130401 Firefox/31.0"})
html = urlopen(req).read()
soup = BeautifulSoup(html, "html.parser")
divs = soup.find_all("div", {"class": "product"})
for div in divs:
    titles = div.find_all("span", {"class": "product-title"})
    for title in titles:
        print("Product Title:", title.text)
    prices = div.find_all("div", {"class": "price"})
    for price in prices:
        if "σε" not in price.text:
            print("Product Price:", price.text)
        else:
            continue 
    print("---------------------------------------")