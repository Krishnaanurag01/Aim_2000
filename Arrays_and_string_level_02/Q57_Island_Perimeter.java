package Arrays_and_string_level_02;

public class Q57_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {
        
        int result = 0 ;
        
        r = grid.length ;
        c = grid[0].length ;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1 ){
                result = Math.max(result, traverseAndCount(grid,i,j)) ;  // as it only has one island so when first island encounter calculate it's result.
                    return result ;
                 }
            }    
        }
        
        
        return result ;
        
    }
    
    static int r ; // row size
    static int c ; //col size
    static int[][] dire = { {0,1} ,{1,0},{0,-1},{-1,0} } ;  // all four direction.
    
    public int traverseAndCount(int[][] grid , int i , int j){
        
        grid[i][j] = -1; // making it visited
        
        int count = 0 ; 

        for(int k = 0 ; k < 4 ; k++){
            int rowSum = i + dire[k][0] ;
            int colSum = j + dire[k][1] ;
            
            // going to all four directions if unvisited and not out of bound.
            if(rowSum < r && rowSum >= 0 && colSum < c && colSum >= 0 && grid[rowSum][colSum] == 1 ){
                 count += traverseAndCount(grid,rowSum,colSum) ;
            }
            
            // counting the perimeter of current cell  : if new row or col is out of bound or new cell is water then increase one.
            if(rowSum >= r || rowSum < 0 || colSum >= c || colSum < 0 || grid[rowSum][colSum] == 0 ){
                count++ ;
            }
        }
        
        
        return count ;
    }
    
}
