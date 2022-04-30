package Graph_level_01;

public class Q6_Count_Number_of_Islands {

    public static void get_count_island(int[][] grid) {
        
        int count = 0 ;

        boolean[][] visited = new boolean[grid.length][grid[0].length] ; 

        for (int i = 0; i < grid.length; i++) { // running loop for each element of grid.
            for (int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 0 && visited[i][j] == false ){ // if element is 0 and not visited then increase count of island and run the function finding island.
                    finding_island(grid,i,j,visited) ;
                    count++ ;
                }
            }
        }
    }

    private static void finding_island(int[][] grid, int i, int j, boolean[][] visited) {

        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1 || visited[i][j] == true){ // if i & j gets out of bound then return , if we come to water (1) then return and if element is already visited then return.
            return ;
        }

        visited[i][j] = true ; // make true.
        // and call the function for all four direction.
        finding_island(grid, i-1, j, visited);
        finding_island(grid, i, j-1, visited);
        finding_island(grid, i, j+1, visited);
        finding_island(grid, i+1, j, visited);
    }
    
}
