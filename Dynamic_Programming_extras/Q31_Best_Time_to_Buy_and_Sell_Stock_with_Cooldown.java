package Dynamic_Programming_extras;

public class Q31_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    // using memoization  : 

    public int maxProfit(int[] prices) {
        
        Integer[][] dp = new Integer[prices.length][2] ;
        return helper(0,1,prices,dp) ;
    }
    
    static int helper(int idx, int buy, int[] prices, Integer[][] dp){
        
        if(idx >= prices.length) return 0 ;
        
        if(dp[idx][buy] != null) return dp[idx][buy] ;
        
        int profit = 0 ;
        if(buy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1,0,prices,dp),  0 + helper(idx+1,1,prices,dp)  ) ;
        }
        else{ // as after selling we can't go to next day so going to idx +2 after selling.
            profit = Math.max(prices[idx] + helper(idx+2,1,prices,dp), 0 + helper(idx+1,0,prices,dp) ) ;
        }
        
        return dp[idx][buy] = profit ;        
    }


    

    // converted memoization to tabulations : 

    public int maxProfit2(int[] prices) {
        
        int[][] dp = new int[prices.length+2][2] ;
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                 
                 int profit = 0 ;
                 if(j == 1){
                 profit = Math.max(-prices[i] + dp[i+1][0],   0 + dp[i+1][1]  ) ;
                 }
                 else{ // as after selling we can't go to next day so going to idx +2 after selling.
                 profit = Math.max(prices[i] + dp[i+2][1] , 0 + dp[i+1][0] ) ;
                 }
            
                dp[i][j] = profit ; 
            }
        }
        
        return dp[0][1] ;
    }

    //// space optimized tabulations :  // takes O(1) space

    public int maxProfit4(int[] prices) {
        
        int[] after1 = new int[2] ; // hold curr + 1 row 
        // int[] curr = new int[2] ;
        int[] after2 = new int[2] ; // holds curr + 2 row
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){
                    int[] curr = new int[2] ;

            for(int j = 0 ; j <= 1 ; j++){
                 
                 int profit = 0 ;
                 if(j == 1){
                 profit = Math.max(-prices[i] + after1[0],   0 + after1[1]  ) ;
                 }
                 else{ // as after selling we can't go to next day so going to idx +2 after selling.
                 profit = Math.max(prices[i] + after2[1] , 0 + after1[0] ) ;
                 }
            
                curr[j] = profit ; 
            }
            after2 = after1 ; 
            after1 = curr ;
        }
        
        return after1[1] ;
    }
    
}
