package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q26_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        map.put(0,1) ; // storing 0 with freq 1 by default.
        int sum = 0 ;
        int count = 0 ;
        
        for(int i = 0 ; i  < nums.length ; i++){
            sum+= nums[i] ;
            
            if(map.containsKey(sum - k)){ 
                count += map.get(sum - k ) ;
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1) ;
        }
        
        return count ;
    }
    
}
