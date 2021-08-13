package Strings;

import java.util.HashMap;

public class Q8_Longest_Repeating_Subsequence {
    public static void main(String[] args) {
        System.out.println(longestRepeatingSubsequence("axxxy"));
    }
    public static int longestRepeatingSubsequence(String s) {

      int[][] dp = new int[s.length()+1][s.length()+1];

      for (int i = 1; i <= s.length(); i++) {
          for (int j = 1; j <=s.length(); j++) {
              if(s.charAt(i-1) == s.charAt(j-1) && i!=j){
                  dp[i][j] = dp[i-1][j-1] + 1;
              }
              else{
                  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
              }
          }
      }


        return dp[s.length()][s.length()];
    }
}
