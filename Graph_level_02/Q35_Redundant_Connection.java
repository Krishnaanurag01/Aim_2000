package Graph_level_02;

public class Q35_Redundant_Connection {
    

    // using DSU.

    static int[] parent ;
    static int[] rank ;
    
    public int[] findRedundantConnection(int[][] edges) {
        
        // as a graph of n vertices has n - 1 edges so, e(total edges) + 1 is total vertices.
        int V = edges.length + 1 ;
        
        parent = new int[V+1] ; 
        rank = new int[V+1] ;
        
        for(int i = 0 ; i <= V ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        int[] ans = new int[2] ;
        
        for(int i = 0 ; i < edges.length ; i++){
            int x = edges[i][0] ;
            int y = edges[i][1] ;
            
            boolean merged = union(x,y);
            
            // updating the last not merged edge
            if(merged == false){
                ans[0] = x ;
                ans[1] = y ;
            }
        }
        
        return ans ;
        
        
    }

    
    // DSU functions.
    
    
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
