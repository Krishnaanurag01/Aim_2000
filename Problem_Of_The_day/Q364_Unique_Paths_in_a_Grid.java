package Problem_Of_The_day ;
public class Q364_Unique_Paths_in_a_Grid {
    
    static Long[][] dp ; // using dp to store ans till some point
    static int mod = (int)1e9+7 ;
    static int uniquePaths(int n, int m, int[][] grid) {
        if(grid[0][0] == 0 || grid[n-1][m-1] == 0 ) return 0 ;
        
        dp = new Long[n][m] ;
        return (int)helper(0,0,grid) ;
    }
    
    static long helper(int si, int sj, int[][] grid){
        if(si == grid.length - 1 && sj == grid[0].length - 1) return 1 ;
        if(si >= grid.length || sj >= grid[0].length ||  grid[si][sj] == 0 ) return 0 ;
        
        if(dp[si][sj] != null) return dp[si][sj] ; // if already solved then return
        long bottom = helper(si+1, sj, grid) ; // going down
        long right = helper(si, sj+1, grid) ; // going right
        
        return dp[si][sj] = (bottom + right)%mod ; // returning total ans
    }
}
