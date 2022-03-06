# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Sorting Algorithms #

# Merge Sort {n*logn steps} #
import random
from time import time

# mysort() function  
def mysort(L):
    if len(L) == 1:
        return L
    elif len(L) == 2: 
        if L[0] > L[1]:
            return [L[1],L[0]]
        else:
            return L
    
    left = L[:len(L)//2] # takes the left half of the list and makes an new left list.
    left = mysort(left) # call the mysort for the new left list (recursive).
    right = L[len(L)//2:] # takes the right half of the list and makes an new right list.
    right = mysort(right) # call the mysort for the new right list (recursive).
    
    # When new lists are sorted, they go below and link in the "res" list.
    # Items of "right" and "left" list are compared one by one
    res=[]
    while len(right) > 0 and len(left) > 0:
        if right[0] > left[0]:
            res.append(left[0]) # add item in the "res" list
            left=left[1:] # remove item from left list
        else:
            res.append(right[0]) # add item in the "res" list
            right=right[1:] # remove item from right list
    # "right" and "left" lists are connected in "res" list and return "res" list
    res += right
    res += left
    return res

# Make an initial list and call mysort() in order to sort it 
items = 100
lst = [random.randrange(15,45) for i in range(items)]
random.shuffle(lst)
ts = time()
print(mysort(lst))
print(time()-ts)