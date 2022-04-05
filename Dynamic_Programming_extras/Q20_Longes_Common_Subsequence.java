package Dynamic_Programming_extras;

public class Q20_Longes_Common_Subsequence {


    // memoization.
    public static int lcs(String s, String t) {
		
      Integer[][] dp = new Integer[s.length()+1][t.length()+1] ;  // 
      return helper(s.length()-1, t.length() -1 ,s , t,dp) ;
    }
    
    static int helper(int idx1, int idx2, String s, String t,Integer[][] dp){
        
        if(idx1 < 0 || idx2 < 0) return 0 ; // if out of bound return 0
        
        if(idx1 == 0 || idx2 == 0){     // when reached last check whether same or not. if yes return 1 else 0
            return s.charAt(idx1) == t.charAt(idx2) ? 1 : 0  ;
        }
        
        if(dp[idx1][idx2] != null) return dp[idx1][idx2] ; // returning already solved subproblems.
        
        char ch1 = s.charAt(idx1) ;
        char ch2 = t.charAt(idx2) ;
        
        int notTookS = 0 + helper(idx1,idx2-1,s,t,dp) ;  
        int notTookt = 0 + helper(idx1-1,idx2,s,t,dp) ;
        
        int took = 0 ;
        if(ch1 == ch2){  // when both char same then 1 + fun with 1 less index
            took = 1 + helper(idx1-1,idx2 - 1, s, t,dp) ;
        }
        
        return dp[idx1][idx2] = Math.max(notTookS, Math.max(notTookt,took)) ;
        
    }


    // tabulation  : 
     
    public static int lcs2(String s, String t) {
		//Your code goes here
        int[][] dp = new int[s.length()+1][t.length()+1] ;
        
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                
                char ch1 = s.charAt(i-1) ;
                char ch2 = t.charAt(j-1) ;

                int notTookS = 0 + dp[i][j-1] ;
                int notTookt = 0 + dp[i-1][j] ;
        
                int took = 0 ;
                if(ch1 == ch2){
                    took = 1 + dp[i-1][j - 1]  ;
                }
                
                dp[i][j] = Math.max(notTookS, Math.max(notTookt,took)) ;
            }
        }
        
        
        
      return dp[s.length()][t.length()] ;
    }


    // space optimized solution : 

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
