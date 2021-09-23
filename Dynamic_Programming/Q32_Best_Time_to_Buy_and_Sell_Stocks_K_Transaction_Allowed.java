package Dynamic_Programming;

public class Q32_Best_Time_to_Buy_and_Sell_Stocks_K_Transaction_Allowed {

    public static void main(String[] args) {
        
    }

    public static int max_profit_k_transaction(int k , int[] prices) {
        

        int[][] dp = new int[k+1][prices.length] ;

        for (int ts = 0; ts < dp.length; ts++) {
            for (int d = 1; d < dp[0].length; d++) {

                dp[ts][d] = dp[ts][d-1] ;

                for (int pd = 0; pd < d ; pd++) {
                    
                    dp[ts][d] = Math.max(dp[ts][d], dp[ts-1][pd] + prices[d] - prices[pd]) ;
                }
                
            }
            
        }

        return dp[k][prices.length-1] ;
    }
    
}
