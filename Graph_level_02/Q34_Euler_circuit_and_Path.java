package Graph_level_02;
import java.util.*;

public class Q34_Euler_circuit_and_Path {

    // (eulerian is same as hamiltonian only difference is eulerian is used for edges and hamiltonian is for vertices.)
    // eulerian path : is a path starting from any node through which we can traverse or visit each edge

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
