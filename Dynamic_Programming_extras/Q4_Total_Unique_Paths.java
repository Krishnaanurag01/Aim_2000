package Dynamic_Programming_extras;
import java.util.*;
public class Q4_Total_Unique_Paths {

    // normal recursive function : 

    static int count  ;
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        count = 0 ;
        helper(1,1,m,n) ;
        return count ;
	}
    
    static void helper(int si, int sc, int di , int dc){
        
        if(si > di || sc > dc ) {
            return ; 
        }
        
        if(si == di && sc == dc) {
            count++ ; // increasing count when reached to destination
            return  ;
        }
        
        helper(si+1,sc,di,dc) ; // going right
        helper(si,sc+1,di,dc) ; // going bottom
    }
    

    // using memoization : takes O(n*m) time and space o(n*m) + o(stack frames) .. it will give TLE as well. becuase it will take alot of memory.

    public int uniquePaths2(int m, int n) {
        
        int[][] dp = new int[m+1][n+1] ;
        
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        
        return getMazePaths(1,1,m,n,dp) ;
    }
    
       public static int getMazePaths(int sr, int sc, int dr, int dc ,int[][] dp) {
        
        if(sr == dr && sc == dc){
        
            return 1 ;
        }
           
        if(sr > dr || sc > dc){
            
            return 0 ;
        }
         
           if(dp[sr][sc] != -1 ){
               return dp[sr][sc] ;
           }

    
         int hori = getMazePaths(sr,sc+1,dr,dc,dp) ;
         int verti = getMazePaths(sr+1,sc,dr,dc,dp) ;

    
        return dp[sr][sc] = hori + verti ;
    }


    // using tabulation  : takes O(n2)

    public int uniquePaths3(int m, int n) {
        
        int[][] dp = new int[m][n] ;
     
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(i == 0 && j == 0){ // base case
                    dp[i][j] = 1  ;
                }
                else{
                    int upCount = i - 1 >= 0 ? dp[i-1][j] : 0  ; // get count when move up
                    int leftCount = j - 1 >= 0 ? dp[i][j-1] : 0 ; // get count when move left
                    dp[i][j] = upCount + leftCount ;
                    System.out.println(dp[i][j]) ;
                }
            }
        }
        return dp[m-1][n-1] ;
    }




    // optimal solution : space optimized tabulation.

    public int uniquePaths4(int m, int n) {
        
        int[] prev = new int[n] ; // we are creating only one row array becuase the tabulation only need previous data for current solution.
        // this prev array will hold previous row data as backup.
     
        for(int i = 0 ; i < m ; i++){
            int[] tempRow = new int[n] ; // this is current row dp. we will store value here.
            for(int j = 0; j < n ; j++){
                if(i == 0 && j == 0){ // base case
                    tempRow[j] = 1  ; 
                }
                else{
                    int upCount = i - 1 >= 0 ? prev[j] : 0  ; // as up value is present in prev row so look into prev row
                    int leftCount = j - 1 >= 0 ? tempRow[j-1] : 0 ; // and look for left data
                    tempRow[j] = upCount + leftCount ; 
                  
                }
            }
            prev = tempRow ; // now current row data become previous row data. for next row.
        }
        return prev[n-1] ;
    }

}

