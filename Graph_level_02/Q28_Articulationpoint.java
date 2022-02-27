package Graph_level_02;
import java.util.*;


// same as articulation point 1, only diffrence is we are calling dfs for each unvisited vertex(becuase graph may be unconnected)

public class Q28_Articulationpoint {

    static int[] parent ;
    static int[] disc ; 
    static int[] low ;
    static int time ;
    static boolean[] visited ;
    static boolean[] ap ;
   
    
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
        parent = new int[V] ;
        Arrays.fill(parent , -1) ;
        
        disc = new int[V] ;
        
        low = new int[V] ;
        
        time = 0 ;
        
        visited = new boolean[V] ;
        
        ap = new boolean[V] ;
        
     
        
        
        
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == false ){
                dfs(i,adj) ;
            }
        }
        
        
        
       int size = 0 ;
        
        for(int i = 0 ; i < V ; i++){
            if(ap[i] == true){
               size++ ;
            }
        }
        
        int[] nans = new int[size] ;
        int k = 0 ;
        for(int i = 0 ; i < V ; i++){
            if(ap[i] == true){
                nans[k++] = i ;
            }
        }
        
        if(nans.length == 0 ){
            return new int[]{-1} ;
        }
        
        
        
        
        return nans ;
        
    }
    
    static void dfs(int src , ArrayList<ArrayList<Integer>> adj ){
        disc[src] = time ;
        low[src] = time ;
        int count = 0 ;
        
        
        time++ ;
        
        visited[src] = true ;
        
        for(int nbr : adj.get(src)){
            
            if(parent[src] == nbr ){
                continue ;
            }
            else if(visited[nbr] == true ){
                low[src] = Math.min(low[src], disc[nbr] ) ;
            }
            else{
                parent[nbr] = src ;
                count++ ;
                
                dfs(nbr,adj) ;
                
                low[src] = Math.min(low[src] , low[nbr]) ;
                
                if(parent[src] == -1){
                    if(count >= 2){
                        ap[src] = true ;
                    }
                }
                else{
                    if(disc[src] <= low[nbr] ){
                        ap[src] = true ;
                    }
                }
            }
        }
        
       
    }
    
}
