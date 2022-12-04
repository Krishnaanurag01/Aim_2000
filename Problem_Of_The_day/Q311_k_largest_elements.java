package Problem_Of_The_day;
import java.util.*;

public class Q311_k_largest_elements {

    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a) ;
        
        for(int val : arr){
            pq.add(val) ;
        }
        
        int[] ans = new int[k] ;
        int m = 0 ;
        
        while(m < ans.length && pq.size() > 0){
            ans[m++] = pq.poll();
        }
        
        return ans ;
    }
}
