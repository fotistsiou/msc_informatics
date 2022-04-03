import networkx as nx
import matplotlib.pyplot as plt
import random #random numbers

# Random Graph with use build-in function
def random_gnp_graph(n,p,name):
    R = nx.gnp_random_graph(n,p)
    nx.draw_circular(R, with_labels=True)
    plt.savefig (name+".eps")
    plt.show()
random_gnp_graph(10 ,0.8 ,"R1")
random_gnp_graph(10 ,0.5 ,"R2")
random_gnp_graph(10 ,0.2 ,"R3")
random_gnp_graph(10 ,0.1 ,"R4")

# Random Graph with use build-in function
def random_gnm_graph(n,m,name):
    R = nx.gnm_random_graph(n,m) #0 <= m <= n(n -1)/2
    nx.draw_circular(R, with_labels=True)
    plt.savefig (name+".eps")
    plt.show()
random_gnm_graph(10, 35, "R5")
random_gnm_graph(10, 25, "R6")
random_gnm_graph(10, 15, "R7")
random_gnm_graph(10, 5, "R8")

# Random Graph without use build-in function
def random_gnp_graph2(n,p,name):
    R = nx.Graph ()
    R.add_nodes_from(range(1,n+1))
    for i in range(1,n+1):
        for j in range(i+1,n+1):
            if random.uniform (0 ,1) <= p:
                R.add_edge(i,j)
    nx.draw_circular(R, with_labels=True)
    plt.savefig (name+".eps")
    plt.show()
random_gnp_graph2(10, 0.8, "R9")
random_gnp_graph2(10, 0.5, "R10")
random_gnp_graph2(10, 0.2, "R11")
random_gnp_graph2(10, 0.1, "R12")