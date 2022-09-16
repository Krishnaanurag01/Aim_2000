package Problem_Of_The_day;
import java.util.*;

public class Q231_Number_of_Ways_to_Arrive_at_Destination {

    static int min  ;
    static int count ;
    static int countPaths(int n, List<List<Integer>> roads) {
        
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>() ;
        
        for(int i = 0 ; i < n ; i++){
            adj.add( new ArrayList<>()) ;
        }
        
        for(List<Integer> l : roads){
            int u = l.get(0) ;
            int v = l.get(1) ;
            int wt = l.get(2) ;
            
            adj.get(u).add(new Edge(u,v,wt)) ;
            adj.get(v).add(new Edge(v,u,wt)) ;
        }
        
        min = (int)1e9 ;
        count = 0 ;
        boolean[] visited = new boolean[n] ;
        
        helper(0, adj, visited, 0) ;
        return count ;
    }
    
    static void helper(int src, ArrayList<ArrayList<Edge>> adj, boolean[] visited, int sum ){
        if(src == adj.size() - 1){
            if(min == sum){
                count++ ;
            }
            else if(sum < min){
                min = sum ;
                count = 1 ;
            }
            return  ;
        }
        if(sum > min) return ;
        
        visited[src] = true ;
        
        for(Edge nbrs : adj.get(src)){
            if(visited[nbrs.v] == false){
                helper(nbrs.v , adj, visited, sum + nbrs.wt);
            }
        }
        
        visited[src] = false;
    }
    
    static class Edge{
        int u ; 
        int v ;
        int wt ;
        
        Edge(int x, int y, int z){
            u = x ;
            v = y ;
            wt = z ;
        }
    }
}
