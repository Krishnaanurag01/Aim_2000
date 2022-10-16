package LeetCode_Contests.Contest_315;
import java.util.*;;

public class Q2_Count_Number_of_Distinct_Integers_After_Reverse_Operations {

    public int countDistinctIntegers(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>() ;
        
        for(int val : nums){
            set.add(val) ;
            
            int reverse = 0 ;
            
            while(val > 0){
                int digit = val % 10 ;
                reverse = (reverse * 10) + digit ;
                val = val/10 ;
            }
            
            set.add(reverse) ;
            // System.out.println(val  + " -- " + reverse) ;
        }
        
        return set.size() ;
    }
}
