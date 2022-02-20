# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Fetch Product from Plaisio as a Proxy and Print Products' Name and Prices from Pages with Use Functions #
from urllib.request import Request, urlopen
from bs4 import BeautifulSoup

def get_prices_from_page(page):
    proxies = {
        "http": "http://test-proxy.com:9090"
    }
    url="https://www.plaisio.gr/tilefonia-tablet/tilefona/page-%d" % (page)
    req = Request(url, headers={"User-Agent": proxies["http"]})
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

for i in range (1,3):
    get_prices_from_page(i)