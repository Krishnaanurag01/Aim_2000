package Graph_level_01;

public class Q8_Find_the_number_of_islands {
    
}

// same as Q6. 
// here we are traversing all the four direction + all four diagonal direction.

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        
        return get_count_island(grid) ;
    }
    
      public static int get_count_island(char[][] grid) {
        
        int count =0 ;

        boolean[][] visited = new boolean[grid.length][grid[0].length] ;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == '1' && visited[i][j] == false ){
                    finding_island(grid,i,j,visited) ;
                    count++ ;
                }
            }
        }
        
        return count ;
    }

    private static void finding_island(char[][] grid, int i, int j, boolean[][] visited) {

        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == true){
            return ;
        }
        
                visited[i][j] = true ;


        finding_island(grid, i-1, j, visited);
        
        finding_island(grid, i-1, j-1, visited);
        
        
        finding_island(grid, i-1, j+1, visited);
        finding_island(grid, i, j-1, visited);
        finding_island(grid, i, j+1, visited);
        
        finding_island(grid, i+1, j, visited);
        
        
        finding_island(grid, i+1, j+1, visited);
        
        finding_island(grid, i+1, j-1, visited);
    }
}