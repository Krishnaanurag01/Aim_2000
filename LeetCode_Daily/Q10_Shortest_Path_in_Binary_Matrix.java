package LeetCode_Daily;
import java.util.*;

public class Q10_Shortest_Path_in_Binary_Matrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0 ) return -1; // base case
        
        LinkedList<int[]> q= new LinkedList<>() ;
        q.add(new int[]{0,0,1}); // adding intial cell dimention and step number
        
        int[][] dirc = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        
        while(q.size() > 0){
            int size = q.size() ;
            while(size-- > 0){
                int[] rp = q.removeFirst() ;
                
                if(rp[0] == grid.length - 1 && rp[1] == grid[0].length -1){
                   return rp[2] ; // returning directly becuase this came first so obviously it is the smallest path
                }
                
                for(int k = 0 ; k < 8 ; k++){
                    int nr = rp[0] + dirc[k][0];
                    int nc = rp[1] + dirc[k][1] ;
                    if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == 0 ){
                        q.add(new int[]{nr,nc,rp[2] + 1}) ;
                        grid[nr][nc] = 1; // making visited.
                    }
                }
            }
        }
        
        return -1 ;
    }
}
