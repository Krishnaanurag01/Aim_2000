package Dynamic_Programming_level_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q18_Nth_catalan_number {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        System.out.println(nth_catalan(br.read() - '0' ));
    }

    public static int nth_catalan(int n ) {
        
        int[] dp = new int[n+1] ;

        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2 ; i < dp.length ; i++) {
            
            int left = 0 ;
            int right = i-1 ;

            while(left < i){
                dp[i] += dp[left] * dp[right] ;
                left++ ;
                right-- ;
            }
        }

        return dp[n] ;
    }
    
}
