package Dynamic_Programming_extras;

public class Q8_Maximum_Path_Sum_in_the_matrix {

    // using normal recursion .
    public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < matrix[0].length ; i++){ // checking each col of n-1 row(becuase both start and last row end is varriable means not fixed) for max sum path.
        int pans = helper(matrix.length-1,i,matrix) ; // got potential answer.
         max = Math.max(max,pans) ;
        }
        return max; 
	}
    
    static int helper(int n ,int m, int[][] matrix){
        if(m < 0 || m >= matrix[0].length ) return (int)-1e9 ; // boundary condition.
        
         
        if(n == 0){
            return matrix[n][m] ; // base case
        }
        
        int val1 = matrix[n][m] + helper( n-1, m-1 ,matrix) ; // going up left
        int val2 = matrix[n][m] + helper( n-1, m ,matrix); // going up 
        int val3 = matrix[n][m] + helper( n-1, m+1 ,matrix) ; // up right
        
        return Math.max(val1,Math.max(val2,val3)) ; // returning the max
    }
    

    // applying memoization. same as recursive code + dp array

    public static int getMaxPathSum2(int[][] matrix) {
		// Write your code here
        int max = Integer.MIN_VALUE ;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length] ;
        for(int i = 0 ; i < matrix[0].length ; i++){
        int pans = helper(matrix.length-1,i,matrix,dp) ;
         max = Math.max(max,pans) ;
        }
        return max; 
	}
    
    static int helper(int n ,int m, int[][] matrix,Integer[][] dp){
        if(m < 0 || m >= matrix[0].length ) return (int)-1e9 ;
     
        if(n == 0){
            return matrix[n][m] ;
        }
        
        if(dp[n][m] != null) return dp[n][m] ;
        
        int val1 = matrix[n][m] + helper( n-1, m-1 ,matrix,dp) ;
        int val2 = matrix[n][m] + helper( n-1, m ,matrix,dp);
        int val3 = matrix[n][m] + helper( n-1, m+1 ,matrix,dp) ;
        
        return dp[n][m] = Math.max(val1,Math.max(val2,val3)) ;
    }


    // using tabulation :

    public static int getMaxPathSum4(int[][] matrix) {
		int n = matrix.length ;
        int m= matrix[0].length ;
        int[][] dp = new int[n][m] ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0){
                    dp[i][j] = matrix[i][j] ; // base case is 0th row.
                }else{
                    int val1 = j - 1 >= 0 ? dp[i-1][j-1] : (int)-1e9 ; // upper left diagonal
                    int val2 =  dp[i-1][j] ; // upper value
                    int val3 = j + 1 <= m-1 ? dp[i-1][j+1] : (int)-1e9 ; //upper right diagonal
                    int tmax = Math.max(val1,Math.max(val2,val3)) ; // get max
                    dp[i][j] = matrix[i][j] + tmax ; // and store
                }
            }
        }
        
        int ans = (int)-1e9 ;
        for(int j = 0 ; j < m ; j++){ // getting last row value
            ans = Math.max(ans,dp[n-1][j]) ;
        }
        
        return ans ;
	}


    // space optimized  : // takes only o(n) space.

    public static int getMaxPathSum5(int[][] matrix) {
		int n = matrix.length ;
        int m= matrix[0].length ;
        int[] dp = new int[m] ; // this will hold prev row value
        
        for(int i = 0 ; i < n ; i++){
            int[] temp = new int[m] ; // will hold current row value
            for(int j = 0 ; j < m ; j++){
                if(i == 0){
                    temp[j] = matrix[i][j] ;
                }else{
                    int val1 = j - 1 >= 0 ? dp[j-1] : (int)-1e9 ;
                    int val2 =  dp[j] ;
                    int val3 = j + 1 <= m-1 ? dp[j+1] : (int)-1e9 ;
                    int tmax = Math.max(val1,Math.max(val2,val3)) ;
                    temp[j] = matrix[i][j] + tmax ;
                }
            }
            dp = temp ;
        }
        
        int ans = (int)-1e9 ;
        for(int j = 0 ; j < m ; j++){
            ans = Math.max(ans,dp[j]) ;
        }
        
        return ans ;
	}

}
