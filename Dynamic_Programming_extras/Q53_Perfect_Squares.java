package Dynamic_Programming_extras;

public class Q53_Perfect_Squares {

    static Integer[] dp ;
    public int numSquares(int n) {
        dp = new Integer[n+1] ;
        return helper(n) ;
    }
    
    static int helper(int n){
        
        if(n <= 1) return n ;
        
        if(dp[n] != null) return dp[n] ;
        int min = (int)1e9 ;
        
        for(int i = 1 ; i*i <= n ; i++ ){
            int count = 1 + helper(n - (i*i) );
            min = Math.min(min,count) ;
        }
        
        return dp[n] = min ;
    }
}
