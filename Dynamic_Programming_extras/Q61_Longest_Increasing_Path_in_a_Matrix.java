package Dynamic_Programming_extras;

public class Q61_Longest_Increasing_Path_in_a_Matrix {

    static Integer[][] dp ;
    public int longestIncreasingPath(int[][] matrix) {
        
        dp = new Integer[matrix.length][matrix[0].length] ; // using memoization.
        int max = 0 ;
        
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
             max = Math.max(max, helper(i,j,matrix)) ;   
            }
        }
        return max + 1;
        
    }
    
    // finding LIS for every cell.
    int helper(int si, int ei, int[][] matrix){
        
        if( si >= matrix.length || si < 0 || ei < 0 || ei >= matrix[0].length )
            return  0 ;
        
        if(dp[si][ei] != null) return dp[si][ei];  
        
        int val = matrix[si][ei] ;
        int max = 0 ;

        // going up.
        if( si > 0 && matrix[si-1][ei] > val )
            max  = Math.max(max , 1 + helper(si-1,ei,matrix) ) ;
        
        // going left.
        if( ei > 0 && matrix[si][ei-1] > val )
            max  = Math.max(max , 1 + helper(si,ei-1,matrix) ) ;
        
        // going down
        if( si + 1 < matrix.length && matrix[si+1][ei] > val )
            max  = Math.max(max , 1 + helper(si+1,ei,matrix) ) ;
        
        // going right
        if( ei + 1 < matrix[0].length && matrix[si][ei+1] > val )
            max  = Math.max(max , 1 + helper(si,ei+1,matrix) ) ;
        
        // returning max.
        return dp[si][ei] = max ;
    }
}
