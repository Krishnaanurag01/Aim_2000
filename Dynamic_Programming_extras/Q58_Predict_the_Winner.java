package Dynamic_Programming_extras;

public class Q58_Predict_the_Winner {

    public boolean PredictTheWinner(int[] nums) {
        
        int two = 0 ;
        
        for(int val : nums)
            two += val ;
        
        int one = helper(0,nums.length-1,nums,0) ;
        two -= one ;
        
        return one >= two ;
    }
    
    int helper(int si, int ei, int[] nums, int turn){
        
        if(si > ei) return 0 ;
        // turn 0 : player one chance.
        if(turn == 0 )
            return Math.max( nums[si] + helper(si + 1, ei, nums, 1), nums[ei] + helper(si, ei-1, nums, 1) ) ;
        else // when turn 1 : player two chance. we don't have to calculate for second player.
            return Math.min(helper(si+1,ei,nums,0), helper(si,ei-1,nums,0)) ;
    }


    // memoization.

    static Integer[][] dp ;
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length ;
        dp = new Integer[n][n] ;
        
        int two = 0 ;
        for(int val : nums)
            two += val ;
        
        int one = helper(0,nums.length-1,nums,0) ; // find the max score player one can make.
        two -= one ; // now subtracting one's max scores from total score will give two's score.
        
        return one >= two ;
    }
    
    int helper2(int si, int ei, int[] nums, int turn){
        
        if(si > ei) return 0 ;
        if(dp[si][ei] != null) return dp[si][ei] ;
        // turn 0 : player one chance.
        if(turn == 0 )
            return dp[si][ei] = Math.max( nums[si] + helper2(si + 1, ei, nums, 1), nums[ei] + helper2(si, ei-1, nums, 1) ) ;
        else
            return dp[si][ei] = Math.min(helper2(si+1,ei,nums,0), helper2(si,ei-1,nums,0)) ;
    }
}
