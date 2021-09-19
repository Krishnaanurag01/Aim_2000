package Dynamic_Programming;

public class Longest_Palindromic_SubSequence {
 public static void main(String[] args) {
     getLPS("bbbab");
 }   
 public static void getLPS(String s) {
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
     System.out.println(dp[0][s.length()-1]);
 }
}
