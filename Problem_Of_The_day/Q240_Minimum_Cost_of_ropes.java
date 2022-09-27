package Problem_Of_The_day;
import java.util.*;

public class Q240_Minimum_Cost_of_ropes {

    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>() ;
        
        for(long val : arr) pq.add(val) ;
        
        long ans = 0 ;
        while(pq.size() > 1){
            long first = pq.poll() ;
            long second = pq.poll() ;
            ans += first + second ;
            pq.add(first + second) ;
        }
        
        return ans ;
    }
}
