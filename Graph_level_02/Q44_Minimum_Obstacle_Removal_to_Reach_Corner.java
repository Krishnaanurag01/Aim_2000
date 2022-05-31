package Graph_level_02;
import java.util.*;

public class Q44_Minimum_Obstacle_Removal_to_Reach_Corner {

    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length ; 
        int n = grid[0].length ;
        
        int[][] direc = {{0,1},{1,0},{-1,0},{0,-1}} ;
        int[][] cost = new int[m][n] ;  // intializing with infinity.
        
        for(int[] c : cost)
            Arrays.fill( c , (int)1e9 ) ;
        
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> a[2] - b[2] ) ;// sorting based on weight.
        q.add( new int[]{ 0 , 0 , grid[0][0] }) ;
        cost[0][0] = grid[0][0] ;
        
        while( q.size() > 0 ){
            int[] rp = q.poll() ;
            
            if(rp[0] == m-1 && rp[1] == n-1) return rp[2] ;
            
            for(int i = 0 ; i < 4 ; i++){
                int nrow = rp[0] + direc[i][0] ;           
                int ncol = rp[1] + direc[i][1] ;
                
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && rp[2] + grid[nrow][ncol] < cost[nrow][ncol] ){
                    cost[nrow][ncol] = rp[2] + grid[nrow][ncol] ;
                    q.add(new int[]{nrow,ncol,cost[nrow][ncol]});
                }
            }
        }
        
        return cost[m-1][n-1] ;
        
    }
}
