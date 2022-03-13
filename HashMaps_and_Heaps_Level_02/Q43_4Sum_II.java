package HashMaps_and_Heaps_Level_02 ;
import java.util.*;

public class Q43_4Sum_II {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        // storing two sum of nums1 and nums2 in map
        for(int num1 : nums1){
            for(int num2 : nums2 ){
                map.put(num1+num2, map.getOrDefault(num1+num2,0)+1) ;
            }
        }
        
        int target = 0 ;
        int count = 0 ;
        
        // now calculating two of nums3 and nums4 and getting rest of the value from map.
        for(int num3 : nums3){
            for(int num4 : nums4 ){
                count+= map.getOrDefault(target - (num3+num4),0) ;
            }
        }
        
        return count; 
        
    }
    
}
