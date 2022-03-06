# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Sorting Algorithms #

# Bubble Sort {n*(n-1)/2 steps} #
import random
from time import time

items = 8
lst1 = [random.randrange(1, 8) for i in range(items)]
random.shuffle(lst1)
ts = time()
cnt = 0
# Traverse through all array elements
for i in range(len(lst1)-1): # range(n) also work but outer loop will repeat one time more than needed
    for j in range(len(lst1)-1-i): # last i elements are already in place
        cnt += 1
        if lst1[j] > lst1[j+1]:
            lst1[j], lst1[j+1] = lst1[j+1], lst1[j]
        # print(lst1)
print("Count of iterations :", cnt)
print("Sorted List :", lst1)
print("Time for shorting 1:", time()-ts)


# Bubble Sort in a list of strings
lst2 = ["Fotis","Aspa","Paris","Aris","Dimitris","Rafailia","Kostas","Eygenia"]
ts = time()
cnt2 = 0
for j in range(len(lst2)-1):
    for i in range(len(lst2)-1-j):
        cnt2 += 1
        if lst2[i] > lst2[i+1]:
            lst2[i], lst2[i+1] = lst2[i+1], lst2[i]
print("Count of iterations :", cnt2)
print("Sorted List :", lst2)
print("Time for shorting 2:", time()-ts)