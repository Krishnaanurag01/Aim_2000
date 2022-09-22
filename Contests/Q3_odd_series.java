package Contests;

public class Q3_odd_series {

    public int findNth(int n){
       
        long[] dp = new long[n+5] ;
        
        dp[0] = 0 ;
        dp[1] = 1 ;
        int mod = (int)1e9+7 ;
        
        for(int i = 2 ; i <= n ; i++){
            if( i % 5 != 0){
                dp[i] = (dp[i-1] + dp[i-2]) % mod ;
            }
            else{
                dp[i] = 11 ;
            }
        }
        
        return (int)dp[n] % mod ;
    }
}
