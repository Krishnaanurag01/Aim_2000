package Dynamic_Programming_level_02 ;

/**
 * Q81_LCS_of_three_strings
 */
public class Q81_LCS_of_three_strings {

    public static void main(String[] args) {
        
    }

    public static void get_LCS_of_three(String s1, String s2, String s3) {
        
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1] ; // simply add one dimention in 2d array of Of LCS of 2 == LCS off 3.

        for (int i = s1.length(); i>=0; i--) {
            for (int j = s2.length(); j>=0; j--) {
                for (int k = s3.length(); k>=0; k--) {
                    
                    if(i == s1.length() || j == s2.length() || k == s3.length()){
                        dp[i][j][k] = 0 ;
                    }
                    else{
                        char c1 = s1.charAt(i) ;
                        char c2 = s2.charAt(j) ;
                        char c3 = s3.charAt(k) ;

                        if(c1 == c2 && c1 == c3){
                            dp[i][j][k] = dp[i+1][j+1][k+1] + 1 ;
                        }
                        else{
                            dp[i][j][k] = Math.max(dp[i+1][j][k], Math.max( dp[i][j+1][k] , dp[i][j][k+1]) ) ;
                        }
                    }
                }
            }
        }
    }
}