package Problem_Of_The_day;

public class Q136_Combination_Sum_IV {

    Integer[] dp ;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1] ;
        return helper(nums,target) ;
    }
    
    int helper(int[] nums, int target){
        if(target == 0) return 1 ;
        if(dp[target] != null) return dp[target] ;
        
        int count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= target){
                count += helper(nums,target-nums[i]) ;
            }
        }
        
        return dp[target] = count ;
    }
}
