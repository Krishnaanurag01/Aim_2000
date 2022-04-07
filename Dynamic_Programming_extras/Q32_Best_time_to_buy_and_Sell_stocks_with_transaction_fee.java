package Dynamic_Programming_extras;

public class Q32_Best_time_to_buy_and_Sell_stocks_with_transaction_fee {


    public int maxProfit(int[] prices, int fee) {
        
        Integer[][] dp = new Integer[prices.length][2] ;
        return helper(0,1,prices,dp,fee) ;
    }
    
    static int helper(int idx, int buy, int[] prices, Integer[][] dp,int fee){
        
        if(idx == prices.length) return 0 ;
        
        if(dp[idx][buy] != null) return dp[idx][buy] ;
        
        int profit = 0 ;
        if(buy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1,0,prices,dp,fee),  0 + helper(idx+1,1,prices,dp,fee)  ) ;
        }
        else{ // as after selling we have to give fee so subtracting fee.
        profit = Math.max( (prices[idx] - fee) + helper(idx+1,1,prices,dp,fee), 0 + helper(idx+1,0,prices,dp,fee) ) ;
        }
        
        return dp[idx][buy] = profit ;        
    }
    


    // tabulations : 

    public int maxProfit2(int[] prices, int fee) {
        
        int[][] dp = new int[prices.length+1][2] ;
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                 
                 int profit = 0 ;
                 if(j == 1){
                 profit = Math.max(-prices[i] + dp[i+1][0],   0 + dp[i+1][1]  ) ;
                 }
                 else{ // as after selling we can't go to next day so going to idx +2 after selling.
                 profit = Math.max(prices[i] - fee + dp[i+1][1] , 0 + dp[i+1][0] ) ;
                 }   
                dp[i][j] = profit ; 
            }
        }
        return dp[0][1] ;
    }



    // space optimized tabulation : take just 4 space array. O(1) space comp

    public int maxProfit3(int[] prices, int fee) {
        
       
        int[] after = new int[2] ;
        int[] curr = new int[2] ;
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){
                    // int[] curr = new int[2] ;

            for(int j = 0 ; j <= 1 ; j++){
                 
                 int profit = 0 ;
                 if(j == 1){
                 profit = Math.max(-prices[i] + after[0],   0 + after[1]  ) ;
                 }
                 else{ // as after selling we can't go to next day so going to idx +2 after selling.
                 profit = Math.max(prices[i] - fee + after[1] , 0 + after[0] ) ;
                 }
            
                curr[j] = profit ; 
            }
            after = curr ;
        }
        
        return after[1] ;
    }
    
    
}
