package Graph_level_02;

import java.util.* ;


/**
 * Q20_Distance_from_the_Source_Bellman_Ford_Algorithm
 */
public class Q20_Distance_from_the_Source_Bellman_Ford_Algorithm {

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here

        int[] path = new int[V] ;
        Arrays.fill(path, Integer.MAX_VALUE);

        path[S] = 0 ; // making source weight from source index 0.


        // bellman ford algo. check Q19 for reference.
        for (int i = 0; i < V - 1 ; i++) {
            for (int j = 0; j < adj.size() ; j++) {
                
                int u = adj.get(j).get(0);
                int v = adj.get(j).get(1) ;
                int wt = adj.get(j).get(2) ;

                if(path[u] == Integer.MAX_VALUE){
                    continue ;
                }

                if(path[u] + wt < path[v]){
                    path[v] = path[u] + wt ;
                }
            }
            
        }
        
        for (int i = 0; i < path.length; i++) {
            
            if(path[i] == Integer.MAX_VALUE){
                path[i] = 100000000 ; 
            }
        }

        return path ;
        
    }

}