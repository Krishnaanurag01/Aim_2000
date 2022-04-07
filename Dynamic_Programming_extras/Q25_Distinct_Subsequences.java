package Dynamic_Programming_extras;

public class Q25_Distinct_Subsequences {

    // using memoization.
    public int numDistinct(String t, String s) {
     
        int lt = t.length() ; // length
        int ls = s.length() ; // length
         Integer[][] dp = new Integer[lt+1][ls+1] ;
        return helper(lt-1,ls-1,t,s,dp) ;
    }
    
    
    // static int mod = (int)1e9 + 7 ;
    static int helper(int lt, int ls, String t, String s, Integer[][] dp){
        if(ls == -1) return 1 ; // if got all char of s then return true or 1
        if(lt == -1) return  0 ; // else if not then 0
        
        if(dp[lt][ls] != null) return dp[lt][ls] ;
        
        char ch1 = t.charAt(lt) ;
        char ch2 = s.charAt(ls) ;
        int same = 0 ;
        
                   
        int diff =  helper(lt-1,ls,t,s,dp) ;
        if(ch1 == ch2){
            same = helper(lt-1,ls-1,t,s,dp) ;
        }
        
        
        return dp[lt][ls] = (same + diff) ;
    }
    

    // using tabulations: 
    // converted from memoization to tabular

    public int numDistinct2(String t, String s) {
     
        int lt = t.length() ;
        int ls = s.length() ;
         int[][] dp = new int[lt+1][ls+1] ;
        
         // when ls is -1 that is 0 col will be 1
        dp[0][0] =   1   ;  // so assigning 1
        
        for(int i = 1 ; i <= lt ; i++){
            for(int j = 0 ; j <= ls ; j++){
                if(j == 0 ) dp[i][j] = 1 ; // assigning 0 col 1.
                else{
                     char ch1 = t.charAt(i-1) ;
                     char ch2 = s.charAt(j-1) ;
                     int same = 0  ;
                         
                     int diff =  dp[i-1][j]  ;
                     if(ch1 == ch2){
                        same = dp[i-1][j-1] ;
                     }
                    dp[i][j] = same + diff ;
                }
            }
        }
        
        
        
        return dp[lt][ls] ;
    }



    // space optimized solution : 

    public int numDistinct4(String t, String s) {
     
        int lt = t.length() ;
        int ls = s.length() ;
         int[] prev = new int[ls+1] ; // holding previous row
        
        prev[0] =   1   ;
        
        for(int i = 1 ; i <= lt ; i++){
            int[] curr = new int[ls+1] ; // and also the current row
            for(int j = 0 ; j <= ls ; j++){
                if(j == 0 ) curr[j] = 1 ;
                else{
                     char ch1 = t.charAt(i-1) ;
                     char ch2 = s.charAt(j-1) ;
                     int same = 0  ;
                         
                     int diff =  prev[j]  ;
                     if(ch1 == ch2){
                        same = prev[j-1] ;
                     }
                    curr[j] = same + diff ;
                }
            }
            prev = curr ;
        }
        
        
        
        return prev[ls] ;
    }


    // super space optimized solution : 

    public int numDistinct5(String t, String s) {
    
        int lt = t.length() ;
        int ls = s.length() ;
        int[] prev = new int[ls+1] ; // we will store and override value
        prev[0] = 1 ; // base case
        
        for(int i = 1 ; i <= lt ; i++){
            for(int j = ls ; j >= 0 ; j--){
                if(j == 0 ) prev[j] = 1 ; // base case
                else{                       
                    if(t.charAt(i-1) == s.charAt(j-1)) // checking sum when both chr same becuase not same is already stored in the prev array
                    prev[j] = Math.max(prev[j], prev[j] + prev[j-1]) ;
        }}}
  
        return prev[ls] ;
    }
}
