package Dynamic_Programming_level_02;

public class Q92_BBT_counter {
    
    public static void main(String[] args) {
     
        System.out.println( get_total_bbt(3));
    }

    // recursive solution 
    // time : O(2^n)
    public static int get_total_bbt(int h) {
        
        if( h == 0 || h == 1){ // when the height of binary tree is 1 then it's already balanced so return 1.
            return 1 ;
        }

        return get_total_bbt(h-1)*(2*get_total_bbt(h-2)+get_total_bbt(h-1)) ; // it's the formula , check the copy or better read gfg article. 
    }

    // using dp : 

    public static long get_count(int h ) {
        
        long[] dp = new long[h+1] ;

        int mod = 1000000007 ;
        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = ( dp[i-1] * (2*dp[i-2] % mod + dp[i-1]) % mod ) % mod ;
        }

        return dp[h] ;
    }
}
