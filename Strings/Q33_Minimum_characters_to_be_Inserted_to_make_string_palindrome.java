package Strings;


// answer = string.length() - longest palindromic sub sequences . as left characters in string needs one more part.
public class Q33_Minimum_characters_to_be_Inserted_to_make_string_palindrome {
    public static void main(String[] args) {
        System.out.println(getMinNumberOfInsertion("abcd"));
    }
    public static int getMinNumberOfInsertion(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int g = 0; g < s.length() ; g++) {
            
           for (int i = 0 , j = g ; j < s.length() ; i++, j++) {
               
               if(g == 0){
                   dp[i][j]= 1 ; 
               }
               else if( g == 1 ){
                   dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
               }
               else{
                   if (s.charAt(i)== s.charAt(j)) {
                       dp[i][j] = 2 + dp[i+1][j-1] ;
                   }
                   else{
                       dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1]);
                   }
               }
           }
        }

        int lps  = dp[0][s.length()-1];

        return s.length() - lps ;
    }
}
