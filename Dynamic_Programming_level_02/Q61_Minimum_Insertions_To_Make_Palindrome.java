package Dynamic_Programming_level_02;

public class Q61_Minimum_Insertions_To_Make_Palindrome {

    public static void main(String[] args) {
        
    }

    public static int get_min_insertion_for_palindrome(String s) {

        // simply find the longest palindromic subsequence (LPS) and subtract it from s.length ;

        int[][] dp = new int[s.length()][s.length()] ;

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0 , j = g ; j < dp.length; i++ , j++) {
                if(g==0){
                    dp[i][j] = 1 ;
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2 ;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);
                    }
                }
            }
        }

        return  s.length() - dp[0][s.length() - 1 ]  ; // this means some part of s which is palindrome are removed and the rest left is non palindrome so we have to add same rest to make it palindrome.
        
    }

    // same concept apply if asked , minimum deletion to make string palindrome
    
}
