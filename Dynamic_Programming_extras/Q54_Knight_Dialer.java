package Dynamic_Programming_extras;

public class Q54_Knight_Dialer {

    static Long[][] dp  ;
    static int mod = (int)1e9+7 ;
    
    public int knightDialer(int n) {
         dp = new Long[n+1][12] ;
        return (int)((long)helper(n,-1))  ;
        // return 0 ;    }
    }
    
    Long helper(int n, int initial){
        
        if(n == 0) return  0L ;
        
        if(dp[n][initial+1] != null) return dp[n][initial+1] ;
        
        Long count = 0L ;
        if(initial == -1){
        
            for(int i = 0 ; i < 10 ; i++){
            
                switch(i) {
                    case 0 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,4) + 1*helper(n-1,6) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 1 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,8) + 1*helper(n-1,6))%mod : 1) ) % mod ;
                    break ;
                
                    case 2 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,7) + 1*helper(n-1,9))%mod : 1) ) % mod;
                    break ;
                
                    case 3 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,4) + 1*helper(n-1,8))%mod : 1) ) % mod ;
                    break ;
                
                    case 4 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,3) + 1*helper(n-1,9) + helper(n-1,0) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 5 : 
                    count = ( count + (n-1 > 0 ? 0 : 1) ) % mod ;
                    break ;
                
                    case 6 : 
                    count = ( count + (n-1 > 0 ?  (1*helper(n-1,7) + 1*helper(n-1,1) + helper(n-1,0) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 7 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,2) + 1*helper(n-1,6) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 8 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,1) + 1*helper(n-1,3) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 9 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,4) + 1*helper(n-1,2) ) % mod : 1) ) % mod ;
                    break ;
                
                    default :
                    break ;
                }
            }
        }
        else{
            
            switch(initial) {
                     case 0 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,4) + 1*helper(n-1,6) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 1 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,8) + 1*helper(n-1,6))%mod : 1) ) % mod ;
                    break ;
                
                    case 2 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,7) + 1*helper(n-1,9))%mod : 1) ) % mod;
                    break ;
                
                    case 3 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,4) + 1*helper(n-1,8))%mod : 1) ) % mod ;
                    break ;
                
                    case 4 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,3) + 1*helper(n-1,9) + helper(n-1,0) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 5 : 
                    count = ( count + (n-1 > 0 ? 0 : 1) ) % mod ;
                    break ;
                
                    case 6 : 
                    count = ( count + (n-1 > 0 ?  (1*helper(n-1,7) + 1*helper(n-1,1) + helper(n-1,0) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 7 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,2) + 1*helper(n-1,6) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 8 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,1) + 1*helper(n-1,3) ) % mod : 1) ) % mod ;
                    break ;
                
                    case 9 : 
                    count = ( count + (n-1 > 0 ? ( 1*helper(n-1,4) + 1*helper(n-1,2) ) % mod : 1) ) % mod ;
                    break ;
                
                    default :
                    break ;
            }
        }
        
        return dp[n][initial+1] = count % mod ;
    }
    
}
