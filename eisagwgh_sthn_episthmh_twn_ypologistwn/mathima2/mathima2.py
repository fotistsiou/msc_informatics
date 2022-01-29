# Guidelines #

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Python Arithmetic Operators #

print(11+5) # Addition 
print(11-5) # Subtraction
print(11*5) # Multiplication
print(11**5) # Exponentiation
print(11/5) # Division
print(11//5) # Floor division (Πηλίκο)
print(11%5) # Modulus (Υπόλοιπο)

# Python Lists #

a = [1, 2, 3, 4] # create list
print(a[0]) # print first item
a = a + [5] # add an item to the end of the list
a.append(6) # add an item to the end of the list 
print(a) # print the whole list
print(max(a)) # print max item
print(min(a)) # print min item
print(len(a)) # print lenght a
b = ["cherry", "apple", "banana"]
b.sort() # sort list
print(b) 
b.sort(reverse=True) # sort list descending
print(b) 
a.append("test")
print(a)
print(len(a)) # valid 
a.sort() # invalid ('<' not supported between instances of 'str' and 'int')
print(a) 

# Python Iterating with "for" #

# Python uses indentation to indicate a block of code.
for i in range(10): # iteration of list
   print(i)
print("---") # with not indentation (print("---") execute after for loop)

print("\n") # print new line for code separation

for i in range(10):
   print(i)
   print("---") # with indentation (print("---") execute in each loop)