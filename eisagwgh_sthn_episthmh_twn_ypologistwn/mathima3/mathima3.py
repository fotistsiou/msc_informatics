# If statement
a = 10
if a > 4 :
    print("Bigger")
elif a < 4 :
    print("Smaller")
else:
    print("Equal")

# Built in function "split()" 
b = "christmas.py 10 p"
print(b.split(" "))
print(b)

# Functions
def add(x1, x2):
    return x1 + x2
print("Call add() function:", add(10, 5))

# random and shuffle 
import random
a = [1, 2, 3, 4, 5]
random.shuffle(a)
print(a)