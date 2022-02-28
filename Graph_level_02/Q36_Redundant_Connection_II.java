package Graph_level_02;
import java.util.*;

public class Q36_Redundant_Connection_II {

    static int[] parent ;
    static int[] rank ;
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] indeg = new int[edges.length+1] ;
        
        Arrays.fill(indeg , -1) ;
        
        int bl1 = -1 ;
        int bl2 = -1 ;
        
        for(int i = 0 ; i < edges.length ; i++){
            // int u = edges[i][0] ;
            int v = edges[i][1] ;
            
            if(indeg[v] == -1){ // when first time any edge comes on v vertex
                indeg[v] = i ;
            }
            else{ /// means some other edge already has V neighbour.
                // this V node has two parents that's why it has two incoming edge so blacklisting old and current edge.
                bl1 = i ; // current row is stored for black list 1 
                bl2 = indeg[v] ; // blacklist 2 
                break ;
            }
        }
        
        
        
        // DSU Algo : 

        int V = edges.length + 1 ;
        
        parent = new int[V] ; 
        rank = new int[V] ;
        
        for(int i = 0 ; i < V ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        
        for(int i = 0 ; i < edges.length ; i++){
            
            if(i == bl1){
                 // skipping the blacklist1 and checking if In presence of black list 2 graph contains cycles or not.
                continue ; 
            }
            
            int x = edges[i][0] ;
            int y = edges[i][1] ;
            
            boolean merged = union(x,y);
            
            if(merged == false){ // it did not get merged when current edge is already added in graph so it means current edge forming cycle
                
                if( bl1 == -1){ // if no blacklist is present               // case 2
                    
                    return edges[i] ; // then current edge is answer
                }
                else{ // else as we skipped bl1 and checked cycle in presence of bl2 and cycle is formed so bl2'th edge is forming cycle
                    return edges[bl2] ;     // case 3
                    
                }
            }
        }
        
        // if cycle did not found then it means black list 1 is our answer becuase without it's presence cycle did not found
        return edges[bl1] ;  // case 1
        
        
    }
    
    
    
    public boolean union(int x , int y ){
        
        int lx = find(x,parent) ;
        int ly = find(y,parent) ;
        
        if(lx != ly ){
            
            if(rank[lx] < rank[ly]){
                parent[lx] = ly ;
            }
            else if(rank[ly] < rank[lx]){
              parent[ly] = lx ;
            }
            else{
               parent[lx] = ly ;
                rank[ly]++ ;
            }
            
            return true ;
        }
        else{
             return false;
        }
        
    }
    
    
    
    public int find(int x , int[] parent){
        if(parent[x] == x){
            return x ;
        }
        
        parent[x] = find(parent[x] , parent );
        return parent[x] ; 
    }
    
}
