package Graph_level_02;
import java.util.*;

public class Q58_Path_of_greater_than_equal_to_k_length {

    
    class Pair{
        int src,cost ;
        Pair(int x, int y){
            src = x ;
            cost = y ;
        }
        
        public String toString(){
            return src + " -- " + cost ;
        }
    }
    
    boolean pathMoreThanK(int V , int E , int K , int [] A){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>() ;
        
        for(int i = 0 ; i < V ; i++){
            adj.add( new ArrayList<>()) ;
        }
        
        for(int i = 2 ; i < A.length ; i += 3){
            
            int u = A[i-2] ;
            int v = A[i-1] ;
            int wt = A[i] ;
   
            adj.get(u).add(new Pair(v,wt)) ;
            adj.get(v).add(new Pair(u,wt)) ;
        }
        
        // System.out.println(adj) ;
        boolean[] visited = new boolean[V] ;
        return  helper(0,adj,visited,K);
    }
    
    boolean helper(int src, ArrayList<ArrayList<Pair>> adj, boolean[] visited, int k){
        
        if(k <= 0) return true ;
        visited[src] = true ;
        
        for(Pair nbr : adj.get(src)){
            if(visited[nbr.src] == false){
                if(helper(nbr.src,adj,visited,k-nbr.cost)) return true ; // subtracting neighbours edge cost from k
            }
        }
        
        visited[src] = false; // backtracking
        
        return false;
    }
}
