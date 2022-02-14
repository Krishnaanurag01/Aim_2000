package Arrays_and_string_level_02;

public class Q36_Unit_Area_of_largest_region_of_1s {


    // same as Q35
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int result = 0 ;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1 ){
                result = Math.max(result, traverseAndCount(grid,i,j)) ;
                 }
            }    
        }
        
        
        return result ;
    }
    
    int[][] dire = {
        {1,0}, // down
        {-1,0}, // up
        {0,-1}, // left
        {0,1}, // right
        {-1,-1}, // vertical left diagonal
        {-1,1}, // vertical right diagonal
        {1,-1}, // bottom left diagonal
        {1,1}, // bottom right diagonal
    } ;
    
    public int traverseAndCount(int[][] grid , int row , int col ){
        
         grid[row][col] = 0 ;
        int count = 1 ;
        
        for(int i = 0 ; i < 8 ; i++){
            int newRow = row + dire[i][0] ;
            int newCol = col + dire[i][1] ;
            
            while(newRow < grid.length && newRow >= 0 && newCol < grid[0].length && newCol >= 0 && grid[newRow][newCol] == 1){
               
                count += traverseAndCount(grid,newRow,newCol) ;
            }
        }
        
        return count ;
        
    }
}
