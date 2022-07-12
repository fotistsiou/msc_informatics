class node:
	def __init__(self):
		self.data = 0
		self.left = self.right = None

def newNode(data):
	node().data = data
	node().left = node().right = None
	return node()

root = newNode(1)
root.left = newNode(2)
root.left.left = newNode(3)
root.left.right = newNode(4)
root.left.right.left = newNode(5)
root.left.right.right = newNode(6)
root.right = newNode(7)
root.right.right = newNode(8)
root.right.left = newNode(9)
root.right.left.right = newNode(10)
root.right.left.left  = newNode(11)

def max(x, y):
	if(x > y):
		return x
	else:
		return y


def LISS(root):
	if (root == None) :
		return 0
	size_excl = LISS(root.left) + LISS(root.right)
	size_incl = 1
	if (root.left != None):
		size_incl += LISS(root.left.left) + LISS(root.left.right)
	if (root.right != None):
		size_incl += LISS(root.right.left) + LISS(root.right.right)
	return max(size_incl, size_excl)

print("Size of the Largest Independent Set is ", LISS(root))