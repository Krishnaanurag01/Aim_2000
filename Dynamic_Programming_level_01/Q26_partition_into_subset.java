package Dynamic_Programming_level_01;

import java.util.Scanner;

/**
 * Q26_partition_into_subset
 */
public class Q26_partition_into_subset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ; // n denotes number of peoples
        int k = sc.nextInt() ; // k denotes teams

        // now we have to partition n peoples into k teams.
        System.out.println( partitionKSubset(n, k) );

        sc.close();
        
    }

    public static long partitionKSubset(int n, int k) {
      
        if(n == 0 || k == 0 || n < k){  // when 0 people or when team is 0 or when peoples is less and we have to partition into larger teams then return 0.
            return 0 ;
        }
     
     long[][] dp = new long[k+1][n+1] ;
     
     for(int t = 1 ; t < dp.length ; t++){ // now t is teams
         for(int p = 1 ;p< dp[0].length ; p++ ){ // now p is peoples
             
             if(t > p){ // same logic when people is less than team then 0
                 dp[t][p] = 0 ;
             }
             else if(t == p){ // when teams == peoples then 1. eg.  2 team and 2 peoples then total partion is 1.
                 dp[t][p] = 1 ;
             }
             else{
             dp[t][p] = dp[t][p-1] * t + dp[t-1][p-1] ; // else search that people - 1 with same team outcome into teams( dp[t][p-1] * t) + dp[t-1][p-1] ( peoples with -1 and -1 teams)
         }
         }
         
     }
     
     return dp[dp.length-1][dp[0].length-1];
     
    }
}