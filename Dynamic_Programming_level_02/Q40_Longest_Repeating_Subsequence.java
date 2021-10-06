package Dynamic_Programming_level_02;

public class Q40_Longest_Repeating_Subsequence {

    public static void main(String[] args) {
        
    }



    // this is totally LCS with such that i != j .

    public static int get_LRS(String s) {
        
        int[][] dp = new int[s.length()+1][s.length()+1] ;

        for (int i = s.length() ; i >= 0 ; i--) {
            for (int j = s.length() ; j >= 0 ; j--) {
                
                if(i == s.length() || j == s.length()){
                    dp[i][j] = 0 ;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && i!= j){
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
        }

        return dp[0][0] ;
    }
    
}
