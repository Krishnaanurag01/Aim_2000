package Problem_Of_The_day;
import java.util.*;

public class Q265_Continuous_Subarray_Sum {

    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int sum = 0 ;
        map.put(0, -1) ;
        
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i] ;
            if(map.containsKey(sum % k) && i - map.get(sum % k) >= 2) return true ;
            map.putIfAbsent(sum % k, i) ;
        }
        
        return false;
    }
}
