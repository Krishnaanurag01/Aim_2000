package Dynamic_Programming_extras;

public class Q6_Minimum_Path_Sum {

    // memoization : 

    public static int minSumPath(int[][] grid) {
   
        Integer[][] dp = new Integer[grid.length][grid[0].length] ;
        return helper( grid.length - 1, grid[0].length - 1, grid , dp); // using top down approch.
    }
   
    static int helper(int si, int sj,int[][] grid, Integer[][] dp){
        if(si == 0 && sj == 0){
            return grid[si][sj] ;
        }
        
        if(si < 0 || sj < 0 ){ return Integer.MAX_VALUE ;}
        if(dp[si][sj] != null) return dp[si][sj] ; // returning answer if already solved.
        
        int left =  helper(si,sj-1,grid,dp) ; // going up
        int up = helper(si-1,sj,grid,dp) ; // going left
        
        return dp[si][sj] = Math.min(left,up) + grid[si][sj] ; // storing and returning
    }

    //tabulations : 

    public static int minSumPath2(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        int[][] dp = new int[n][m] ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j] ; // base case
                }
                else{
                    int up = i - 1 >= 0 ? dp[i-1][j] : Integer.MAX_VALUE; // going up
                    int left = j - 1 >= 0 ? dp[i][j-1] : Integer.MAX_VALUE ; // going left
                    dp[i][j] = Math.min(up,left) + grid[i][j] ; //  ( using the min of up and left ) + current cell value
                }
            }
        }
        
        return dp[n-1][m-1] ;
    }
    
    // space optimized solutio. // storing the reault in given grid array instead of another dp array.
    public static int minSumPath4(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
//         int[][] dp = new int[n][m] ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0){
//                     [i][j] = grid[i][j] ;
                }
                else{
                    int up = i - 1 >= 0 ? grid[i-1][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? grid[i][j-1] : Integer.MAX_VALUE ;
                    grid[i][j] = Math.min(up,left) + grid[i][j] ;
                }
            }
        }
        
        return grid[n-1][m-1] ;
    }
}
