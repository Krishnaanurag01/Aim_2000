package Dynamic_Programming_extras ;

/**
 * Q22_Longest_Palindromic_subseq
 */
public class Q22_Longest_Palindromic_subseq {


    // using memoization.
    public int longestPalindromeSubseq(String s) {
        
        Integer[][] dp = new Integer[s.length()][s.length()] ; 
        return helper(0,s.length()-1,s,dp) ;
    }
    // using start index and end index.
    static int helper(int si, int ei, String s, Integer[][] dp){
        
        if(si > ei) return 0 ; // out of bound
        if(si == ei) return 1 ;
        
        if(dp[si][ei] != null) return dp[si][ei] ;
    
        if(s.charAt(si) == s.charAt(ei)){ // if both same then return directly
           return dp[si][ei] = 2 + helper(si+1,ei-1,s,dp) ;
        }
        
        int leftRemoving = 0 + helper(si+1,ei,s,dp);
        int rightRemoving = 0 + helper(si,ei-1,s,dp);

        return dp[si][ei] = Math.max( leftRemoving, rightRemoving)  ;
    }


    // solved using gap strategy in level 2 that is also very good soltuion.


    // using lcs solution : 


    public int longestPalindromeSubseq4(String s) {
        
        // simply find the lcs of string and its reverse.
        return lcs4(s, new StringBuilder(s).reverse().toString()) ;
     }
     
     public static int lcs4(String s, String t) {
         
         int[] prev = new int[t.length()+1] ;  // this will hold the prev row data.
         
         for(int i = 1 ; i <= s.length() ; i++){
         int[] curr = new int[t.length()+1] ;  // this will store the current row data.
             for(int j = 1 ; j <= t.length() ; j++){
                 
                 char ch1 = s.charAt(i-1) ;    
                 char ch2 = t.charAt(j-1) ;
 
                 int notTookS = 0 + curr[j-1] ;  // previous row.col-1 data
                 int notTookt = 0 + prev[j] ; // previous row same col data
         
                 int took = 0 ;
                 if(ch1 == ch2){
                     took = 1 + prev[j - 1]  ; 
                 }
                 
                 curr[j] = Math.max(notTookS, Math.max(notTookt,took)) ;
             }
             prev = curr ;
         }
         
         
         
       return prev[t.length()] ;
     }

}