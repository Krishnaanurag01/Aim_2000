package Dynamic_Programming_level_01;

public class Q34_Min_Cost_Climbing_Stairs {

    // using o(n) space

    public int minCostClimbingStairs(int[] cost) {
        
        int n =cost.length ;
        int[] dp = new int[n+2] ;
        dp[n-1] = cost[n-1] ;
        
        for(int i = n-1 ; i >= 0 ; i--){
            
            int oneS =  cost[i] + dp[i+1] ;
            int twoS = cost[i] + dp[i+2] ;
            
            dp[i] = Math.min(oneS,twoS) ;
        }
        
        
        return Math.min(dp[0] , dp[1]) ;
        
    }


    // using o(1) space.

    static int minCostClimbingStairs(int[] cost , int n) {
       
        int lo = 0 ;
        int l2 = 0 ;
        
        for(int i = n-1 ; i >= 0 ; i--){
            
            int oneS =  cost[i] + lo ;
            int twoS = cost[i] + l2 ;
                 
            l2 = lo ;
            lo = Math.min(oneS,twoS) ; 
        }
        
        return Math.min(lo,l2)  ;
    }
    
}
