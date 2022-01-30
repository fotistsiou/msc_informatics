h = input("Give me a height: \n") # input from user
h = int(h) # casting 
c = input("Give me a symbol: \n")

for i in range(h):
    print((h-i) * " " + (2*i+1) * c)