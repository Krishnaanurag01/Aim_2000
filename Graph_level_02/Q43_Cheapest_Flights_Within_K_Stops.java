package Graph_level_02;
import java.util.*;
public class Q43_Cheapest_Flights_Within_K_Stops {

    // using bfs solution : 
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;
        for(int i = 0  ; i < n ; i++)
            graph.add(new ArrayList<>()) ;
        
        // making adjency list (graph)
        for(int[] in : flights){
            int u = in[0]; 
            int v = in[1] ;
            int tcost = in[2] ;
            Pair p = new Pair(v,tcost) ;
            graph.get(u).add(p);
        }

        
        int[] visited = new int[graph.size()] ; // here we will store cost so far
        int[] stepsf = new int[graph.size()] ; // and stops taken at ith vertices so far.
        // assigning max value by default
        Arrays.fill(visited,(int)1e9) ; 
        Arrays.fill(stepsf,(int)1e9) ;
        
        // using dikstras : 
        PriorityQueue<QPair> q = new PriorityQueue<>((a,b) -> a.cost - b.cost ) ; // comparation on cost.
        q.add(new QPair(src,0,1));
        visited[src] = 0;
        stepsf[src] = 1 ; //src has one stops
        
        while(q.size() > 0){
            // System.out.println(q) ;
            QPair rp = q.poll() ;
            if(rp.stops - 2 > k) continue ; // subtracting 2 becuase we had counted stops for src and dst as well.
            if(rp.src == dst) return rp.cost ;
            
            
            for(Pair p : graph.get(rp.src)){
                if(rp.cost + p.cost <= visited[p.src] || rp.stops + 1 < stepsf[p.src]){ // if found min cost or with min stops then consider it.
                    visited[p.src] = rp.cost + p.cost ;
                    stepsf[p.src] = rp.stops + 1 ;
                    q.add( new QPair(p.src, p.cost + rp.cost, rp.stops + 1)) ;
                }
            }
        }
        
       return -1;
    }
    
    static class Pair{
        int src ;
        int cost ;
        
        Pair(){}
        Pair( int y, int z){
            src = y ; 
            cost = z ;
        }
        
        public String toString(){
            return " - " + src + " - " + cost ; 
        }
    }
    
    static class QPair{
        int src ;
        int cost ;
        int stops ;
        
        QPair(int x, int y, int z){
            src = x ;
            cost = y ;
            stops = z ; 
        }
        
        public String toString(){
            return  src + " - " + cost + " - " +stops ; 
        }
    }
}
