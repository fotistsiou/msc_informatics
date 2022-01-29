# Guidelines # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Python Christmas Tree #

# Hardcoded Christmas Tree
for i in range(10):
#    print(2*i+1) # fisrt step
#    print((2*i+1)*"*") # second step 
   print((9-i)*" "+(2*i+1)*"*") # last step

# Christmas Tree using variables
h = 20
c = "&"
for i in range(h):
   print((h-i)*" "+(2*i+1)*c)