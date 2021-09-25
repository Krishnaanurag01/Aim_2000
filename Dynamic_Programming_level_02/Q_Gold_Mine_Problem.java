package Dynamic_Programming_level_02 ;

/**
 * Q_Gold_Mine_Problem
 */
public class Q_Gold_Mine_Problem {

    public static void main(String[] args) {
        
    }


    // check explanation in level_01 folder.
    public static int max_gold(int[][] mine) {

        int n = mine.length ;
        int m = mine[0].length ;

        int[][] dp = new int[n][m] ;

        for (int j = m-1; j >= 0 ; j--) {
            for (int i = 0; i < dp.length; i++) {
                
                if(j == m-1){
                    dp[i][j] = mine[i][j] ;
                }
                else if(i == 0 && n == 1){
                    dp[i][j] = dp[i][j+1] + mine[i][j];
                }
                else if(i == 0 && n > 1 ){
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]) + mine[i][j];
                }
                else if(i == n-1){
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j+1]) + mine[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1])) + mine[i][j] ;
                }
            }
        }

        int output = Integer.MIN_VALUE ;

        for(int i = 0 ; i < dp.length ; i++){
            output = Math.max(output, dp[i][0]) ;
        }




        return output ;
        
    }
}

