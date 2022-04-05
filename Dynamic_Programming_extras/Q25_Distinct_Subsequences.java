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
    
}
