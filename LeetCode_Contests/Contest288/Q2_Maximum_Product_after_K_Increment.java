package LeetCode_Contests.Contest288;
import java.util.*;
public class Q2_Maximum_Product_after_K_Increment {
    
    public int maximumProduct(int[] nums, int k) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>() ;
        // storing in queue.
        for(int n : nums){
            q.add(n) ;
        }

        int mod = (int)1e9+7 ;
        // incrementing the smallest number k times.
        while(k-- > 0){
           int ri = q.poll() ;
            q.add( (ri+1)% mod ) ;    
        }
        
        System.out.println(q) ;
        long sum = 1 ;
        // nor calculating it.
        while(q.size()!= 0){
            int rn = q.poll() ;
            sum = (sum*rn) % mod ;
        }      
        
        return (int)sum ;
    }
}
