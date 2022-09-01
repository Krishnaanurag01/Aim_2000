package Problem_Of_The_day;
import java.util.*;

public class Q209_Array_Partition {

    public int arrayPairSum(int[] nums) {
        
        // we just have to divide nums into number of pairs. and to maximized the min value we will chose two adjecent value as one pair.
        int ans = 0 ;
        Arrays.sort(nums) ;
        
        for(int i = 0 ; i < nums.length - 1 ; i++){
            ans += Math.min(nums[i],nums[i+1]) ; // so choosing two adjecent value as one pair and taking min out of them.
            i++ ; // now jumping to next pair start value.
        }
        
        return ans ;
    }
}
