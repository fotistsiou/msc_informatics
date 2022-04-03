import networkx as nx
import matplotlib.pyplot as plt

G = nx.Graph() #Create an empty graph

V = [1 ,2 ,3 ,4 ,5 ,6] #V is the set of vertices of G
E = [[1 ,2] ,[1 ,4] ,[1 ,6],[2 ,4] ,[3,4]] #E is the set of edges of G

G.add_nodes_from(V)
G.add_edges_from(E)

DegreeSeq = []
for v in G.nodes:
    DegreeSeq.append(G.degree(v))
    print("Vertex",v,"has degree",G.degree(v))
DegreeSeq.sort(reverse=True)
print("Degree sequence of G:", DegreeSeq)