package Dynamic_Programming_level_02;

public class Q44_Delete_Operation_for_Two_Strings {

    public static void main(String[] args) {
        
    }

    // finding LCS then subtracting from s1 + s2 length.
    public static int min_cost_making_identical(String s1 , String s2) {
        
        int[][] dp = new int[s1.length()+1][s2.length()+1] ;

        for (int i = dp.length - 1; i >= 0 ; i--) {
            for (int j = dp[0].length - 1; j >= 0 ; j--) {
                
                if(i == dp.length-1 || j == dp[0].length-1){
                    dp[i][j] = 0 ;
                }
                else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = 1 + dp[i+1][j+1] ;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]) ;
                    }
                }
            }
        }

        int lcs = dp[0][0] ;

       int ans  = s1.length() + s2.length() - (lcs*2) ;

        return ans ;
    }
}
