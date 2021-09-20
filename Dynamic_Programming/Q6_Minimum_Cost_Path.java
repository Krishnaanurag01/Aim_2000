package Dynamic_Programming;

public class Q6_Minimum_Cost_Path {


    public static void main(String[] args) {
        
    }

    public static int get_Min_cost(int[][] grid) {
        
        int n = grid.length ;
        int m = grid[0].length ;
        int dp[][] = new int[n][m] ;
        
        for (int i = dp.length-1  ; i >= 0 ; i--) {

            for (int j = dp[0].length-1 ; j >= 0 ; j--) {
                
                if(i == dp.length-1 && j == dp[0].length - 1) { // last row and col cost will be same as grid value.
                    dp[i][j] = grid[i][j] ;
                }
                else if(i == dp.length - 1){  // when last row.
                    dp[i][j] = grid[i][j] + dp[i][j+1] ; // we'll get the right value and then we add it with current cost.
                }
                else if(j == dp[0].length - 1){ // when last column we'll get the below value and then add the current cost.
                    dp[i][j] = grid[i][j] + dp[i+1][j] ;
                }
                else{
                    // otherwise we'll look for the right and below value , find min and add current cost.
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
                }

            }
            
        }


       return dp[0][0] ;
    }
    
}
