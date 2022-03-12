package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q35_Count_pairs_with_given_sum {


    int getPairsCount(int[] arr, int n, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            
            int val = arr[i] ;
            int rem = k - val ;
            
            if(map.containsKey(rem)){
                ans += map.get(rem) ;
            }
            
            map.put(val,map.getOrDefault(val,0)+1) ;
            
        }
        
        return ans ;
    }
    
}
