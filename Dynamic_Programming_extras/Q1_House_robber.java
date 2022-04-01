package Dynamic_Programming_extras;

public class Q1_House_robber {

    // memoiation : takes O(N) time and O(n) + O(stackFrame) space.
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length] ;
        return helper(nums.length-1,nums,dp);
    }
    
    int helper(int i, int[] nums, Integer[] dp ){
        if(i < 0 ) return 0 ;
        
        if(dp[i] != null) return dp[i] ; //usning memoiation

            int picked = nums[i] + helper(i-2,nums,dp) ; // if picked current element then go to i-2
            int notPicked = 0 + helper(i-1,nums,dp) ; // if not picked then add 0 and go to i-1
        
            return dp[i] = Math.max(picked,notPicked) ;
    }


    // tabulation : takes : O(n) time and space

    public int rob2(int[] nums) {
        int[] dp = new int[nums.length] ;
        dp[0] = nums[0] ;
        
        for(int i = 1 ; i < nums.length ; i++){
            int notPicked = 0 + dp[i-1] ;
            int picked = nums[i] + ( i > 1 ? dp[i-2] : 0 ) ;
            dp[i] = Math.max(notPicked,picked) ;
        }
        return dp[nums.length-1] ;
    }


    // optimal solution : takes O(n) time and O(1) space.

    public int rob3(int[] nums) {
       
        int fp = nums[0] ; // first prev
        int sp = 0 ; // second prev
        
        for(int i = 1 ; i < nums.length ; i++){
            int notPicked = 0 + fp ; // if not picked then take i-1 ans(just previous or fp)
            int picked = nums[i] + ( i > 1 ? sp : 0 ) ; // take sp(second previous that is i-2)
            sp = fp ; // now sp becomes fp
            fp = Math.max(notPicked,picked) ; // and new fp assigned
        }
        return fp ;
    }
}
