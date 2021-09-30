package Dynamic_Programming_level_01;

import java.util.Scanner;

public class Q4_Climbing_Stairs_with_Jumps {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] jumps = new int[n] ;

        for (int i = 0; i < jumps.length; i++) {
            jumps[i] = sc.nextInt() ;
        }

        System.out.println( climbing_stairs_with_jump(jumps, n) );

        sc.close();
        
    }

    public static int climbing_stairs_with_jump(int[] jumps , int n ) {
        int[] dp = new int[n + 1] ; // for storing data.

        dp[n] = 1 ; // as we have to go to the nth stair , so dp[n] = 1 .

        for (int i = n-1 ; i >= 0 ; i--) { // we'll start from last as min number of stairs takes to reach at the nth stair.
            for (int j = 0; j <= jumps[i] && i+j < dp.length ; j++) { // look for given array about where can we jump from current location and the location ( i + j ) should be under dp region. (o\w give out of bound error)
                dp[i] +=  dp[i+j] ; // storing total ways to reach end.
            }
        }

        return dp[0] ; // print the number of different paths via which you can climb to the top.
    }
    
}
