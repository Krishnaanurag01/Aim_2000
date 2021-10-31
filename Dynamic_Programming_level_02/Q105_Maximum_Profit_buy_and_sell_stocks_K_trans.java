package Dynamic_Programming_level_02;

public class Q105_Maximum_Profit_buy_and_sell_stocks_K_trans {

    public static void main(String[] args) {
        
    }

    // check complete explanation in Dp Level 01.
    // method 01  : take  O(n3) time 
    public static int get_max_profit(int[] prices , int k ) {
        
        int[][] dp = new int[k+1][prices.length ] ;

        for (int i = 1 ; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) { // not starting from 0 becuase if we buy and sale stocks at the same day the 0 profit.
                
                // storing previous value by default.

                dp[i][j] = dp[i][j-1] ;

                for (int m = 0 ; m < j ; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][m] + prices[j] - prices[m]) ;
                }
            }
        }

        return dp[k][prices.length-1] ;
    }


    // method - 02 :  take only O(n2) time 

    public static int get_max_profit2(int[] prices , int k) {
        
        int[][] dp = new int[k+1][prices.length] ;

        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE ;
            for (int j = 1; j < dp[0].length; j++) {
                
                // keeping the max of previous row.
                if(dp[i-1][j-1]- prices[j-1] > max) {
                    max = dp[i-1][j-1]- prices[j-1] ;
                }

                dp[i][j] =  Math.max( max + prices[j] , dp[i][j-1] )  ;

            }
        }

        return dp[k][prices.length - 1] ;
    }
    
}
