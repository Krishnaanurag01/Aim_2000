package Graph_level_02;
import java.util.*;

public class Q62_Possible_Bipartition {

    // Application of Bipartite Graph

    public boolean possibleBipartition(int n, int[][] dislikes) {

        // making graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        
        for(int i = 0 ; i <= n ; i++){
            adj.add( new ArrayList<>());
        }
        
        for(int[] e : dislikes){
            adj.get(e[0]).add(e[1]) ;
            adj.get(e[1]).add(e[0]) ;
        }
        
        int[] visited = new int[n+1] ;
        Arrays.fill(visited,-1) ;
        // end of initialization
        
        for(int i = 1; i <=n ; i++){
            if(visited[i] == -1){
                if(dfs(i,adj,visited) == false) return false;
            }
        }
        
        return true ;
    }
    
    boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
         LinkedList<int[]> q = new LinkedList<>() ;
        q.add(new int[]{src,1}) ;
        visited[src] = 1 ;
        
        while(q.size() > 0){
            int[] rp = q.removeFirst() ;
            
            for(int nbrs : adj.get(rp[0])){
                if(visited[nbrs] == -1){
                    q.add( new int[]{nbrs, rp[1] == 1 ? 0 : 1 }) ;
                    visited[nbrs] = rp[1] == 1 ? 0 : 1;
                }
                else{
                    if(visited[nbrs] != (rp[1] == 1 ? 0 : 1)) return false ;
                }
            }
        }
        
        return true ;
    }
}
