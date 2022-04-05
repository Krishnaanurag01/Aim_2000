package Dynamic_Programming_extras;

public class Q21_Longest_Common_Substring {

    static int longestCommonSubstr(String S1, String S2, int n, int m){
       
        int[][] dp = new int[n+1][m+1] ;
        int longest = 0 ;
        
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1] ; 
                    longest = Math.max(longest,dp[i][j]) ;
                }
            }
            
        }
        return longest ;
    }

    // space optimized.

    int longestCommonSubstr2(String S1, String S2, int n, int m){
        // code here
        
        int[] prev = new int[m+1] ; // holding only a previous row
        int longest = 0 ;
        
        for(int i = 1 ; i <= n ; i++){
            int[] curr = new int[m+1] ;  
            for(int j = 1 ; j <= m ; j++){
                
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1] ;
                    longest = Math.max(longest,curr[j]) ;
                }
            }
            prev = curr ;
        }
        return longest ;
    }
    
}
