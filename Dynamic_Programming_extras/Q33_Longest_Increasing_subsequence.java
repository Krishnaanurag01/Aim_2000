package Dynamic_Programming_extras;

public class Q33_Longest_Increasing_subsequence {


    // recursive solution.

    public int lengthOfLIS(int[] nums) {
        
        return helper(0,-1,nums) ;
    }
    
    static int helper(int idx, int prev, int[] nums){
        if(idx == nums.length) return  0 ;
        
        int longest =  0 + helper(idx+1,prev,nums) ; // not taking current element.
        
        if(prev == -1 || nums[prev] < nums[idx] ){ // taking current element iff it's prev idx is -1 or it is larger then prev num
            longest = Math.max( longest, 1 + helper(idx+1,idx,nums) );
        }
        
        return longest ;
    }


    // using memoization : 

    public int lengthOfLIS2(int[] nums) {
        
        Integer[][] dp = new Integer[nums.length][nums.length+1] ; // j(prev) is of nums.length + 1 becuase we are starting from -1 to n-1 so we will store result of i,-1 as [i],[-1 + 1] for every j.
        return helper(0,-1,nums,dp) ;
    }
    
    static int helper(int idx, int prev, int[] nums, Integer[][] dp){
        if(idx == nums.length) return  0 ;
        
        if(dp[idx][prev + 1] != null) return dp[idx][prev+1] ; // returning if solved before
        int longest =  0 + helper(idx+1,prev,nums,dp) ;
        
        if(prev == -1 || nums[prev] < nums[idx]){
            longest = Math.max( longest, 1 + helper(idx+1,idx,nums,dp) );
        }
        
        return dp[idx][prev+1] = longest ; // storing and returning.
    }




    // tabulation code . 

    public int lengthOfLIS3(int[] nums) {
        
        int[][] dp = new int[nums.length+1][nums.length+1] ;
        
        for(int i = nums.length -1 ; i >= 0 ; i--){ // running in revrse of memo
            for(int j = i-1;  j >= -1 ; j-- ){   // running from n-1 -> -1
                
                // In memo sol we were sotring second parameter with +1  so here we will do the same.
                int longest =  0 + dp[i+1][j+1] ; 
         
                if(j == -1 || nums[j] < nums[i]){ 
                    longest = Math.max( longest, 1 + dp[i+1][i+1] ); // here also second parameter +1
                }
        
                dp[i][j+1] = longest ;  
            }
        }
        
        
        return dp[0][-1+1] ;
    }



    // space optimized solution  : /// taking O(2n) space.


    public int lengthOfLIS4(int[] nums) {
        
        int[] after = new int[nums.length+1] ; // holds next row data
        int[] curr = new int[nums.length+1] ; // holds curr row data
        
        for(int i = nums.length -1 ; i >= 0 ; i--){
            for(int j = i-1;  j >= -1 ; j-- ){
                
                 int longest =  0 + after[j+1] ;
         
                if(j == -1 || nums[j] < nums[i]){
                     longest = Math.max( longest, 1 + after[i+1] );
                }
            curr[j+1] = longest ;                
            }
            after = curr ; //storing curr in after for next iteration
        }   
        return after[0] ;
    }



    // another tabulation approch.

    public int lengthOfLIS5(int[] nums) {
        
        int[] dp = new int[nums.length+1] ;
        int ans = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            int max = (int)-1e8 ;
            for(int j = 0 ; j < i ; j++){ // searching in 0 to i-1 if any element is smaller and has bigger Lis there we will add our current element.
                
                if(nums[j] < nums[i]){
                    max = Math.max(max,dp[j]) ;
                }
            }
            dp[i] = max == (int)-1e8 ?  1 : max + 1 ;
            ans = Math.max(ans,dp[i]) ;
        }   
        
        return ans ;
    }
}
