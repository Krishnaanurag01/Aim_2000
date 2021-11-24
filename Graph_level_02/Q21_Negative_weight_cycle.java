package Graph_level_02;
import java.util.* ;


// using bellman ford algo for negative cycle detection.

// time comp : O(VE) where v is number of vertex and E is number of edges.
// space comp : O(V)

public class Q21_Negative_weight_cycle {
    
    public int isNegativeWeightCycle(int v, int[][] graph)
    {
        //code here
         int[] path = new int[v] ; // this will store the max weight from source to current vertex(i)

        Arrays.fill(path, Integer.MAX_VALUE); // storing max by default
 
        path[0] = 0 ; // storing 0 for source.
        
        int e = graph.length ;  // number of edges.


        for (int i = 0; i < v - 1 ; i++) {   // runs for v - 1 edges.
            for (int j = 0; j < e ; j++) { // running for each edges.
                
                int u = graph[j][0] ;  
                int nbr = graph[j][1] ;
                int wt= graph[j][2] ; 

                if(path[u] == Integer.MAX_VALUE){ // if u doesn't have weight yet then skip
                    continue ;
                }

                if(path[u] + wt < path[nbr]){ // else check if u's weight + current weight ( between u and v) < path[nbr] then update it.
                    path[nbr] = path[u] + wt ;
                }
            }
        }

        // now again running loop, this will indentify if the graph has any negative cycle or not.
        
        for (int j = 0; j < e ; j++) { 
                
                int u = graph[j][0] ;  
                int nbr = graph[j][1] ;
                int wt= graph[j][2] ; 

                if(path[u] == Integer.MAX_VALUE){  
                    continue ;
                }

                if(path[u] + wt < path[nbr]){ // this denotes that the previous weight was not correct and new weight giving the lesser weight which means that graph has negative cycle.
                    return 1 ;
                }
        }
        
        return 0 ; // else returning 0.
        
    }
}
