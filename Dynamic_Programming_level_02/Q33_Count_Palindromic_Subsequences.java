package Dynamic_Programming_level_02;

import java.util.*;

public class Q33_Count_Palindromic_Subsequences {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        System.out.println(count_palindromic_subsec(sc.next()));

        sc.close();
        
    }
    
    public static int count_palindromic_subsec(String s ) {
        
        int[][] dp = new int[s.length()][s.length()] ;

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0 , j = g ; j < dp.length; i++,j++) {
                
                if(g == 0){
                    dp[i][j] = 1 ;
                }
                else if(g==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2 ;
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1 ;
                    }
                    else{
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] ;
                    }
                }
            }
        }

        return dp[0][s.length()-1] ;
    }
}
