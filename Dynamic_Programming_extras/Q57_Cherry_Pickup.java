package Dynamic_Programming_extras ;

public class Q57_Cherry_Pickup {


    // recursive solution : 

    static int n ;
    public int cherryPickup(int[][] grid) {
        
        n = grid.length ;
        int ans = helper(0,0,0,0,grid) ;
        return ans == (int)-1e9 ? 0 : ans ; // running two person from start. second person is equivalent to that person who would run from bottom to top.
    }
    
    int helper(int r1,  int c1, int r2, int c2, int[][] grid){
        
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1  ){
            return (int)-1e8 ;
        }
        
        if(r1 == n-1 && c1 == n-1 ){
            return grid[r1][c1] ;
        }
        
        int totalCheries = 0 ;
        // when both person on the same cell  then add cheries only once.
        if(r1 == r2 && c1 == c2){
            totalCheries += grid[r1][c1] ;
        }
        else{ // when both on different cell
            totalCheries += grid[r1][c1] + grid[r2][c2]  ;
        }
        
        // now both person has total 4 moves to move. 
        //that is : hh,hv,vh,vv 
        
        int hh = helper(r1,c1+1,r2,c2+1,grid);
        int vh = helper(r1+1,c1,r2,c2+1,grid);
        int hv = helper(r1,c1+1,r2+1,c2,grid);
        int vv = helper(r1+1,c1,r2+1,c2,grid);
        
        int max = Math.max( Math.max(hh,hv), Math.max(vh,vv) ) ;
        return max >= 0 ? max  +  totalCheries : (int)-1e9  ;
    }    


    // using memoization .

    static Integer[][][][] dp ;
    public int cherryPickup2(int[][] grid) {
        
        n = grid.length ;
        dp = new Integer[n][n][n][n] ;

        int ans = helper(0,0,0,0,grid) ;
        return ans == (int)-1e9 ? 0 : ans ; // running two person from start. second person is equivalent to that person who would run from bottom to top.
    }
    
    int helper2(int r1,  int c1, int r2, int c2, int[][] grid){
        
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1  ){
            return (int)-1e8 ;
        }
        
        if(dp[r1][c1][r2][c2]  != null) return dp[r1][c1][r2][c2] ;
        
        if(r1 == n-1 && c1 == n-1 ){
            return grid[r1][c1] ;
        }
        
        int totalCheries = 0 ;
        // when both person on the same cell  then add cheries only once.
        if(r1 == r2 && c1 == c2){
            totalCheries += grid[r1][c1] ;
        }
        else{ // when both on different cell
            totalCheries += grid[r1][c1] + grid[r2][c2]  ;
        }
        
        // now both person has total 4 moves to move. 
        //that is : hh,hv,vh,vv 
        
        int hh = helper2(r1,c1+1,r2,c2+1,grid);
        int vh = helper2(r1+1,c1,r2,c2+1,grid);
        int hv = helper2(r1,c1+1,r2+1,c2,grid);
        int vv = helper2(r1+1,c1,r2+1,c2,grid);
        
        int max = Math.max( Math.max(hh,hv), Math.max(vh,vv) ) ;
        
    

        return dp[r1][c1][r2][c2] = max >= 0 ? max  +  totalCheries : (int)-1e9  ;
        
    }


    /// space optimized meomo : taking O(n3) space..

    static Integer[][][] dp2 ;
    public int cherryPickup3(int[][] grid) {
        
        n = grid.length ;
        dp2 = new Integer[n][n][n] ;

        int ans = helper(0,0,0,grid) ;
        return ans == (int)-1e9 ? 0 : ans ; // as r1 + c1 == r2 + c2 so instead of passing 4 inputs we can just pass the r1, c1, r2 and we derive c2 from it. 
    }
    
    int helper(int r1,  int c1, int r2, int[][] grid){
        
        int c2 = r1 + c1 - r2 ; // deriving the c2 from rest of the inputs.
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1  ){
            return (int)-1e8 ;
        }
        
        if(dp2[r1][c1][r2] != null) return dp2[r1][c1][r2] ;
        
        if(r1 == n-1 && c1 == n-1 ){
            return grid[r1][c1] ;
        }
        
        int totalCheries = 0 ;
        // when both person on the same cell  then add cheries only once.
        if(r1 == r2 && c1 == c2){
            totalCheries += grid[r1][c1] ;
        }
        else{ // when both on different cell
            totalCheries += grid[r1][c1] + grid[r2][c2]  ;
        }
        
        // now both person has total 4 moves to move. 
        //that is : hh,hv,vh,vv 
        
        int hh = helper(r1,c1+1,r2,grid);
        int vh = helper(r1+1,c1,r2,grid);
        int hv = helper(r1,c1+1,r2+1,grid);
        int vv = helper(r1+1,c1,r2+1,grid);
        
        int max = Math.max( Math.max(hh,hv), Math.max(vh,vv) ) ;
        
    

        return dp2[r1][c1][r2] = max >= 0 ? max  +  totalCheries : (int)-1e9  ;
        
    }
}
