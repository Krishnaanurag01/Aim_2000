package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q31_Subarrays_with_equal_1s_and_0s {

    // same as Q30, only difference is here we are storing sum with thier frequency.

    static int countSubarrWithEqualZeroAndOne(int nums[], int n)
    {
         HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(0,1) ; // storing sum = 0 with frequency as 1.
        
        int sum = 0 ;
        int ans = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i] ;
            
            if(num == 0){
                sum += 1 ;
            }
            else{
                sum -= 1 ;
            }
            
            if(map.containsKey(sum)){
                ans +=  map.get(sum) ;
            }
            
                map.put(sum,map.getOrDefault(sum,0)+1) ;
        }
        return ans ;
    }
    
}
