package Strings;

public class Q29_Find_the_longest_common_subsequence_between_two_strings {
    public static void main(String[] args) {
        System.out.println(getLCS(6, 6,  "ABCDGH" ,"AEDFHR"));
    }

    public static int getLCS(int x , int y , String s1 , String s2) {
        
        int dp[][] = new int[s1.length() + 1 ][s2.length() + 1];
        for (int i = dp.length - 2 ; i >=0 ; i--) {
            for (int j = dp[0].length - 2 ; j >=0 ; j--){

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 +  dp[i + 1][j + 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }


}
