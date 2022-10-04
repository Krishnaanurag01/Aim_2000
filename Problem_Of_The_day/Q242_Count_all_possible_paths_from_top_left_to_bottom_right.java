package Problem_Of_The_day;

public class Q242_Count_all_possible_paths_from_top_left_to_bottom_right {

    Long[][] dp ;
    int mod = (int)1e9 + 7 ;
    long numberOfPaths(int m, int n)
    {
        dp = new Long[m][n] ;
        return helper(m-1,n-1) ;
    }
    
    long helper(int i, int j){
        if(i == 0 && j == 0) return 1 ;
        if(dp[i][j] != null) return dp[i][j] ;
        
        long left = 0 ;
        long up = 0 ;
        if(j > 0){
            left = helper(i,j - 1) ;
        }
        if(i > 0){
            up = helper(i-1, j) ;
        }
        
        return dp[i][j] = (left + up) % mod ;
    }
}
