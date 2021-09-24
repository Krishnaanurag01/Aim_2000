package Dynamic_Programming_level_01;

import java.util.*;

public class Q9_Coin_Change_Permutations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        
        int n = sc.nextInt();
        int[] coins = new int[n] ;
        
        for(int i = 0 ; i< n ; i++){
            coins[i] = sc.nextInt();
        }
        
        int sum = sc.nextInt();

        System.out.println(getPermuationOfCoinChange(coins, sum));
        sc.close();
        
    }

    public static int getPermuationOfCoinChange(int[] coins , int sum) {

        int[] dp = new int[sum+1] ;  // making dp of sum + 1 becuase we want to store value of sum as well.
        dp[0] = 1 ;

        for (int i = 0; i < dp.length; i++) { 
            for (int coin : coins) {   // for each sum ( i ) we are checking if coin is less than or equal to sum then we add to current sum dp.
                
                if(i>= coin){

                    dp[i] += dp[i-coin] ;
                }


            }
        }

        return dp[sum] ; // this will store the total permutation of sum . permutation means number of way we can pay this sum. overlapping allowed.
        
    }
    
}
