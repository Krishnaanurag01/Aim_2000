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

        boolean flag = false ;
        
        for(int i = 0 ; i < grid.length && flag == false ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1){
                  dfs(i,j,grid,queue,visited) ;  
                  flag = true ;
                  break ;
                }
                
            }
        }
        
        
        int level = 0 ;
        
        while (queue.size() > 0) {

            int size = queue.size() ;
            
            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                
                for (int i = 0; i < 4 ; i++) {
                    int rowDash = rem.x + directions[i][0];
                    int colDash = rem.y + directions[i][1];
                    
                    if(rowDash < 0 || rowDash >= grid.length || colDash < 0 || colDash >= grid[0].length || visited[rowDash][colDash] == true){
                        continue;
                    }
                    
                    if(grid[rowDash][colDash] == 1){
                        return level ;
                    }
                    
                    queue.addLast(new Pair(rowDash, colDash));
                    
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

    private void dfs(int i, int j, int[][] grid, LinkedList<Pair> queue, boolean[][] visited) {

        visited[i][j] = true ;
        queue.addLast(new Pair(i, j));

        for (int k = 0; k < 4 ; k++) {
            int rowDash = i + directions[k][0] ;
            int colDash = j + directions[k][1] ;

            if(rowDash >= 0 && rowDash < grid.length && colDash >= 0 && colDash < grid[0].length && grid[rowDash][colDash] == 1 && visited[rowDash][colDash] == false){
                dfs(rowDash, colDash, grid, queue, visited);
            }

        }
    }
}
