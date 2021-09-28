package Dynamic_Programming_level_02;

public class Q21_count_brackets {

    public static void main(String[] args) {
        
    }

    // same as previous question and same as catalan number,check copy for better explanation.
    public static int get_count_brackets(int n) {
        
        int[] dp = new int[n+1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2 ; i < dp.length; i++) {
            
            int inside = i-1 ;
            int outside = 0 ;

            while (inside >= 0 ) {
                
                dp[i] += dp[inside]*dp[outside] ;

                inside-- ;
                outside++;
            }
        }

        return dp[n] ;
    }
    
}
