package Dynamic_Programming_level_02;

public class Q24_Dyck_Path {
    

    // using catalan numbers method.  // think of this question as if counting valleys and mountain is rotated a bit.
    static Long dyckPaths(int N) {
        
        long[] dp = new long[N+1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        
        for(int i = 2 ; i <= N ; i++){
            
            int l = i-1 ;
            int r = 0 ;
            
            while(l >= 0){
                dp[i] += dp[l]*dp[r] ;
                l-- ;
                r++;
            }
        }
        
        return dp[N]; 
    }
}
