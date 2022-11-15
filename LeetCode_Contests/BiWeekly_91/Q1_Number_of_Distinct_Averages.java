package LeetCode_Contests.BiWeekly_91;
import java.util.*;

public class Q1_Number_of_Distinct_Averages {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums) ;
        int i = 0 ; 
        int j = nums.length - 1 ;
        HashSet<Double> set = new HashSet<>() ;
        
        while(i < j){
            set.add((nums[i++]*1.0 + nums[j--]*1.0)/2);
        }
        
        return set.size() ;
    }
}
