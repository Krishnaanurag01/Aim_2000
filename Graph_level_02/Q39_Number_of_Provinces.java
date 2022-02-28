package Graph_level_02;
import java.util.*;

public class Q39_Number_of_Provinces {


    // Method 01 :

    // using DSU Approch : 


    static int[] parent ;
    static int[] rank ;
    public int findCircleNum(int[][] isConnected) {
        
        int v = isConnected.length ;
        
        parent = new int[v] ;
        rank = new int[v] ;
        
        for(int i = 0 ; i < v ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        // connecting all the cities through union operation of DSU
        for(int i = 0 ; i < isConnected.length ; i++){
            for(int j = 0 ; j < isConnected[0].length ; j++){
                
                if(isConnected[i][j] == 1 ){
                    union(i,j) ; 
                }
            }
        }
        

        // total parents (means total distinct component) is our answer.
        HashSet<Integer> set = new HashSet<>() ;
        
        for(int i = 0 ; i < parent.length ; i++){
            // System.out.print(parent[i] + " - ");
            set.add( find(i,parent) ) ;
        }
        
        return set.size() ;
        
    }
    

    // DSU OPERAATIONS:
    
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
    
    

    /// method 02 : DFS way

    public int findCircleNum2(int[][] isConnected) {
        
        int count = 0 ;
        
        // checking only row side becuase the givem matrix is adjency matrix and row or column side denotes the number of vertices
        for(int i = 0 ;i < isConnected.length ; i++){
            if(isConnected[i][i] == 0)
                continue ;
            
            count++ ;
            dfs(isConnected,i) ;
        }
        
        return count ;
        
    }
    
    public void dfs(int[][] graph , int i){
        
        graph[i][i] = 0 ;
        
        for(int j = 0 ; j < graph.length ; j++ ){
            if(graph[i][j] == 1 ){
                graph[i][j] = 0 ;
                if(graph[j][j] == 1 ){
                    dfs(graph,j) ;
                }
            }
        }
    }
    
    
}
