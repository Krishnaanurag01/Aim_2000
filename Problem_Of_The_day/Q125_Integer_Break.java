package Problem_Of_The_day ;
public class Q125_Integer_Break {
    
    Integer[] dp ;
    public int integerBreak(int n) {
        if(n <= 2) return 1 ;
        dp = new Integer[n+1] ;
        int max = 0 ;
        
        for(int i = 1 ; i < n ; i++){ // here running till n-1 only because we must break the n into atleast two positive integer i.e if we go till n then n-n gives 0 and 0 is not positive integer.
            int temp = i*helper(n-i) ;
            max = Math.max(max,temp) ;
        }
        
        return max ;
    }
    
    int helper(int n){
        if(n <= 1) return 1;
        if(dp[n] != null) return dp[n] ;
        
        int max = 0 ;
        
        for(int i = 1 ; i <= n ; i++){ // and here we can go till n becuase we already fulfilled the requirement of k >= 2
            int temp = i*helper(n-i) ;
            max = Math.max(max,temp) ;
        }
        
        return dp[n] = max ;
    }
}
