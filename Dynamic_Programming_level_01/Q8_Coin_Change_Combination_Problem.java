package Dynamic_Programming_level_01;

public class Q8_Coin_Change_Combination_Problem {


    public static void main(String[] args) {
        
    }
    

    public static int coin_change_combination(int[] coins , int sum) {
       

        int[] dp = new int[sum+1] ;

        dp[0] =  1 ; // it denotes that there is one way to pay 0 rupees (which is neither give nor take).

        for (int i = 0; i < coins.length ; i++) {  // taking every element of coins.
            for (int j = coins[i] ; j < dp.length ; j++) { // and starting from the element value till the sum.

                // here checking if we pay coins[i] then dp have j - coins[i] ? whatever the value it has add it to the current dp[j].
                // for eg: we are at 2nd index and current coin is 2 so we check if we pay 2 then dp have 2-2 ? (which is 0th index and oth index has 1) so we'll add it to the current location of dp otherwise if it could have 0 then if we add 0 then it doesn't affect our answer as 0 is identity of sum.
                dp[j] += dp[j - coins[i]] ;
                
            }
        }

        return dp[sum] ; // this value is total combination of our sum.
    }
}
