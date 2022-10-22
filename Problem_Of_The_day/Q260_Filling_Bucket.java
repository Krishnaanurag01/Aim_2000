package Problem_Of_The_day;

public class Q260_Filling_Bucket {

    static int fillingBucket(int N) {
        if(N == 0) return 0 ;
        if(N == 1) return 1 ;
        if(N == 2) return 2 ;  
        
        int[] dp = new int[N+1] ;
        dp[0] = 0 ;
        dp[1] = 1 ;
        dp[2] = 2 ;
        
        int mod = (int)1e8 ;
        
        for(int i = 3 ; i <= N ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % mod ;
        }
        
        return dp[N] ;
    }


    static int fillingBucket_(int N) {
        if(N == 0) return 0 ;
        if(N == 1) return 1 ;
        if(N == 2) return 2 ;  
        
     // int[] dp = new int[N+1] ; 
     // as it needs only previous two values so we don't have to use dp array instead use only two variables.
        int n_minus_two = 1 ; // this is initially of N = 1
        int n_minus_one = 2 ; // this is initially of N = 2
        
        int mod = (int)1e8 ;
        
        for(int i = 3 ; i <= N ; i++){
            int temp = (n_minus_one + n_minus_two) % mod ; // adding n-1 and n-2
            n_minus_two = n_minus_one ; // prev n-1 becomes n-2
            n_minus_one = temp ; // and curr value becomes n-1
        }
        
        
        return n_minus_one ;
    }
}
