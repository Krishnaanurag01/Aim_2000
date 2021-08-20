package Strings;

public class Q37_Wildcard_string_matching {
    public static void main(String[] args) {
         System.out.println(wildCardMathching("*a*b" , "adceb"));
    }

    public static boolean wildCardMathching(String wild, String pattern) {

        boolean[][] dp = new boolean[wild.length() + 1 ][pattern.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // last row && last col should be true.

                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) { // last row should be false except last row && last col.
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    // last col also is false except right most and bottom element.
                    if (wild.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (wild.charAt(i) == '?') {
                        // checks diagonally
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (wild.charAt(i) == '*') {
                        // if previouse element have true .
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    } else if (wild.charAt(i) == pattern.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }
}
