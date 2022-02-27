package Graph_level_02;
import java.util.*;

public class Q27_M_Coloring_Problem {
    
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
        int n = G.length ;
        if( dfs(0,G,color,n,m) ) return true ;
        
        return false;
    }
    
    static boolean dfs(int src , List<Integer>[] G,int[] color, int n, int m){
        
        if(src == n) return true ; // when reach all the nodes return true
        
        for(int i = 1 ; i <= m ; i++){ // checking for each colour
            
            if( isAllowed(src,G,color,i) ){  // if current ith colour is allowed then do following
                // when allowed
                color[src] = i ; // storing current colour so that it can help its neighbours
                
                if( dfs(src+1, G,color,n,m) ) return true ; // now solving ahead
                
                color[src] = 0 ; // unvisiting
                
            }
        }
        
        return false;
    }
    
    
    // cc = current colour
    static boolean isAllowed(int src, List<Integer>[] g , int[] color , int cc){
        
        for(int nbr : g[src] ){  
            if(color[nbr] == cc) return false ; // if neighbour of src having same colour then return false as adjecent nbrs can't have same colour
        }
        
        return true ;
    }

}
