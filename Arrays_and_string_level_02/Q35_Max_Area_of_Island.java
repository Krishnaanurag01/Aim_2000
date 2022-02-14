package Arrays_and_string_level_02;

public class Q35_Max_Area_of_Island {

    public int maxAreaOfIsland(int[][] grid) {
        
        int result = 0 ;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1 ){ // when we reach to one cell of island then explore whole island and find count.
                result = Math.max(result, traverseAndCount(grid,i,j)) ;
                }
            }    
        }
        
        
        return result ;
    }
    
    // this is all the four directions.
    int[][] dire = {
        {1,0}, // down
        {-1,0}, // up
        {0,-1}, // left
        {0,1} // right
    } ;
    
    public int traverseAndCount(int[][] grid , int row , int col ){
        
        // when we come to this then it means wwe have encountered one cell of island,
        grid[row][col] = 0 ; // so make it 0 this is similar to visited array
        int count = 1 ; // and count 1
        
        for(int i = 0 ; i < 4 ; i++){ // now traverse in all the four directions.
            int newRow = row + dire[i][0] ;
            int newCol = col + dire[i][1] ;
            
            // checking condition and exploring further 
            if(newRow < grid.length && newRow >= 0 && newCol < grid[0].length && newCol >= 0 && grid[newRow][newCol] == 1){
               
                count += traverseAndCount(grid,newRow,newCol) ;
            }
        }
        
        return count ;
        
    }
    
}
