import sys
h=sys.argv[1]
h=int(h)
c=sys.argv[2]
for i in range(h):
    print((h-i)*" "+(2*i+1)*c)