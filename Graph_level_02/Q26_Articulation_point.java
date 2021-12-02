package Graph_level_02;
import java.util.*;

public class Q26_Articulation_point {
    static int[] parent ;
    static int[] intTime ; // insertion time.
    static int[] low ;  // minimal time.
    static boolean[] visited ;
    static int time ;
    static boolean[] ap ; // articulation point
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        parent = new int[V] ;
        intTime = new int[V] ;
        low = new int[V] ;
        visited = new boolean[V] ;
        ap = new boolean[V] ;
        time = 0 ;
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        
        parent[0] = -1 ; // storing 0th parent -1.
        dfs(0,adj) ;
        
        for(int i = 0 ; i < V ; i++){
            if(ap[i] == true){ // adding all ap to answer.
                ans.add(i) ;
            }
        }
        
        if(ans.size() > 0 ){
            return ans ;
        }
        ans.add(-1);
        return ans ;
    }
    
    
    public void dfs(int u ,ArrayList<ArrayList<Integer>> adj ){
        
        intTime[u] = low[u] = time ; // storing both same by default
        time++ ; // increasing time
        int count = 0 ;
        
        visited[u] = true ;
        
        ArrayList<Integer> inner = adj.get(u) ;
        
        for(int i = 0 ; i < inner.size() ; i++){
            
            int v = inner.get(i) ;
            
            if(parent[u] == v){ 
                continue ;
            }
            else if(visited[v] == true){
                low[u] = Math.min(low[u] , intTime[v]);
            }
            else{
                
                parent[v] = u ;
                count++ ;
                
                dfs(v,adj) ;
                
                low[u] = Math.min(low[u],low[v]) ;
                
                if(parent[u] == -1){
                    if(count>=2){
                        ap[u] = true ;
                    }
                }else{
                    
                    if(low[v] >= intTime[u]){
                        ap[u] = true ;
                    }
                }
            }
            
        }
        
    }
}
