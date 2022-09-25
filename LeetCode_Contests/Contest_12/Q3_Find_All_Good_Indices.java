package LeetCode_Contests.Contest_12;
import java.util.*;

public class Q3_Find_All_Good_Indices {

    public List<Integer> goodIndices(int[] nums, int k) {
        
        // storing length of decreasing sequence from start.
        int[] non_incre = new int[nums.length] ;
        non_incre[0] = 1 ; // initially length of first element is 1.
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] >= nums[i]){
                non_incre[i] = 1 + non_incre[i-1] ;
            }
            else non_incre[i] = 1 ;
        }
        
        
        // storing length of increasing sequence from end to start.
        int[] non_decre = new int[nums.length] ;
        non_decre[nums.length - 1] = 1 ; // initially length of last element is 1.
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            if(nums[i+1] >= nums[i]){ // when increasing
                non_decre[i] = 1 + non_decre[i+1] ;
            }
            else non_decre[i] = 1 ;
        }
        
        
        // checking index from k to n - k. and check 
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(int i = k ; i < nums.length - k ; i++){ 
            if(non_incre[i-1] >= k && non_decre[i+1] >= k) ans.add(i) ; // if it's left element decreasing order and right element incresing order is greater than equal to k or not.
        }
        
        return ans ;
    }
}
