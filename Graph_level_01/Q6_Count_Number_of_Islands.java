package Graph_level_01;

public class Q6_Count_Number_of_Islands {

    public static void main(String[] args) {
        
    
    }

    public static void get_count_island(int[][] grid) {
        
        int count =0 ;

        boolean[][] visited = new boolean[grid.length][grid[0].length] ;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 0 && visited[i][j] == false ){
                    finding_island(grid,i,j,visited) ;
                    count++ ;
                }
            }
        }
    }

    private static void finding_island(int[][] grid, int i, int j, boolean[][] visited) {

        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1 || visited[i][j] == true){
            return ;
        }

        visited[i][j] = true ;
        finding_island(grid, i-1, j, visited);
        finding_island(grid, i, j-1, visited);
        finding_island(grid, i, j+1, visited);
        finding_island(grid, i+1, j, visited);
    }
    
}
