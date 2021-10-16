package Dynamic_Programming_level_02;

public class Q1_Coin_ChangeProblem {

    public static void main(String[] args) {
        
    }

    public static int get_total_ways(int[] coins , int sum) {  // combination
        
        int[] dp = new int[sum+1] ;
        dp[0] = 1 ;

        for(int i = 0 ; i < coins.length ; i++){
            for (int j = coins[i] ; j < dp.length; j++) {
                
                dp[j] += dp[j-coins[i]];

            }
        }

        return dp[sum];
    }
    
}
