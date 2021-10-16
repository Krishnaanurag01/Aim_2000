package Dynamic_Programming_level_02;

import java.util.Scanner;

public class Q20_Counting_Valleys_And_Mountains {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        System.out.println(count_valleys(n));

        sc.close(); 
        
    }

    // ditto same as catalan number.

    public static int count_valleys(int n) {
        
        int[] dp = new int[n+1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2; i < dp.length; i++) {
            
            int inside = i - 1 ;
            int outside = 0 ;

            while (inside >= 0) {
                dp[i] += dp[inside]*dp[outside] ;

                inside-- ;
                outside++ ;
            }
        }

        return dp[n] ;
    }
    
}
