package Graph_level_02;
import java.util.*;

public class Q31_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    

    // using DSU :

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        // first sorting based on the type in descending
        Arrays.sort(edges,(a,b) -> Integer.compare( b[0] , a[0] ) ) ;
        
        // we will make graph for both  alice and bob and check the max no of edges that are useless
        int[] parentA = new int[n+1] ; // for alice
        int[] parentB = new int[n+1] ; // for bob
        int[] rankA = new int[n+1] ; // alice
        int[] rankB = new int[n+1] ; // bob 
        
        // intializing
        for(int i = 1 ; i <= n ; i++ ){
            parentA[i] = i ;
            parentB[i] = i ;
            rankA[i] = 1 ;
            rankB[i] = 1 ;
        }
        

        // count of merged and removable edges
        // giving 1 initally becuase for the first time we add one edge with another edge.

        int mergedA = 1 ;
        int mergedB = 1 ;
        int removed = 0 ;
        
        
        for(int i = 0 ; i < edges.length ; i++){
            
            int type = edges[i][0] ;
            int u = edges[i][1] ;
            int v = edges[i][2] ;
            
            if(type == 3 ){ // means both bob and alice can access so run for both
                
                boolean tempA = union( u , v , parentA, rankA  );
                boolean tempB = union( u , v , parentB, rankB  );
                
                if(tempA == true){ // if alice used this edge then increment
                    mergedA++ ;
                }

                if(tempB == true){ // if bob used then increment his count
                    mergedB++ ;
                }
                
                
                // when no one used 
                if(tempA == false && tempB == false ){
                    removed++ ;
                }
                
            }
            else if(type == 2){ // for bob only as only he can traverse through it
                
                boolean tempB = union( u , v , parentB, rankB  );
                
                 if(tempB == true){
                    mergedB++ ;
                }
                else{
                    removed++ ;
                }
                
                
            }
            else{ // for alice
                
                boolean tempA = union( u , v , parentA, rankA  );
                
                 if(tempA == true){
                    mergedA++ ;
                }
                else{
                    removed++ ;
                }
                
                
            }
            
        }
        
        // checking if graph is fully connected or not.
        if(mergedA != n || mergedB != n){
            return -1 ;
        }

        return removed ;
        
    }
    
    
    // DSU OPERATIONS.
    
    public boolean union(int x , int y , int[] parent , int[] rank ){
        
        int lx = find(x,parent) ;
        int ly = find(y,parent) ;
        
        if(lx != ly){
            
            if(rank[lx] < rank[ly]){
                parent[lx] = ly;
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
           return false;
    }
    
    public int find(int x , int[] parent){
        if(parent[x] == x){
            return x ;
        }
        
        int temp = find(parent[x] , parent) ;
        parent[x] = temp ;
        
        return temp ;
    }

}
