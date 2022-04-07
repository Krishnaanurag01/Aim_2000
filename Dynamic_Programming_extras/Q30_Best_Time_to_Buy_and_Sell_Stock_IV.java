package Dynamic_Programming_extras;

public class Q30_Best_Time_to_Buy_and_Sell_Stock_IV {


    // ditto same as Q29, here we are using k only instead of count 2
    // same as Q29. Instead of count 2 we are passing k here. 

    // using memoization.
    public int maxProfit(int k, int[] prices) {
        
        Integer[][][] dp = new Integer[prices.length][2][k+1] ;
        return helper(0,1,k,prices,dp) ;
    }
    
    static int helper(int idx, int buy, int k , int[] prices, Integer[][][] dp){
        
        if(idx == prices.length || k == 0 ) return 0 ;
        
        if(dp[idx][buy][k] != null) return dp[idx][buy][k] ;
        
        int profit = 0 ;
        if(buy == 1){
            profit = Math.max( -prices[idx] + helper(idx+1,0,k,prices,dp), 0 + helper(idx+1,1,k,prices,dp) ) ;
        }
        else{// selling.
            profit = Math.max( prices[idx] + helper(idx+1,1,k-1,prices,dp) , 0 + helper(idx+1,0,k,prices,dp) ) ;
        }
        
        return dp[idx][buy][k] = profit ;
    }




    // using tabulations : 

    public int maxProfit2(int k, int[] prices) {
        
        int[][][] dp = new int[prices.length+1][2][k+1] ;
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                for(int m = 1 ; m <= k ; m++){
                    
                    int profit = 0 ;
                    if(j == 1){
                         profit = Math.max(-prices[i] + dp[i+1][0][m],  0 + dp[i+1][1][m] );
                     }
                    else{// selling.
                         profit = Math.max( prices[i] + dp[i+1][1][m-1]  , 0 + dp[i+1][0][m] ) ;
                     } 
        
                    dp[i][j][m] = profit ;
                }
            }
        }   
        
        return dp[0][1][k] ;
    }


    // space optimized tabulations : same as Q29's

    public int maxProfit3(int k, int[] prices) {
        
        int[][] after = new int[2][k+1] ;
        int[][] curr = new int[2][k+1] ;
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                for(int m = 1 ; m <= k ; m++){
                    
                    int profit = 0 ;
                    if(j == 1){
                         profit = Math.max(-prices[i] + after[0][m],  0 + after[1][m] );
                     }
                    else{// selling.
                         profit = Math.max( prices[i] + after[1][m-1]  , 0 + after[0][m] ) ;
                     } 
        
                    curr[j][m] = profit ;
                }
            }
            after = curr ;
        }   
        
        return curr[1][k] ;
    }
    
}
