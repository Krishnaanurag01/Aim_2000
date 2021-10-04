package Dynamic_Programming_level_02;

public class Q31_Longest_Common_Subsequence {

    public static void main(String[] args) {
        
    }

    public static int get_lcs(String s1 , String s2) {
        
        int[][] dp = new int[s1.length()+1][s2.length()+1] ;

        for (int i = s1.length() - 2 ; i >= 0 ; i--) { // starting from last row -1 
            for (int j = s2.length()-2; j >= 0 ; j--) { // last column -1
                
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j) ;

                if(c1 == c2){ // when both char is same then go diagonally take value and add 1 with it.
                    dp[i][j] = 1 + dp[i+1][j+1] ; 
                }
                else{ // else look right and below ,find max and store.
                    dp[i][j]  = Math.max(dp[i+1][j], dp[i][j+1]) ;
                }

            }
        }

        return dp[0][0] ;
    }
    
}
