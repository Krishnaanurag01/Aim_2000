package Problem_Of_The_day;

public class Q86_Shortest_uncommon_subsequence {
    
    static Integer[][] dp; 
    static int shortestUnSub(String S, String T) {
       
       dp = new Integer[S.length()][T.length()] ;
       int ans = helper(0,0,S,T) ;
       return ans == 501 ? -1 : ans ;
    }
    
    static int helper(int idx1, int idx2, String s, String t){
        
        if(idx1 == s.length()) return 501 ; // we reach to this index only when not any single character is uncommon
        if(idx2 == t.length()) return 1 ; // if we reach this then we can return 1 becuase we want shorter answer although we can return rest of the chart of T string if asked for largest uncommon
        
        if(dp[idx1][idx2] != null) return dp[idx1][idx2] ;
        
        int k = 0 ;  // check if idx1 char is present or not
        for( k = idx2 ; k < t.length() ; k++){ 
            if(t.charAt(k) == s.charAt(idx1)) break;
        }
        
        // if k reached to last then it mean idx1 char is not present hence returning 1 as 1 char subseq is smallest uncommon
        if(k == t.length() ) return dp[idx1][idx2] =  1 ; // means we did not even get one char matched.
        
        int np = helper(idx1+1,idx2,s,t) ; // we can either move to next char in S
        int p = 1 + helper(idx1+1,k+1,s,t) ; // or consider current char and move with both +1 idx (means we are looking into substring of this both strings for uncommonity).
        
        return dp[idx1][idx2] = Math.min(np,p) ; // returning min ans.
    }
}
