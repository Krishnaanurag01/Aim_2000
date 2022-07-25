package Graph_level_02;
import java.util.*;

public class Q51_Prerequisite_Tasks {
    // kahns algorithm application.
    
    public boolean isPossible(int n, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
       for(int i = 0 ; i < n ; i++){
           graph.add(new ArrayList<>());
       }
       
       for(int[] e : edges){
           graph.get(e[0]).add(e[1]) ;
       }
       
       int[] indegree = new int[n] ;
       
       LinkedList<Integer> q = new LinkedList<>() ;
       
       for(int i = 0 ; i < n ; i++){
           for(int nbr : graph.get(i)){
               indegree[nbr]++ ;
           }
       }
       
       for(int i = 0; i < n ; i++){
           if(indegree[i] == 0) q.add(i) ;
       }
       
       int count = 0 ;
       
       while(q.size() > 0){
           int size = q.size();
           while(size-- > 0){
               int rv = q.removeFirst() ;
               count++ ;
               
               for(int nbr : graph.get(rv)){
                   indegree[nbr]-- ;
                   if(indegree[nbr] == 0) q.add(nbr) ;
               }
           }
       }
       
       
       
       
       return count == n ;
    }
}
