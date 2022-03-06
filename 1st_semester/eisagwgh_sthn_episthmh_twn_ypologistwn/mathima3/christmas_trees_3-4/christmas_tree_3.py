# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #
h = input("Give me a height: \n") # input from user
h = int(h) # casting 
c = input("Give me a symbol: \n")

for i in range(h):
    print((h-i) * " " + (2*i+1) * c)