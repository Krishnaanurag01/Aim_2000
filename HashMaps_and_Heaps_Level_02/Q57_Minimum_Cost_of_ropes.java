package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q57_Minimum_Cost_of_ropes {

    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> q = new PriorityQueue<>() ;
        
        // adding all the length of ropes in q so that we can access two min length ropes easily everytime.
        for(long i : arr){
            q.add(i) ;
        }
        
        long count = 0 ; // answer.
        
        while(q.size() > 1 ) {
            long r1 = q.remove() ; // removing samllest length
            long r2 = q.poll() ; // and second smallest rope
            
            long total = r1 + r2 ; // connecting the both ropes
            
            count += total ; // now adding the cost for their connectivity
            
            q.add(total) ; // and also adding the new length rope in q so that we can connect all ropes into one.
        }
        
        return count ;
    }
    
}
