package Graph_level_02;
import java.util.*;
public class Q43_Cheapest_Flights_Within_K_Stops {

    // using bfs solution : 
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;
        for(int i = 0  ; i < n ; i++)
            graph.add(new ArrayList<>()) ;
        
        for(int[] in : flights){
            int tsrc = in[0]; 
            int tdst = in[1] ;
            int tcost = in[2] ;
            Pair p = new Pair(tsrc,tdst,tcost) ;
            graph.get(tsrc).add(p);
        }
        
        LinkedList<edge> q = new LinkedList<>( ) ;
        q.add( new edge(src,0) ) ;
        k++ ;
        
        int min = (int)1e9 ;
        
        while(q.size() > 0 ){
            // System.out.println(q) ;
            if( k < 0 ) break ;
            int size = q.size() ;
            while(size-- > 0){
                edge re = q.removeFirst() ;
                // System.out.println(re.src + " -- "+ re.cost) ;
                if(re.src == dst){
                  min = Math.min(min,re.cost) ;  
                } 
                for(Pair p : graph.get(re.src)){
                        q.add( new edge(p.dst, re.cost + p.cost) ) ;
                }
            }
            k-- ;
        }
        
        // System.out.print(q) ;
        
        return min == (int) 1e9 ?  -1 : min ;
    }
    
    static class Pair{
        int src ;
        int dst ;
        int cost ;
        
        Pair(){}
        Pair(int x, int y, int z){
            src = x ;
            dst = y ; 
            cost = z ;
        }
        
        public String toString(){
            return "" + src +  " - " + dst + " - " + cost ; 
        }
    }
    
    static class edge{
        int src ;
        int cost ;
        
        edge(int x, int y){
            src = x ;
            cost = y ;
        }
        
         public String toString(){
            return "" + src +  " -  - " + cost ; 
        }
    }
}
