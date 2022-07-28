package Graph_level_02;
import java.util.*;

public class Q54_Maximum_Path_Quality_of_a_Graph {

     
    class Pair{
        int src ;
        int cost ;
        
        Pair(int x, int wt){
            src = x ;
            cost = wt ;
        }
    }
    static int ans ;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < values.length ; i++) adj.add(new ArrayList<>()) ;
        for(int[] e : edges){
            int u = e[0] ;
            int v = e[1] ;
            int wt = e[2] ;
            
            adj.get(u).add(new Pair(v,wt)) ;
            adj.get(v).add(new Pair(u,wt)) ;
        }
        
        ans = 0 ;
     
        helper(0,values,adj,maxTime,0) ;
        
        return Math.max(ans,values[0]) ;
    }
    
    void helper(int src, int[] values, ArrayList<ArrayList<Pair>> graph,int maxtime, int anssf){
        
        if(src == 0){
            // anssf += values[0] ;
            ans = Math.max(anssf,ans) ;
        }
        
        
        int bkp = values[src] ;
        values[src] = 0 ;
        
        
        for(Pair nbr : graph.get(src)){
            if(nbr.cost <= maxtime){
                helper(nbr.src, values, graph, maxtime - nbr.cost, anssf + bkp) ;
            }
        }
        
        values[src] = bkp ;
        
        return  ;
    }
}
