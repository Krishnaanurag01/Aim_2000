package Graph_level_02;
import java.util.*;

public class Q33_Euler_Circuit_in_an_Undirected_Graph {

    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here

        // for eulerian circuit every node should have even degree ( even number of edges) 
        
        for(int i = 0 ; i < V; i++){
            if(adj.get(i).size() % 2 != 0)  // if degree is not even then return false directly
            return false ;
        }
        
        return true ;
    }
    
}
