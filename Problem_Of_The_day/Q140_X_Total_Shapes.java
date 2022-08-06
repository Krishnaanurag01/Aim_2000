package Problem_Of_The_day;

public class Q140_X_Total_Shapes {
    

    // Here we just have to count the group of 'X'

    public int xShape(char[][] grid)
    {
        int count = 0 ;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 'X'){
                    dfs(i,j,grid) ;
                    count++ ;
                }
            }
        }
        
        return count ;
    }
    
    void dfs(int i , int j, char[][] grid){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 'X') return ;
        grid[i][j] = 'O' ;
        
        dfs(i+1,j,grid) ;
        dfs(i-1,j,grid) ;
        dfs(i,j+1,grid) ;
        dfs(i,j-1,grid) ;
        
    }
}
