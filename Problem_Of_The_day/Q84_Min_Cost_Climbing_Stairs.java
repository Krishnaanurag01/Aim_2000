package Problem_Of_The_day;

public class Q84_Min_Cost_Climbing_Stairs {

    Integer[] dp ;
    public int minCostClimbingStairs(int[] cost) {
     if (cost.length == 1) return cost[0] ;
        
        dp = new Integer[cost.length] ;
        int sw0 = helper(0,cost) ;
        int sw1 = helper(1,cost) ;
        return sw0 < sw1 ? sw0 : sw1 ;
    }
    
    int helper(int idx, int[] cost){
        if(idx >= cost.length) return 0 ;
        if(dp[idx] != null) return dp[idx] ;
        int oneStep = helper(idx+1,cost) ;
        int twoStep = helper(idx+2,cost) ;
        
        return dp[idx] = oneStep < twoStep ? oneStep + cost[idx] : twoStep + cost[idx] ;
    }
}
