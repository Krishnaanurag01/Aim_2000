package Dynamic_Programming_extras;

public class Q17_Coin_Change_2 {

    // using memoization.
    public int change(int amount, int[] coins) {

        Integer[][] dp = new Integer[coins.length][amount + 1]; ///
        return helper(coins.length - 1, coins, amount, dp);
    }

    static int helper(int idx, int[] coins, int x, Integer[][] dp) {
        if (x == 0)
            return 1; // if got all coins then return 1
        if (idx == 0) {
            if (x % coins[idx] == 0)
                return 1; // if 1st index coin can complete the remainning amount then return 1
            return 0; // else 0
        }

        if (dp[idx][x] != null)
            return dp[idx][x];

        int notTook = helper(idx - 1, coins, x, dp); // not taking current coin
        int took = 0;
        if (coins[idx] <= x) {
            took = helper(idx, coins, x - coins[idx], dp); // taking current coin and aagin calling this funtion with
                                                           // same index.
        }

        return dp[idx][x] = notTook + took; // return total count.
    }

    // tabulation :

    public int change2(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        dp[0][0] = 0; // 0 amt is made in 1 way.
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = 1; // if first coin alone can made j amount then 1
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {

                int notTook = dp[i - 1][j];
                int took = 0;
                if (coins[i] <= j) {
                    took = dp[i][j - coins[i]];
                }
                dp[i][j] = notTook + took;

            }
        }

        return dp[coins.length - 1][amount];
    }

    

    // space optimization : 
    public int change3(int amount, int[] coins) {
        
        int[] dp = new int[amount+1] ;
        
        dp[0] = 0 ; // 0 amt is made in 1 way.
        for(int j = 0 ; j <= amount ; j++){
            if(j % coins[0] == 0) dp[j] = 1 ;
        }
        
        for(int i = 1 ; i < coins.length ; i++){
            int[] curr = new int[amount + 1] ;
            for(int j = 0 ; j <= amount ; j++){
            
        int notTook = dp[j] ;
        int took = 0 ;
        if(coins[i] <= j){
            took = curr[ j - coins[i]] ;
        }
            curr[j] = notTook + took ;
                
            }
            dp = curr ;
        }
        
        
        return dp[amount] ;
    }
}
