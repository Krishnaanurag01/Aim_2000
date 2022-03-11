package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q28_Longest_subarray_with_sum_divisible_by_K {

    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        // storing 0 remainder with index -1
        map.put(0,-1) ;
        int sum = 0 ;
        int ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            sum += a[i] ;
          
            int rem = sum % k ;
            
            // if remainder of sum is negative then add k in it. becuase adding k with negative rem is equivalent to positive rem.
            if(rem < 0 ){
                rem += k ;
            }
            
            // checking if same remainder came before or not.
            if(map.containsKey(rem) ){
                ans = Math.max(ans, i - map.get(rem) ) ;
            }
            else{
                map.put(rem,i) ;
            }
            
            
        }
        
        return ans ;
    }
    
}
