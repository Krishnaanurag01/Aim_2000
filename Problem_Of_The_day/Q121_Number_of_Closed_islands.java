package Problem_Of_The_day;

public class Q121_Number_of_Closed_islands {

    public int closedIsland(int[][] grid) {
        
        // as land should be cover by 1's so all the 0's(land) which are on border make it -1 or some random value to denotes it is not land
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
                    if(grid[i][j] == 0){
                        dfs(i,j,grid) ;
                    }
                }
            }
        }
        
        // now count all the land regions
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0){
                    count++ ;
                    dfs(i,j,grid) ;
                }
            }
        }
        
        return count ;
    }
    
    void dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) return  ;
        grid[i][j] = -1 ;
        
        dfs(i+1,j,grid) ;
        dfs(i,j+1,grid) ;
        dfs(i-1,j,grid) ;
        dfs(i,j-1,grid) ;
    }
}
