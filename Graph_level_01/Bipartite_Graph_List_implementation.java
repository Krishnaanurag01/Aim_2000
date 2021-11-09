package Graph_level_01;
import java.util.*;

public class Bipartite_Graph_List_implementation {

    public boolean isBipartite( int[][]adj)
    {
        // Code here

        int[] color = new int[adj.length] ;
        Arrays.fill(color, -1); // storing by default -1 as color.

        for (int i = 0; i < adj.length ; i++) {
            
            if(color[i] == -1){ // if the color is -1 then it means we didn't visit this vertex. so visiting it.

                if(!check_bfs(adj,color,i)){ // if the bfs gives false then return false directly.
                    return false ;
                }
            }
        }

        return true ;
    }

    private boolean check_bfs(int[][] adj, int[] color, int i) {

        ArrayDeque<Integer> queue = new ArrayDeque<>() ;
        queue.add(i) ; // adding first vertex in queue.

        color[i] = 1 ; // making its color as 1.

        
        while (queue.size() > 0) { // iterating untill the queue is not empty.
            int rem = queue.removeFirst() ; // removing the first element.

            for (Integer in : adj[rem]) { // now checking for each neigbours.
                if(color[in] == -1){ // if the neigbours are not visited then add them to the queue and store color i - color[rem] (means storing reverse color than parent color)
                    queue.add(in) ;
                    color[in] = 1 - color[rem] ;
                }
                else if(color[in] == color[rem]){ // else if neigbours are already visited and their colours are similar with the adjencent node then return false.
                    return false ;
                }
            }
        }
        return true;
    }



    public static boolean check_dfs(ArrayList<ArrayList<Integer>> adj , int node , int[] color) {
        
        if(color[node] == -1) color[node] = 1 ; // if not coloured before then add colour.

        for (int i : adj.get(node)) { // visiting adjecent elements.
            if(color[i] == -1 ){ // if not visited then 
                color[i] = 1 - color[node] ; // store the reverse colour 
                if(!check_dfs(adj, i , color)) return false ; // and run function for neigbours.
            }
            else if(color[i] == color[node]){ // if already coloured then check if the colour of current element and neigbour element is same then return false.
                return false ;
            }
        }
        return true ;
    }
    
}
