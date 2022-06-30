package Problem_Of_The_day;
import java.util.*;

public class Q71_Minimum_Moves_to_Equal_Array_Elements_II {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums) ;
        int moves = 0 ;
        int mid = nums[(nums.length-1)/2] ; // finding the mid element and then calculating the total increments or decrements every element will need to be equal to mid element.
        for(int val : nums){
            if(val > mid){
                moves += (val - mid) ;
            }
            else{
                moves += (mid - val) ;
            }
        }        
        return moves ;
    }
}
