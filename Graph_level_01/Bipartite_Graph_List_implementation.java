package Graph_level_01;
import java.util.*;

public class Bipartite_Graph_List_implementation {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here

        int[] color = new int[V] ;
        Arrays.fill(color, -1); // storing by default -1 as color.

        for (int i = 0; i < V ; i++) {
            
            if(color[i] == -1){ // if the color is -1 then it means we didn't visit this vertex. so visiting it.

                if(!check_bfs(adj,color,i)){ // if the bfs gives false then return false directly.
                    return false ;
                }
            }
        }

        return true ;
    }

    private boolean check_bfs(ArrayList<ArrayList<Integer>> adj, int[] color, int i) {

        ArrayDeque<Integer> queue = new ArrayDeque<>() ;
        queue.add(i) ; // adding first vertex in queue.

        color[i] = 1 ; // making its color as 1.

        
        while (queue.size() > 0) { // iterating untill the queue is not empty.
            int rem = queue.removeFirst() ; // removing the first element.

            for (Integer in : adj.get(rem)) { // now checking for each neigbours.
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
    
}
