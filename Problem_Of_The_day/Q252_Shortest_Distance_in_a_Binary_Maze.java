package Problem_Of_The_day;
import java.util.*;

public class Q252_Shortest_Distance_in_a_Binary_Maze {
    
    int shortestPath(int[][] grid, int[] source, int[] dest) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length] ;
        
        int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[2] - b[2]) ;
        pq.add( new int[]{source[0], source[1], 0}) ;
        
        while(pq.size() > 0){
            int[] rp = pq.poll() ;
            // System.out.println(rp[0]  + " -- " + rp[1] + " -- " + rp[2]) ;
            
            if(rp[0] == dest[0] && rp[1] == dest[1]){
                return rp[2] ;
            }
            
            if(visited[rp[0]][rp[1]] == true) continue ;
            visited[rp[0]][rp[1]] = true ;
            
            for(int[] d : direc){
                
                int x = rp[0] + d[0] ;
                int y = rp[1] + d[1] ;
                
                if(x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == 0 || visited[x][y] == true){
                    continue;
                }
                
                // visited[x][y] = true ;
                pq.add(new int[]{x, y, rp[2] + 1 }) ;
            }
        }
        
        return -1 ;
    }
}
