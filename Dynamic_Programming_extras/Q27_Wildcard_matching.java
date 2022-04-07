package Dynamic_Programming_extras;

public class Q27_Wildcard_matching {
    
    public boolean isMatch(String s, String p) {
        
        Boolean[][] dp = new Boolean[s.length()][p.length()] ;
        return helper(s.length() - 1, p.length() - 1, s, p ,dp) ;
    }
    
    static boolean helper(int si, int pi, String s, String p, Boolean[][] dp){
        
        /// ********   base cases *******
        if(si == -1 && pi == -1) return true ; // if both string over then true
        
        if(si == -1 && pi >= 0){ // if text become empty and pattern is not then pattern must be * at every char then it will transform to empty char and becomes equal to empty string text.    
            for(int i = 0 ; i <= pi ; i++)  
                if(p.charAt(i) != '*') return false ; // if not * then return false;
            return true ; // otherwise true
        }
        
        if(pi == -1) return false ; // if pattern is over but text is not then false;
        
        // **********
        
        if(dp[si][pi] != null) return dp[si][pi] ;      
        
        
        char ch1 = s.charAt(si);  
        char ch2 = p.charAt(pi);
        
        if(ch1 == ch2 || ch2 == '?'){ // if both char equal or pattern char is '?' then look for -1 index
            return dp[si][pi] = helper(si-1,pi-1,s,p,dp) ;
        }
        
        if(ch2 == '*'){ // if * then look with considering * as empty or * as 1 char.
            return dp[si][pi] = helper(si,pi-1,s,p,dp) || helper(si-1,pi,s,p,dp) ;
        }
        
        return dp[si][pi] = false ; // return false if both char is not same

    }

    // tabulations : converted memoization into tabulation : 

    public boolean isMatch2(String s, String p) {
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1] ;
        dp[0][0] = true ;
        for(int j = 1 ; j <= p.length() ; j++){ // this is handling the case when s : "" and p : "*******"
            if(p.charAt(j-1) == '*' && dp[0][j-1] == true)
                dp[0][j] = true ;
        }
        
        for(int i = 1; i <= s.length() ; i++){
            for(int j = 0; j <= p.length() ; j++){
                if(j == 0) dp[i][j] = false ;  // handling the case when p : " " and s >= 0
                else{ // using same memo recurrence.
                    char ch1 = s.charAt(i-1);  
                    char ch2 = p.charAt(j-1);
        
                    if(ch1 == ch2 || ch2 == '?'){ // if both char equal or pattern char is '?' then look for -1 index
                         dp[i][j] = dp[i-1][j-1];
                        continue ;
                    }
        
                    if(ch2 == '*'){ // if * then look with considering * as empty or * as 1 char.
                         dp[i][j] = dp[i][j-1] || dp[i-1][j] ;
                       continue ;
                     }
                     dp[i][j] = false ; // return false if both char is not same
        }}}
        return dp[s.length()][p.length()];
    }


    // space optimized tabulation :

    public boolean isMatch3(String s, String p) {
        
        boolean[] prev = new boolean[p.length()+1] ; // prev row data
        prev[0] = true ;
        for(int j = 1 ; j <= p.length() ; j++){
            if(p.charAt(j-1) == '*' && prev[j-1] == true)
                prev[j] = true ;
        }
        
        for(int i = 1; i <= s.length() ; i++){
            boolean[] curr = new boolean[p.length()+1] ; // current row data
            for(int j = 0; j <= p.length() ; j++){
                if(j == 0) curr[j] = false ;
                else{
                    char ch1 = s.charAt(i-1);  
                    char ch2 = p.charAt(j-1);
        
                    if(ch1 == ch2 || ch2 == '?'){ // if both char equal or pattern char is '?' then look for -1 index
                         curr[j] = prev[j-1];
                        continue ;
                    }
        
                    if(ch2 == '*'){ // if * then look with considering * as empty or * as 1 char.
                         curr[j] = curr[j-1] || prev[j] ;
                       continue ;
                     }
                     curr[j] = false ; // return false if both char is not same
        }}
        prev = curr ;
        }
        return prev[p.length()];
    }

}
