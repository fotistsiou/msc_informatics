# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

import sys

# Import ASCII Text
if len(sys.argv) > 1:
  filename = sys.argv[1]
else:
  filename = "./ascii.txt"
text = open(filename, "r").read()

# Convert and Format from Imported ASCII Text to Binary
def toBinary(txt):
  m = ""
  for i in txt:
    m += (format(ord(i),"07b"))
  return m
binary_text = toBinary(text)

# Calculation Zeros and Ones Max Consecutive 
max_zeros = 0
current_zeros = 0
max_ones = 0
current_ones = 0
for i in binary_text:
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