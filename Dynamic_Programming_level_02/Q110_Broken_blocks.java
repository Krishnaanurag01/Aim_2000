package Dynamic_Programming_level_02;

public class Q110_Broken_blocks {

    static Integer[][] dp ;
    public int MaxGold(int[][] matrix)
    {
        dp = new Integer[matrix.length][matrix[0].length] ;
        int max = 0 ;
        for(int i = 0 ; i < matrix[0].length ; i++){
            if(matrix[0][i] != -1){
                max = Math.max(max,helper(0,i,matrix));
            }
        }
        
        return max ;
    }
    
    int helper(int row, int col, int[][] matrix){
        
        if(row == matrix.length) return 0 ;
        if(row < 0 || row > matrix.length -1 || col < 0 || col > matrix[0].length - 1 || matrix[row][col] == -1)
        return  0 ;
        
        if(dp[row][col] != null) return dp[row][col] ;
        
        int bottom = matrix[row][col] + helper(row+1,col,matrix);
        
        int left = matrix[row][col] + helper(row+1,col-1,matrix);
        int right = matrix[row][col] + helper(row+1,col+1,matrix);
        
        return dp[row][col] = Math.max(bottom, Math.max(left,right) ) ;
    }
}
