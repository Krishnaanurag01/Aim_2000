package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q27_Longest_Sub_Array_with_Sum_K {

    // same as Q26. only difference is here we are storing sum with the index.

    public static int lenOfLongSubarr (int nums[], int N, int k) {
      
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        map.put(0,-1) ;
        int sum = 0 ;
        int ans = 0 ;
        
        for(int i = 0 ; i  < nums.length ; i++){
            sum+= nums[i] ;
            
            // getting the index of sum-k and calculating the length
            if(map.containsKey(sum - k)){
                ans = Math.max(ans, i - map.get(sum-k) ) ;
            }
            
            // adding to map only when current sum is not available in map.
            if(map.containsKey(sum) == false)
            map.put(sum,i) ;
        }
        
        return ans ;
        
    }
    
}
