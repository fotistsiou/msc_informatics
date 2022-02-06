# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #
from time import time



# --- 1st way --- #
def fibo1(n):
    if n == 1 or n == 2:
        return 1
    else:
        return fibo1(n-1) + fibo1(n-2)
# Print fibo1(1,2,3,4,5)
for i in range(1,6):
    print("Fibo1 of ", i, " = ", fibo1(i))


# --- 2nd way --- #
# List of cached values
fibo_cache = {} 
def fibo2(n):
    # If we have cached the value, return it
    if n in fibo_cache:
        return fibo_cache[n]
    # Compute the Nth term 
    if n == 1 or n == 2: 
        value = 1
    else:
        value = fibo2(n-1) + fibo2(n-2)
    # If we haven't cached the value, cache the value and return it
    fibo_cache[n] = value
    return value
# Print fibo2(1,2,3,4,5)
for i in range(1,6):
    print("Fibo2 of ", i, " = ", fibo2(i))


# --- 3rd way --- #
def fibo3(n):
    if n == 1 or n == 2:
        return 1
    a = 1
    b = 2
    for i in range(n-3):
        # temp = a + b
        # a = b
        # b = temp
        a, b = b, a + b # Python Way
    return b
# Print fibo3(1,2,3,4,5)
for i in range(1,6):
    print("Fibo3 of ", i, " = ", fibo3(i))


# Comparison between 3 ways in terms of time
for i in range(1,30):
    # 1st way
    ts = time()
    fibo1(i)
    t1 = time() - ts
    # 2nd way
    ts = time()
    fibo2(i)
    t2 = time() - ts
    # 3rd way
    ts = time()
    fibo3(i)
    t3 = time() - ts
# comparison
comparison = [t1, t2, t3]
if (t1 == min(comparison)):
    print("Fibo1 is the fastest function")
elif (t2 == min(comparison)):
    print("Fibo2 is the fastest function")
else:
    print("Fibo3 is the fastest function")
print("t1 =", t1, "| t2 =", t2, "| t3 =", t3) 