package Dynamic_Programming_extras;

public class Q7_Triangle {

    public static int minimumPathSum(int[][] triangle, int n) {
        // we have to start from 1st row and 1st col (bottom up approch) becuase in the last row there are multiple cols so we won't be able to choose answer easily.
        return helper( 0, 0 , triangle);
    }
    
    static int helper(int idx,int col, int[][] triangle){
        if(idx == triangle.length - 1 ){ // when on last row 
          return triangle[idx][col] ;   // return it's cell value
        } 
        
       int bottom = helper(idx+1,col,triangle); // going bottom with same col
       int br = helper(idx+1,col+1,triangle); // going bottom with col+1 
        return Math.min(bottom,br) + triangle[idx][col]; // chosing min + cell value.
    }

    // using memoization : 

    public static int minimumPathSum2(int[][] triangle, int n) {
        // Write your code here.
        Integer[][] dp = new Integer[n][n] ; // using a dp
        return helper( 0, 0 , triangle,dp);
    }
    
    static int helper(int idx,int col, int[][] triangle,Integer[][] dp){
        if(idx == triangle.length - 1 ){
          return dp[idx][col] = triangle[idx][col] ;  
        } 
        
        if(dp[idx][col] != null) return dp[idx][col] ; // returning if already solved
        
       int bottom = helper(idx+1,col,triangle,dp);
       int br = helper(idx+1,col+1,triangle,dp);
        return dp[idx][col] = Math.min(bottom,br) + triangle[idx][col]; // storing answer in dp
    }
    


    // tabulation :
    
    public static int minimumPathSum3(int[][] triangle, int n) {
        // Write your code here.
        int[][] dp = new int[n][n] ;
        
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = i ; j >=0 ; j--){
                
                if(i == n-1){ // the last row is base case so store the value as it is.
                    dp[i][j] = triangle[i][j] ;
                }
                else{
                     int bottom = triangle[i][j] + dp[i+1][j] ; // going down
                     int bright =  triangle[i][j] + dp[i+1][j+1] ; // going bottom right
                    
                    dp[i][j] = Math.min(bottom,bright) ; // choosing min.
                }
            }
        }
        
        
        
        return dp[0][0];
    }


    // space optimized solution : 

    public static int minimumPathSum4(int[][] triangle, int n) {
        // Write your code here.
        int[] dp = new int[n] ;
        
        for(int i = n - 1 ; i >= 0 ; i--){
            int[] temp = new int[n] ;
            for(int j = i ; j >=0 ; j--){
                
                if(i == n-1){
                    temp[j] = triangle[i][j] ;
                }
                else{
                     int bottom = triangle[i][j] + dp[j] ;
                     int bright =  triangle[i][j] + dp[j+1] ;
                    
                    temp[j] = Math.min(bottom,bright) ;
                }
            }
            dp = temp ;
        }
        
        
        
        return dp[0];
    }

}
