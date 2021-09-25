package Dynamic_Programming_level_02;

public class Q_Friends_Pairing_Problem {


    public static void main(String[] args) {
        
    }

    public static long  get_total_pairs(int n) {

        if(n <= 2) return n ;
        
        long[] dp = new long[n+1] ;

        dp[1] = 1 ;  // this means when string is of 1 length then it can be divided into only 1 way. thats same
        dp[2] = 2 ;   /// this means when string is of 2 len then it can be divided into 2 parts. eb . ab -> a,b
        int mod = 1000000007 ;

        for( int i = 3 ; i <= n ; i++ ){
            dp[i] = ( dp[i-1] + ( dp[i-2] * (i-1) ) % mod ) % mod ; // dp[i-1] means eg. abcd asking bcd for its total ways and dp[i-2] means if ab stays then asking cd for its result and i-2 means we can divide abcd in i-2 ways that is cd,bd,bc so isted of asking same length of pair i-1 times so its better to multiply the result with i-1 .
        }


        return (dp[n])%mod ;
    }
    
}
