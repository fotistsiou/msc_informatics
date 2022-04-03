import networkx as nx
import matplotlib.pyplot as plt

def Graph_Check(Seq):
    if nx.is_graphical(Seq):
        print("The sequence",Seq,"is graphical")
        G = nx.havel_hakimi_graph(Seq)
        nx.draw_circular(G,with_labels=True)
        plt.show()
    else:
        print("The sequence",Seq,"is not graphical")
    print("")
    
Seq1 = [7,7,5,5,3,3,2,2,1,1]
Seq2 = [7,7,7,3,3,2,1,1,1]
Graph_Check(Seq1)
Graph_Check(Seq2)