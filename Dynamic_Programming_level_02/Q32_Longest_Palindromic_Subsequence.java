package Dynamic_Programming_level_02;

public class Q32_Longest_Palindromic_Subsequence {

    public static void main(String[] args) {
        
    }
    

    public static int get_longest_palindromic_sub_length(String s) {
        
        int[][] dp = new int[s.length()][s.length()] ;

        for (int g = 0; g < dp.length; g++) { // using gap technique.
            for (int i = 0 , j = g ; j < dp.length; i++ , j++) {
                
                if(g==0){ // when gap is 0 then store 1 as a character itself is palindrome.
                    dp[i][j] = 1 ;
                }
                else if(g==1){ // when gap is 1 then check if both char is same then 2 else store 1 ( eg. bb = 2 , ab = 1).
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1 ;
                }
                else{  // else check if both char is same then
                    if(s.charAt(i) == s.charAt(j)){ // if same then add 2 for current char + diagonal number.
                        dp[i][j] = 2 + dp[i+1][j-1] ;
                    }
                    else{ // else store max of left and below .
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]) ;
                    }
                }
            }
        }

        return dp[0][s.length()-1] ;
    }
}
