package Dynamic_Programming_level_01;

public class Q25_Friends_Pairing_Problem {

    public static void main(String[] args) {
        
    }

    public static long get_total_ways(int n ) {
        
        if( n <= 1) return n ; // when n is less than equal to n then return.
        long[] dp = new long[n+1] ; 
        dp[1] =  1 ; // dp[1] denotes total no of ways 1 friend can pair up
        dp[2] = 2 ; // same for dp[2]. 2 means either solo or 1 pair so total ways 2.
        int mod = 1000000007 ;
        
        for(int i = 3 ; i <=n ; i++){ // now 3 to  n
        dp[i] = (dp[i-1] + (dp[i-2] * (i-1))%mod)%mod ; // dp[i-1] denotes (eg:1234) 1 is alone so bring 234 total pairs and dp[i-2] denotes 12 is pair so bring 34 total ways or 13 pair or 14 pair so all these 3 pair gives same output so directly multiplying with i-1 (which denotes total possible pair).   
        }
        
        return dp[n] ; // return answer.
    }
    
}
