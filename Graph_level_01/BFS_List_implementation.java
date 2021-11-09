package Graph_level_01;
import java.util.*;


public class BFS_List_implementation {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>() ;
        boolean[] visited = new boolean[V+1];

        ArrayDeque<Integer> queue = new ArrayDeque<>() ;
        queue.add(0);
        visited[0] = true ;


        while (queue.size() > 0) {
            int rem = queue.removeFirst() ;
            ans.add(rem) ;

            for (Integer i : adj.get(rem)) {
                if(!visited[i]){
                    visited[i] = true ;
                    queue.add(i) ;
                }
            }
            
        }
        return ans ;
    }
    
}
