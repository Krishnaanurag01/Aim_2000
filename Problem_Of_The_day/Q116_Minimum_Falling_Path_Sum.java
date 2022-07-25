package Problem_Of_The_day;

public class Q116_Minimum_Falling_Path_Sum {
    
    Integer[][] dp ;
    public int minFallingPathSum(int[][] matrix) {
        
        dp = new Integer[matrix.length][matrix.length] ;
        int min = (int)1e9 ;
        
        for(int i = 0 ; i < matrix.length ; i++){
            min = Math.min(min, helper(0,i,matrix)) ;
        }
        
        return min ;
    }
    
    int helper(int i, int j, int[][] matrix){
        if(i == matrix.length - 1) return matrix[i][j] ;
        if(dp[i][j] != null) return dp[i][j] ;
        
        int bottom = helper(i+1,j,matrix) ;
        int left = j > 0 ? helper(i+1,j-1,matrix) : (int)1e8 ;
        int right = j < matrix.length - 1  ? helper(i+1,j+1,matrix) : (int)1e8 ;

        return dp[i][j] = Math.min(bottom, Math.min(left,right)) + matrix[i][j] ;
    }
}
