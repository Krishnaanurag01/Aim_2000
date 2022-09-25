package LeetCode_Contests.Contest_12;

public class Q2_Longest_Subarray_With_Maximum_Bitwise_AND {

    public int longestSubarray(int[] nums) {
        
        int best_sum = nums[0] ;
        int curr_sum = nums[0] ;
        int ans = 1 ;
        int length = 1 ;
        
        // kadanes algortihm with bitwise AND.
        for(int i = 1 ; i < nums.length ; i++){
            curr_sum = curr_sum & nums[i] ; // performing AND
            length++ ;
            
            if(nums[i] >  curr_sum){ // now check if curr_sum is still less than current element make curr as curr_sum
                curr_sum = nums[i] ;
                length = 1 ; // and length is 1 now
            }
            
            if(best_sum < curr_sum){ //updating answer.
                best_sum = curr_sum ;
                ans = length ;
            }
            else if(best_sum == curr_sum){ // choosing the max length
                ans = Math.max(ans,length) ;
            }
        }
        
        return ans ;
    }
}
