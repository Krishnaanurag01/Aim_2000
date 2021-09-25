package Dynamic_Programming_level_02;

public class Q3_Binomial_CoefficientProblem {

    public static void main(String[] args) {
        
    }
    

    public static int get_ncr(int n , int r) {

        if(n < r) return 0 ;
        if((n-r) < r) {
            r = n-r ;
        }

        int mod = 1000000007 ;

        int[] dp = new int[r+1];
        dp[0] = 1 ;

        for(int i = 1; i <= n ; i++){
            for(int j = dp.length-1 ; j > 0 ; j--){
                dp[j] = (dp[j]+dp[j-1])%mod ;
            }
        }
     
        return dp[r] ;
    }
}
