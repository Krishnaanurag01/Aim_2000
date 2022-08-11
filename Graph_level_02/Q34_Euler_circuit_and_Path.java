package Graph_level_02;
import java.util.*;

public class Q34_Euler_circuit_and_Path {

    // (eulerian is same as hamiltonian only difference is eulerian is used for edges and hamiltonian is for vertices.)
    // eulerian path : is a path starting from any node through which we can traverse or visit each edge


    // for undirected graph : sare node ek degree must be even for cituit and for path n-2 node degree should must be even rest is odd
    // for directed graph : we check both indegree and outdegree
    // for citcuit : even node should have same indegree and outdegree
    // for path : n-2 node have same in and out and rest can have odd 
    // *************  where -> the node which has less indegree and more outdegree is source and the node where outdegree is more and indegree is less in destination

    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {

        int odd = 0 ; // counting odd number of degree for each node
        
        for(int i = 0 ; i < V ; i++){
            if(adj.get(i).size() % 2 != 0 ) // if degree is odd then it means it is not circuit
            {
                odd++ ;
            }
            
        }
        
        if(odd == 0 ){ // when no node has odd degree tthen it is circuit
            return 2 ;
        }
        else if(odd == 2){ // when only two node has odd degree then it is path
            return 1 ;
        }
         // else it is none.
        return 0 ;

    }
    
}
