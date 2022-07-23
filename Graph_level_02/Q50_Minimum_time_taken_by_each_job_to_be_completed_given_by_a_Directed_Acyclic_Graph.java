package Graph_level_02;
import java.util.*;

public class Q50_Minimum_time_taken_by_each_job_to_be_completed_given_by_a_Directed_Acyclic_Graph {

    // using topo sort.
 
    public static int [] minimumTime(int n,int m, int[][] edges) {
       
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]) ;
        }
        
        int[] indegree = new int[n+1] ;
        
        LinkedList<Integer> q = new LinkedList<>() ;
        
        for(int i = 1 ; i <= n ; i++){
            for(int nbr : graph.get(i)){
                indegree[nbr]++ ;
            }
        }
        
        for(int i = 1; i <= n ; i++){
            if(indegree[i] == 0) q.add(i) ;
        }
        
        int time = 1 ;
        int[] ans = new int[n] ;
        
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int rv = q.removeFirst() ;
                ans[rv-1] = time ;
                
                for(int nbr : graph.get(rv)){
                    indegree[nbr]-- ;
                    if(indegree[nbr] == 0) q.add(nbr) ;
                }
                
            }
            time++ ;
        }
        
        return ans ;
     }
}
