package Graph_level_02;
import java.util.*;

public class Q68_Minimum_edges_to_reverse_to_make_path_from_a_source_to_a_destination {

    // using 0-1 bfs :

    public static int reverseEdges(int n, int start, int end, ArrayList<ArrayList<Integer>> edgeList) {
        
        ArrayList<ArrayList<Pair>> bdAdj = new ArrayList<>() ; // bidirectional graph
        
        for(int i = 0 ; i < n ; i++){
            bdAdj.add( new ArrayList<>()) ;
        }
        
        for(ArrayList<Integer> nbr : edgeList){
            int u = nbr.get(0);
            int v = nbr.get(1) ;
            
             bdAdj.get(u).add(new Pair(v,0)) ; // this is the given edge
             bdAdj.get(v).add(new Pair(u,1)) ; // this is extra edge with cost 1 that we added byourselves
        }
        
        
        PriorityQueue<Pair> q = new PriorityQueue<>( (a,b) -> a.cost - b.cost) ;
        int[] visited= new int[n+1] ;
        Arrays.fill(visited,(int)1e9) ;
        q.add(new Pair(start,0));
        visited[start] = 0;
        
        while(q.size() > 0){
            Pair rp = q.poll() ;
            if(rp.val == end) return rp.cost ;
            
           for(Pair nbr : bdAdj.get(rp.val)){
               if(visited[nbr.val] > rp.cost + nbr.cost){
                   q.add( new Pair(nbr.val, rp.cost + nbr.cost)) ;
                   visited[nbr.val] = rp.cost + nbr.cost;
               }    
           }
            
        }
        
        
        
        
        return -1;
    }
    
    
    static class Pair{
        int val  ;
        int cost ;
        
        Pair(int x, int y){
            val = x;
            cost = y ;
        }
        
        public String toString(){
            return val + " - "+ cost ;
        }
    }
}
