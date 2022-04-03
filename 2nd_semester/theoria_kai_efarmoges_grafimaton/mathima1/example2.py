import networkx as nx
import matplotlib.pyplot as plt

n = 7 #number of vertices

# Complete graph with use build-in function
Kn = nx.complete_graph(n)
nx.draw_circular(Kn, with_labels=True)
plt.show()

# Complete graph without use build-in function
Kn = nx.Graph()
Kn.add_nodes_from(range(1,n+1))
for i in range(1,n+1):
    for j in range(i+1,n+1):
        Kn.add_edge(i,j)
nx. draw_circular(Kn ,with_labels=True)
plt.show()