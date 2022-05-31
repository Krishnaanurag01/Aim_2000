package Graph_level_02;
import java.util.*;

// used 0-1 bfs, same as Q44
public class Q45_Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {

    public int minCost(int[][] grid) {
        
        int m = grid.length - 1 ;
        int n = grid[0].length - 1 ;
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> a[2] - b[2] ) ;
        q.add(new int[]{0,0,0});
        int[][] cost = new int[grid.length][grid[0].length];
        
        for(int[] c : cost)
            Arrays.fill(c,(int)1e9) ;
        
        
        int[][] direc = { {0,1},{1,0},{0,-1},{-1,0} } ;
        
        while(q.size() > 0){
            int size = q.size() ;
            while(size-- > 0){
                int[] rc = q.poll() ;
                
                if(rc[0] == m && rc[1] == n) return rc[2] ;
                
                for(int i = 0 ; i < 4 ; i++){
                    int nrow = rc[0] + direc[i][0] ;
                    int ncol = rc[1] + direc[i][1] ;
                    
                    if(nrow >= 0 && nrow <= m && ncol >= 0 && ncol <= n && rc[2] + 1 < cost[nrow][ncol]){
                        cost[nrow][ncol] = rc[2] +  1 ;
                        q.add(new int[]{nrow,ncol,cost[nrow][ncol]});
                    }
                }
                
                
                if(grid[rc[0]][rc[1]] == 1 && rc[1] + 1 <= n && rc[2] < cost[rc[0] ][ rc[1] + 1]){
                      cost[ rc[0] ][rc[1] + 1 ] = rc[2] ;
                        q.add(new int[]{rc[0],rc[1] + 1, rc[2] });
                }
                
                if(grid[rc[0]][rc[1]] == 2 && rc[1] - 1 >= 0 && rc[2] < cost[rc[0] ][ rc[1] - 1]){
                      cost[ rc[0] ][rc[1] - 1 ] = rc[2] ;
                        q.add(new int[]{rc[0],rc[1] - 1, rc[2] });
                }

                if(grid[rc[0]][rc[1]] == 3 && rc[0] + 1 <= m && rc[2] < cost[rc[0] + 1 ][ rc[1] ]){
                      cost[ rc[0] + 1 ][rc[1]  ] = rc[2] ;
                        q.add(new int[]{rc[0] + 1 ,rc[1], rc[2] });
                }

                if(grid[rc[0]][rc[1]] == 4 && rc[0] - 1 >= 0 && rc[2] < cost[rc[0] - 1 ][ rc[1]]){
                      cost[ rc[0] - 1 ][rc[1] ] = rc[2] ;
                        q.add(new int[]{rc[0] - 1 ,rc[1] , rc[2] });
                }
            }
        }
        
        return cost[m][n] ;
    }


}