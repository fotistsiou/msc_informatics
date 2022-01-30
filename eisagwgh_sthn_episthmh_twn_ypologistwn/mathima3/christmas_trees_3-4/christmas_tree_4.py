import sys 

if len(sys.argv) < 3 : 
    sys.exit(3)         # define error if arguments are less than 3

h=sys.argv[1] # take as input the 2nd argument of the command
h=int(h)
c=sys.argv[2] # take as input the 3rd argument of the command

for i in range(h):
    print((h-i)*" "+(2*i+1)*c)

print("The name of the file is: ", sys.argv[0]) # print the 1st argument of the command