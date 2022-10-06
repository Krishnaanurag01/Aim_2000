package Graph_level_01;
import java.util.*;

public class Detect_cycle_in_a_directed_graph {
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        boolean[] visited = new boolean[V];
        boolean[] Dfs_visited = new boolean[V];

        for (int i = 0; i < V ; i++) {
            if( visited[i] == false ){
                if( check_cycle(adj,visited,Dfs_visited,i)){
                    return true ;
                }
            }
        }

        return false ;
    }

    private boolean check_cycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfs_visited, int i) {

        visited[i] = true ;
        dfs_visited[i] = true ;

        for (Integer in : adj.get(i)) {
            if(visited[in] == false){
                if(check_cycle(adj, visited, dfs_visited, in)) return true ;
            }
            else if(dfs_visited[i] == true){
                return true ;
            }
        }

        dfs_visited[i] = false ;
        return false;
    }
}
