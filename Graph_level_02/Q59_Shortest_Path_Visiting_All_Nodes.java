package Graph_level_02;
import java.util.*;

public class Q59_Shortest_Path_Visiting_All_Nodes {

    public int shortestPathLength(int[][] graph) {
        
        if(graph.length == 1) return 0 ; // when only one node present
        int finalState = (1 << graph.length) - 1 ; // this is final state denotes all nodes are visited becuase all position is 1.
        LinkedList<int[]> q = new LinkedList<>() ;
        
        for(int i = 0 ; i < graph.length ; i++){
            q.add( new int[]{i, 1 << i}) ; // adding all the nodes with bit left shifted(i times).
        }
        
        boolean[][] visited = new boolean[graph.length][finalState + 1] ;
        
        int shortestPath = 0 ;
        
        while(q.size() > 0){
            shortestPath++ ;
            int size = q.size() ;
            while(size-- > 0){
                int[] rp = q.poll() ;
                int src = rp[0] ;
                int visitedMask = rp[1] ; /// removed node visited mask
                
                for(int nbr : graph[src]){
                    
                    int newMask =  visitedMask | (1 << nbr) ; // this is new mask of neighbour
                    if(visited[nbr][newMask]) continue ; // if already visited then continue
                    
                    visited[nbr][newMask] = true ;
                    if(newMask == finalState) return shortestPath ;
                    
                    q.add(new int[]{nbr,newMask}) ;
                }
            }
        }
         
        
        
        return -1;
    }
}
