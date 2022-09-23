package LeetCode_Contests.Contest_309;

public class Q3_Longest_Nice_Subarray {

    public int longestNiceSubarray(int[] nums) {

        // sliding window
        
        int ans = 1 ;
        int j = 0 ;
        int i = 1 ;
        int sum = nums[0] ;
        
        while(i < nums.length){
            int val = nums[i] ;
            if( (val & sum) == 0 ){ // if current value and sum is 0 then we can include the current value.
                ans = Math.max(ans, i - j + 1) ;
                sum += val ;
            }
            else{ // otherwisse remove from j side.
                
                while(j < i && (sum & val) != 0){
                     int jVal = nums[j] ;
                     sum -= jVal ;
                    j++ ;
                }
                
                if( j == i){
                    sum = val ;
                }
                ans = Math.max(ans, i - j + 1) ;
            }
             i++;
        }
        
        return ans ;
    }
}
