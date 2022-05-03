package Dynamic_Programming_extras;

public class Q70_Where_Will_the_Ball_Fall {

    public int[] findBall(int[][] grid) {
        
        int[] ans = new int[grid[0].length] ;
        
        for(int i = 0 ; i < grid[0].length ; i++){  // checking for each ball on every column and also storing answer.
            ans[i] = helper(grid,0,i) ;
        }
        
        return ans ;
    }
    
    int helper(int[][] grid, int row, int col){
        
        
        if(col < 0 || col >= grid[0].length ) return -1; // if out of bound means ball got stuck to left or right wall
        if(row == grid.length) return col ; // when ball dropped then return answer column

        
        if(col > 0 && grid[row][col - 1] == 1 && grid[row][col] == -1 ) return -1;       // checking v lock
        if(col < grid[0].length - 1 && grid[row][col] == 1 && grid[row][col + 1] == -1 ) return -1; // checking v lock

        
        if(grid[row][col] == 1)  // moving diagonal
            return helper(grid,row+1,col+1);
        
        if(grid[row][col] == -1) //moving diagonal
            return helper(grid,row+1,col-1);
        
        return -1 ;
    }
}
