import networkx as nx 
import matplotlib.pyplot as plt

G = nx.Graph() #Create an empty graph

V = [1,2,3,4,5,6,7,8] #V is the set of vertices of G
E = [[1,3], [1,4], [1,5], [2,3], [2,5], [2,8], [3,4], [3,8], [7,8]] #E is the set of edges of G
 
G.add_nodes_from(V)
G.add_edges_from(E)

print("G has order |V(G)|=",G.order(),"and size |E(G)|=",G.size())
print("V(G):",G.nodes()) #Print the nodes of G
print("E(G):",G.edges()) #Print the edges of G

for v in G:
    print("The neighbors of", v, "are:", list(G.neighbors(v)))

nx.draw_networkx(G) #Draw the graph G
plt.savefig("lect01a .eps") #Save the drawing of G
plt.show() #Show the drawing of G on screen