package Dynamic_Programming_extras;

public class Q48_Friends_Pairing_Problem {

    public long countFriendsPairings(int n) 
    { 
        Long[] dp = new Long[n+1] ;
       return helper(n,dp) ;
    }
    
    static int mod = (int)1e9+7 ;
    static long helper(int friends, Long[] dp){
        
        if(friends <= 2 ) return friends ;
        
        if(dp[friends] != null) return dp[friends] ;
        
        long single = helper(friends-1,dp) ;  /// he can remain single 
        long pairUp = (friends-1)*helper(friends-2,dp) ; // he can pair up with n-1 friends.*no of ways rest people get paired.
        long total = (single + pairUp) % mod ;
        
        return dp[friends] = total ;
    }
    
}
