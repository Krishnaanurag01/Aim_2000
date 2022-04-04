package Dynamic_Programming_extras;

public class Q9_Cherry_Pickup_II {

    // normal recursion : time is : O(3^n + 3^n) , space : O(n) for stack frames of each row 

    public int cherryPickup(int[][] grid) {
        int r = grid.length ;
        int c = grid[0].length ;
        
         return helper(0,0,c-1,r,c,grid) ;
    }
    
    // i is the present row at which both robots are : j1 is col of first row and j2 is of 2nd robot. 
    static int helper(int i, int j1, int j2, int row, int col, int[][] grid){
        if(j1 < 0 || j1 >= col || j2 < 0 || j2 >= col){ // when out of bound return -infinity
            return (int)-1e8 ;
        }
        
        if(i == row-1){ // when reached last row then perform following
            if(j1 == j2) return grid[i][j1] ; // if both robots are at the same col then return current value only once.
            else return grid[i][j1] + grid[i][j2] ; // else when on diff return sum of both
        }
        
        int max = (int)-1e8 ;
         // now exploring all the 9 paths.
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){ // this helps in going diagonal for first robot
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){ // diagonal for second robot
                
                int value = 0 ;
                if(j1 == j2) value = grid[i][j1] ; // if both on same col then add only once
                else value = grid[i][j1] + grid[i][j2] ; // else take sum of both col
                
                value += helper(i+1, j1 + dj1 , j2 + dj2, row,col,grid) ; // now finding next row ans.
                max = Math.max(max,value)  ; // getting max
            }
        }
        
        return max ;
    }
 
    


    // using memoization : O(r*c*C)*9 , space : O(r*c*C)+ O(r)

    public int cherryPickup2(int[][] grid) {
        int r = grid.length ;
        int c = grid[0].length ;
        Integer[][][] dp = new Integer[r][c][c] ; // just adding this dp in old recursive code
        
         return helper(0,0,c-1,r,c,grid,dp) ;
    }
    
    static int helper(int i, int j1, int j2, int row, int col, int[][] grid, Integer[][][] dp){
        if(j1 < 0 || j1 >= col || j2 < 0 || j2 >= col){
            return (int)-1e8 ;
        }
        
        if(i == row-1){ // when reached last row then perform following
            if(j1 == j2) return grid[i][j1] ;
            else return grid[i][j1] + grid[i][j2] ;
        }
        
        if(dp[i][j1][j2] != null) return dp[i][j1][j2] ; /// if already solved then return
        
        int max = (int)-1e8 ;
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                
                int value = 0 ;
                if(j1 == j2) value = grid[i][j1] ;
                else value = grid[i][j1] + grid[i][j2] ;
                
                value += helper(i+1, j1 + dj1 , j2 + dj2, row,col,grid,dp) ;
                max = Math.max(max,value)  ;
            }
        }
        
        return dp[i][j1][j2] = max ; // storing and returning.
    }
}
