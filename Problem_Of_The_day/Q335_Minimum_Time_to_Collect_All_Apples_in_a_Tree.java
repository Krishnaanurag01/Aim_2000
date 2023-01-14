package Problem_Of_The_day;
import java.util.*;

public class Q335_Minimum_Time_to_Collect_All_Apples_in_a_Tree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        // making adjency list for graph.
        for(int[] edge : edges){
            int u = edge[0] ;
            int v = edge[1] ;
            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
        
        int ans = helper(adj,0,-1, hasApple) ;
        
        // if no apple return 0 if any apple found then return ans -2 becuase we are reducing 2 when we found any apple in sub tree part.
        return ans == 0 ? 0 : ans - 2 ;
    }
    
    public int helper(ArrayList<ArrayList<Integer>> adj, int src, int parent, List<Boolean> hasApple){
        
        int time = 0 ;
        
        for(int nbr : adj.get(src)){
            if(nbr == parent) continue ;
            time += helper(adj, nbr, src, hasApple) ; // time taken from child
        }
        
        if(hasApple.get(src) == true || time > 0) time += 2 ; // if current node is apple or it has time greater than 0 means its child is apple then add 2 (1 sec for outgoing and 1 for incoming)
        
        
        // System.out.println(src + " -- " + time) ;
        return time ;
    }
}
