package Dynamic_Programming_extras;

public class Q29_Best_Time_to_Buy_and_Sell_Stock_III {


    // using memoization : 

    public int maxProfit(int[] prices) {
        
        Integer[][][] dp = new Integer[prices.length][2][3] ;
        return helper(0,1,prices,2,dp) ;  // 0 is index in price, 1 denotes helper function will buy stock and 2 denotes it has 2 capacity limit.
    }
    
    static int helper(int idx, int buy, int[] prices, int count, Integer[][][] dp ){
        if(idx == prices.length) return 0 ; // if idx zero then return 0 
            if(count == 0 ) return 0 ; // if we got all two stock then return 0

        if(dp[idx][buy][count] != null) return dp[idx][buy][count] ; // already solved return
        
        int profit = 0 ; // same recurrence as Q28, here we just added the count which denote count of stock we have to buy and sell
        if(buy == 1){
            profit = -prices[idx] + helper(idx+1, 0, prices, count, dp) ;
            profit = Math.max(profit, 0 + helper(idx+1,1,prices, count, dp) ) ;
        }
        else{ // when we come selling point then ooone transaction get completed so here we will reduce the count.
            profit = prices[idx] + (count > 0 ? helper(idx+1,1,prices,count-1,dp) : 0) ;
            profit = Math.max(profit, 0 + helper(idx+1,0,prices,count,dp) ) ;
        }
        
        return dp[idx][buy][count] = profit ;
        
    }


    // tabulation : converted from memoization to tabulations :

    public int maxProfit2(int[] prices) {
        // as meoization approch was running like : idx 0 to n, buy 1 -> 0 and count 2 -> 0,
        // so in tabulation approch we will traerse in reverse that is  : idx n to 0 , buy o -> 1 and count 0 > 2
        int[][][] dp = new int[prices.length+1][2][3] ;
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){ // idx.  running from n-1 becuase when idx == n  it returns 0
            for(int j = 0 ; j <= 1 ; j++){ // buy
                for(int k = 1 ; k <= 2 ; k++){ // when cap(k) = 0 then ans was also 0 so running from 1
                    
                    // using memoization recurrence
                    int profit = 0 ;
                    if(j == 1){
                        profit = -prices[i] + dp[i+1][0][k] ;
                        profit = Math.max(profit, 0 + dp[i+1][1][k]) ;
                    }
                    else{
                        profit = prices[i] + dp[i+1][1][k-1] ;
                        profit = Math.max(profit, 0 + dp[i+1][0][k]) ;
                        }
                    
                    dp[i][j][k] = profit ;
                }
            }
        }
        
        
        return dp[0][1][2];
    }



    // converting tabulations it into super space optimized solution  :

    public int maxProfit4(int[] prices) {
        
        int[][] after = new int[2][3] ; // this will hold the next array. intially it will hold dp[n][-][-]
        int[][] curr = new int[2][3] ; // this is holding current dp.
        
        for(int i = prices.length - 1 ; i >= 0 ; i--){ // idx.  running from n-1 becuase when idx == n  it returns 0
            for(int j = 0 ; j <= 1 ; j++){ // buy
                for(int k = 1 ; k <= 2 ; k++){ // when cap(k) = 0 then ans was also 0 so running from 1
                    
                    // using memoization recurrence
                    int profit = 0 ;
                    if(j == 1){
                        profit = -prices[i] + after[0][k] ;  // replacing dp[i+1] with after
                        profit = Math.max(profit, 0 + after[1][k]) ;
                    }
                    else{
                        profit = prices[i] + after[1][k-1] ;
                        profit = Math.max(profit, 0 + after[0][k]) ;
                        }
                    
                    curr[j][k] = profit ; // storing in current.
                }
            }
            after = curr ;//making current after of next
        }
        
        return curr[1][2];
    }
    
}
