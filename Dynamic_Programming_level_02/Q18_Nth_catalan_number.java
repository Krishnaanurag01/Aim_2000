package Dynamic_Programming_level_02;


public class Q18_Nth_catalan_number {

    public static void main(String[] args) {
        System.out.println(nth_catalan(5));
    }

    public static int nth_catalan(int n ) {
        
        int[] dp = new int[n+1] ;

        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2 ; i < dp.length ; i++) {
            
            for (int j = 0 ; j < i ; j++) {
                
                dp[i] += dp[j] * dp[i-j -1] ;
            }
        }

        return dp[n] ;
    }
    
}
