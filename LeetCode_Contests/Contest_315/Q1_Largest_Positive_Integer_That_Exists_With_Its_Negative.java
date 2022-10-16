package LeetCode_Contests.Contest_315;
import java.util.*;

public class Q1_Largest_Positive_Integer_That_Exists_With_Its_Negative {

    public int findMaxK(int[] nums) {
        
        int ans = -1 ;
        HashSet<Integer> set = new HashSet<>() ;
        
        for(int val : nums){
            
            if(val > 0){
                if(set.contains(-val)){
                    ans = Math.max(ans, val) ;
                }
            }
            else{
                if(set.contains(-val)){
                    ans = Math.max(ans, -val) ;
                }
            }
            
            set.add(val) ;
        }
        
        return ans ;
    }
}
