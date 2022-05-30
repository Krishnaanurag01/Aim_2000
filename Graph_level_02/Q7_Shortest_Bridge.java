package Graph_level_02;

import java.util.*;

public class Q7_Shortest_Bridge {
    
    static class Pair{
        int x ,y ;
        Pair(int x , int y){
            this.x = x ;
            this.y = y ;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        
        LinkedList<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length] ;

        boolean flag = false ; // helps in finding only one island.
        
        for(int i = 0 ; i < grid.length && flag == false ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                  dfs(i,j,grid,queue,visited) ;   // dfs will add all the 1's of the current island.
                  flag = true ;
                  break ;
                }
            }
        }
        
        
        // bfs starts from here.
        
        int level = 0 ;
        
        while (queue.size() > 0) {
            int size = queue.size() ;
            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                
                // adding the unvisited neighbours if they are not visited and not zero.
                for (int i = 0; i < 4 ; i++) {
                    int rowDash = rem.x + directions[i][0];
                    int colDash = rem.y + directions[i][1];
                    
                    if(rowDash < 0 || rowDash >= grid.length || colDash < 0 || colDash >= grid[0].length || visited[rowDash][colDash] == true){
                        continue;
                    }
                    
                    if(grid[rowDash][colDash] == 1){ // if one found then it is of second island because we have added all the ones of first island already.
                        return level ;
                    }
                    
                    visited[rowDash][colDash] = true ;
                    queue.add(new Pair(rowDash, colDash));
                    
                }
            }
            level++;
            
        }

        return -1 ;
    }

    static int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };

    // simple dfs adding all the adjecent 1's cell
    private void dfs(int i, int j, int[][] grid, LinkedList<Pair> queue, boolean[][] visited) {

        visited[i][j] = true ;
        queue.add(new Pair(i, j));

        for (int k = 0; k < 4 ; k++) {
            int rowDash = i + directions[k][0] ;
            int colDash = j + directions[k][1] ;

            if(rowDash >= 0 && rowDash < grid.length && colDash >= 0 && colDash < grid[0].length && grid[rowDash][colDash] == 1 && visited[rowDash][colDash] == false){
                dfs(rowDash, colDash, grid, queue, visited);
            }

        }
    }
}
