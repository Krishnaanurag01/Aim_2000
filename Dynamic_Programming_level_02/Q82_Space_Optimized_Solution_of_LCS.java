package Dynamic_Programming_level_02;

public class Q82_Space_Optimized_Solution_of_LCS {

    public static void main(String[] args) {
        
    }


    // not working, need correction .
    public static int getLCS(String s1 , String s2) {
        
        int[][] dp = new int[2][s1.length()+1] ;

        for (int i = s1.length()  ; i >= 0 ; i--) {
            for (int j = dp[0].length - 1; j >= 0 ; j--) {
                
                if(i == dp.length - 1 || j == dp[0].length - 1){
                    dp[i][j] = 0 ;
                }
                else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1] + 1 ;
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
