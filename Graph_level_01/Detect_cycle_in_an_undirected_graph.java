package Graph_level_01;
import java.util.*;


public class Detect_cycle_in_an_undirected_graph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[V] ; // keep track if vertex is visited before or not.

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == false) {
                Boolean is_cyclic = check_cycle(i,visited,adj) ; // if it gives true then stop and return true.
                if(is_cyclic){
                    return true ;
                }
            }
        }
        return false ;
    }

    private Boolean check_cycle(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        ArrayDeque<Integer> q = new ArrayDeque<>() ;
        q.add(i) ;
        
        while (q.size() > 0) {
            int rem = q.removeFirst() ;

            if(visited[rem] == true ){/// if the vertex is visited before then return true as it was visited before.
                return true ;
            }

            visited[rem] = true ;

            for (Integer in : adj.get(rem)) {
                if(visited[in] == false){
                    q.add(in) ;
                }
            }
        }
        return false;
    }   
}
