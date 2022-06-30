package Problem_Of_The_day;

public class Q72_Number_of_ways {

    static long arrangeTiles(int N){
        if(N <= 3) return 1 ;
        long[] dp = new long[N+1] ;
        dp[0] = dp[1] = dp[2] = dp[3] = 1 ;
        
        for(int i = 4 ; i <= N ; i++){
            dp[i] = dp[i-1] + dp[i-4] ;
        }
        
        return dp[N] ;
    }
}
