package Dynamic_Programming_extras;

public class Q28_Best_Time_to_Buy_and_Sell_Stock_II {
 
    
    public int maxProfit(int[] prices) {
        
        Integer[][] dp = new Integer[prices.length][2] ;
        return helper(0,1,prices,dp) ; // 1 denotes buy stock 
    }
    
    static int helper(int idx, int buy, int[] prices, Integer[][] dp){
        if(idx == prices.length) return 0 ; 
        
        if(dp[idx][buy] != null) return dp[idx][buy] ;
        
        int profit = 0 ;
        if(buy == 1){ // means we have to buy stocks
            // first conditon is buy current stock + go to next with 0 (denotes sell option) and consiton is do not buy current stock and move to next
            profit = Math.max(-prices[idx] + helper(idx+1,0,prices,dp) , 0 + helper(idx+1,1,prices,dp) );
        }
        else{ // when buy == 0 then we to sell
            // fc is sell current stock and move to next with 1 denotes buy stock and else not sell today
            profit = Math.max(prices[idx] + helper(idx+1,1,prices,dp), 0 + helper(idx+1,0,prices,dp)) ;
        }
        return dp[idx][buy] = profit ;
    }
}
