package Dynamic_Programming_extras;

public class Q83_Out_of_Boundary_Paths {
    
    static Integer[][][] dp ;
    static int mod = (int)1e9+7 ;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        dp = new Integer[m][n][maxMove+1] ;
        return helper(startRow,startColumn, maxMove,m,n);
    }
    
    int direc[][] = {{0,1},{1,0},{-1,0},{0,-1}} ;
    
    int helper(int si, int ci, int moves, int m, int n){
        if(si == m ) return 0 ;
        if(moves == 0 ){
            return  0 ;
        }
        
        if(dp[si][ci][moves] != null) return dp[si][ci][moves] ;
        
        int count = 0 ;
        
        int left = ci == 0 ? 1 : 0 ;
        int up = si == 0 ? 1 : 0 ;
        int right = ci == n-1 ? 1 : 0 ;
        int bottom = si == m-1 ? 1 : 0 ;
        
        count = (count + left + up + right + bottom)%mod ;

        for(int i = 0 ; i < 4 ; i++){
            int row_ = si + direc[i][0] ;
            int col_ = ci + direc[i][1] ;
            
            if(row_ < 0 || row_ >= m || col_ < 0 || col_ >= n  ) continue ;
            
            count = ( count + helper(row_,col_,moves-1,m,n) ) % mod;
        }
        
        return dp[si][ci][moves] = count ;
    }
}
