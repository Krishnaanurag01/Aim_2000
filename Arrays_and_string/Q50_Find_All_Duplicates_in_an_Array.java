package Arrays_and_string;
import java.util.*;

public class Q50_Find_All_Duplicates_in_an_Array {
    
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>() ;
        
        for(int i = 0 ; i < nums.length ; i++){
        
            int index = Math.abs(nums[i]) - 1 ;  // finding the correct index of current value.  // as array has element ranges from 1 to n and not have o so index of nums[i] will be = nums[i] - 1. means 1 is index for 2 integer, 0 is the index of 1 and so on.
            
            int val = nums[index] ; // now retriving value.
            
            if(val < 0){
                // means someone already made it negative so current number is duplicate.
                list.add(index+1) ;
            }
            else{ // else  mark negative.
                nums[index] *= -1 ; 
            } 
        }
        
        return list ;
    }
}
