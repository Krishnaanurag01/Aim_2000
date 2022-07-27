package Problem_Of_The_day ;
public class Q124_Count_Sub_Islands {
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int count = 0 ;
        for(int i = 0 ; i < grid2.length ; i++){
            for(int j = 0 ; j < grid2[0].length ; j++){
                if(grid2[i][j] == 1){ // when found land check the possibility
                boolean temp = dfs(i,j,grid2,grid1) ;
               
                if(temp){
                  count++ ;
                }          
                }
            }
        }
        
        return count;
    }
    
    boolean dfs(int i, int j, int[][] grid2, int[][] grid1){
        if(i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length) return true; // if out of boundary or
        if(grid2[i][j] == 0 ) return true; // or reach water then return true as we don't care about them.
        if(grid2[i][j] == 1 && grid1[i][j] != 1) return false ; // but if current cell is land which is not in grid1 then return false
        grid2[i][j] = 0 ; // converting land into water so that adjecent neighbours won't need to check the same island again.
        
        boolean left = dfs(i,j-1,grid2,grid1) ;
        boolean up = dfs(i-1,j,grid2,grid1) ;
        boolean right = dfs(i,j+1,grid2,grid1) ;
        boolean down = dfs(i+1,j,grid2,grid1) ;

        
        return left && up && right && down ;
    }
}
