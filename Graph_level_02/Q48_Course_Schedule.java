package Graph_level_02;
import java.util.*;

public class Q48_Course_Schedule {
    
    // kahns algorithm :

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        
        for(int i = 0 ; i < numCourses ; i++) graph.add(new ArrayList<>()) ;
        
        for(int[] pre : prerequisites){
            int u = pre[0] ;
            int v = pre[1] ;
            graph.get(u).add(v) ;
        }
        
        int[] indegree = new int[numCourses] ;
        
        for(int i = 0 ; i < numCourses ; i++){
            for(int nbr : graph.get(i)){
                indegree[nbr]++ ;
            }
        }
        
        LinkedList<Integer> q =new LinkedList<>() ;
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0) q.add(i) ;
        }
        
        int count = 0 ;
        
        while(q.size() > 0){
            int rf = q.removeFirst() ;
            count++ ;
            for(int nbr : graph.get(rf)){
                indegree[nbr]-- ;
                if(indegree[nbr] == 0) q.add(nbr) ;
            }
        }
        
        return count == numCourses ;
    }
}
