package Recursion_and_backtracking_level_02;

public class Q7_Path_with_Maximum_Gold {
    
    public int getMaximumGold(int[][] grid) {
        
        int max = 0 ; 
        
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] != 0 && grid[i][j] > 0 ){
                    
                    int ans = helper(grid,i,j) ;
                    max = Math.max(ans,max) ;
                }
            }
        }
        
        return max ;
    }
    
    public int helper(int[][] grid, int i , int j){
        
        /// base case
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] < 0 ){
            return 0 ;
        }
        
        int val = grid[i][j] ; // backing up the value
        grid[i][j] = - val ; // making visited by adding "-"
        
        int t = helper(grid,i-1,j) ;      // asking top about their best values
        int d = helper(grid,i+1,j) ;      // asking down about their best values
        int l = helper(grid,i,j-1) ;      // asking left about their best values 
        int r = helper(grid,i,j+1) ;      // asking right about their best values    

        grid[i][j] = val ; // making unvisited so that we can find the best answer.
        int ans = Math.max(t, Math.max(d,Math.max(l,r))) ; // selecting the max value between the top,down,left,right
         return val + ans  ; // now sending the max value of all directions with current value;
        
    }
}
