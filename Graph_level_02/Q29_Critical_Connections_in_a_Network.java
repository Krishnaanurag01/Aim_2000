package Graph_level_02;
import java.util.*;


// same as articulation point.

public class Q29_Critical_Connections_in_a_Network {

    
    static int[] parent ;
    static int[] disc ;
    static int[] low ;
    static int time ;
    static boolean[] visited ;
    
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> adj)
    {
        // Code here
        
        List<List<Integer>> graph = new ArrayList<>() ;
        
        for(int i = 0 ; i < V ; i++){
            graph.add( new ArrayList<Integer>()) ;
        }
        
        for(int i = 0 ; i < adj.size() ; i++){
            int u = adj.get(i).get(0) ;
            int v= adj.get(i).get(1) ;
            
            graph.get(u).add(v) ;
            graph.get(v).add(u) ;
        }
        
        List<List<Integer>> ans = new ArrayList<>() ;
        
        parent = new int[V] ;
        disc  = new int[V] ; 
        low = new int[V] ;
        time = 0 ;
        visited = new boolean[V] ;
        
        
        dfs(0,graph,ans) ;
        
       
     return ans ;   
    }
    
    public void dfs(int u , List<List<Integer>> adj , List<List<Integer>> ans ){
        disc[u] = low[u] = time ;
        time++ ;
        
        visited[u] = true ;
        
        for(int v : adj.get(u)) {
            
            if(parent[u] == v){
                continue ;
            }
            else if(visited[v] == true){
             low[u] = Math.min(low[u] , disc[v]) ;   
            }
            else{
                parent[v] = u ;
                dfs(v,adj,ans) ;
                
                low[u] = Math.min(low[u],low[v]) ; 
                                    // System.out.println(" u -> " + u + " v -- " + v) ;

                if(low[v] > disc[u] ){ // only differnce is this , here we check for strictly greater value
                    List<Integer> in = new ArrayList<>( ) ;
                    in.add(u);
                    in.add(v) ;
                
                 
                        ans.add(in) ;
                        
                }
                
            }
        }
    }
    
}
