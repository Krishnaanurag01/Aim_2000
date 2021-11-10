package Graph_level_01;
import java.util.*;

public class Shortest_Path_in_Directed_Acyclic_Graph {

    static void find_topo(int src , boolean[] visited , Stack<Integer> stack , ArrayList<ArrayList<Integer>> adj){
        
        visited[src] = true ;
        
        for(Integer in : adj.get(src)){
            if(!visited[in]){
                find_topo(in,visited , stack , adj) ;
            }
        }
        
        stack.push(src) ;
    }



    public static void print_shorted_path_from_source(ArrayList<ArrayList<Integer>> adj , int V , int source) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == false){
                find_topo(i,visited , stack , adj) ;
            }
        }


        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0 ;

        Queue<>

    }
    
}
