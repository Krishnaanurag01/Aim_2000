package Dynamic_Programming_level_02;

public class Q_Edit_distance {

    public static void main(String[] args) {
        
    }
    


    // checking string directory for explanation.
    public static int get_min_operations(String s  , String s2) {
        
        int[][] dp = new int[s.length() + 1][s2.length() + 1] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if( i == 0 ){
                    dp[i][j] = j ;
                }
                else if(j == 0){
                    dp[i][j] = i ;
                }
                else{
                    if(s.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j]  = dp[i-1][j-1] ;
                    }
                    else{
                        int insert = 1 + dp[i][j-1] ;
                        int replace = 1+  dp[i-1][j-1] ;
                        int delete = 1 + dp[i-1][j] ;

                        dp[i][j] = Math.min(insert, Math.min(delete,replace)) ;
                    }
                }

            }
        }

        return dp[s.length()][s2.length()] ;
    }
}
