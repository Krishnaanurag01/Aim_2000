package Strings;



public class Q21_Count_Palindromic_Subsequences {
    public static void main(String[] args) {
     System.out.println(countPalindromicSubsequence("aab"));
    }

    public static int countPalindromicSubsequence(String str) {
    

        int[][] dp = new int[str.length()][str.length()];

        for(int g = 0 ; g < str.length() ; g++){

            for(int i = 0 , j = g ; j < str.length() ; i++, j++ ){

                if(g ==0 ){
                    dp[i][j] = 1;
                }
                else if(g ==1){

                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2 ;
                }
                else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 ; 
                    }
                    else{
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                }
            }
        }

        return dp[0][str.length()-1] ;
    }

    }
