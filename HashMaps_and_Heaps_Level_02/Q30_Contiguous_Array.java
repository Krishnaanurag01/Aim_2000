package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q30_Contiguous_Array {

    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(0,-1) ;
        
        int sum = 0 ;
        int ans = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i] ;
            
            // adding 1 when current num is 0
            if(num == 0){
                sum += 1 ;
            }
            else{ // else adding -1 when current num is 1
                sum -= 1 ;
            }
            
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum)) ;
            }
            else{
                map.put(sum,i) ;
            }
        }
        
        return ans ;
    }
    
}
