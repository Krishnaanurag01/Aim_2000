package Dynamic_Programming_level_02;

public class Q22_Circle_And_Chords {

    public static void main(String[] args) {
        
    }
    

    // You have to find the number of ways in which these chords can be drawn.
    // again  catalan logic.
    public static int get_total_ways(int n) {
        
        int[] dp = new int[n+1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2; i < dp.length; i++) {
            int l = 0 ;
            int r = i-1 ;
            while (l <= i-1) {
                dp[i] += dp[l]*dp[r] ;
                l++ ;
                r-- ;
            }
        }

        return dp[n] ;
    }
}
