package Dynamic_Programming_extras;
import java.util.*;
public class Q56_Triangle {

    // using memoization.
    
    static Integer[][] dp ;
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size() ;
        dp = new Integer[n][triangle.get(n-1).size()]; 
        return helper(0,0, triangle) ; // starting from fixed point.
    }
    
    public int helper(int idx, int j, List<List<Integer>> triangle ){
        
        if(idx == triangle.size() - 1)  // when reached bottom return val of required cell.
            return triangle.get(idx).get(j) ;
        
        if(dp[idx][j] != null) return dp[idx][j] ;
        int curr = triangle.get(idx).get(j) ;
        
        int bottom = curr + helper(idx+1,j,triangle);  // going bottom
        int rd = curr + helper(idx+1,j+1,triangle) ; // going right diagonal
        
        return dp[idx][j] = Math.min(bottom,rd) ; // returning min.
    }


    // tabulations  :

    public int minimumTotal2(List<List<Integer>> triangle) {
        
        int n = triangle.size() ;
        int m = triangle.get(n-1).size() ;
        int[][] dp = new int[n][m]; 
        
        for(int i = n - 1 ; i >= 0 ; i-- ){
            for(int j = m-1 ; j >= 0 ; j-- ){
                
                if(i == n-1){
                    dp[i][j] = triangle.get(i).get(j) ;
                }
                else{
                    if(j >= triangle.get(i).size() ) continue ; // skipping when col is not present.
                    
                    int curr = triangle.get(i).get(j) ;
                    int bottom = curr + dp[i+1][j]; 
                    int rd = curr + dp[i+1][j+1] ;
        
                    int min = Math.min(bottom,rd) ;
                    dp[i][j] = min ;
                }
            }
        }
        
        return dp[0][0];
    }




    // space optimized solution : 

    public int minimumTotal3(List<List<Integer>> triangle) {
        
        int n = triangle.size() ;
        int m = triangle.get(n-1).size() ;
        int[] dp = new int[m]; // holding only the next row data 
        
        for(int j = 0 ; j < m ; j++)  //getting next row dp
            dp[j] = triangle.get(n-1).get(j) ;
        

        for(int i = n - 2 ; i >= 0 ; i-- ) {
            int[] temp = new int[m] ; // current row
            for(int j = m-1 ; j >= 0 ; j-- ){

                    if(j >= triangle.get(i).size() ) continue ; // skipping when col is not present.
                    
                    int curr = triangle.get(i).get(j) ;
                    int bottom = curr + dp[j];  // getting j from next row
                    int rd = curr + dp[j+1] ; 
        
                    int min = Math.min(bottom,rd) ;
                    temp[j] = min ;
                }
            dp = temp ; // now current row becomes next row.
        }
        
        return dp[0];
    }
}

