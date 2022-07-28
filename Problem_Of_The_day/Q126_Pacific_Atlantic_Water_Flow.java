package Problem_Of_The_day;
import java.util.*;

public class Q126_Pacific_Atlantic_Water_Flow {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>() ;
        if(heights == null || heights.length == 0 || heights[0].length == 0) return ans ;
        
        int row = heights.length ;
        int col = heights[0].length ;
        boolean[][] pacific = new boolean[heights.length][col] ;
        boolean[][] atlantic = new boolean[heights.length][col] ;
        
        // filling cells whether they are pacific or atlantic or not.
        
        for(int j = 0 ; j < col ; j++){
            dfs(0,j,-1 ,heights,pacific) ;
            dfs(row-1,j,-1, heights, atlantic) ;
        }
        
        for(int i = 0 ; i < row ; i++){
            dfs(i,0,-1, heights,pacific) ;
            dfs(i,col-1,-1, heights, atlantic);
        }
        
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(pacific[i][j] && atlantic[i][j]) // if current cell is connected to both oceans then add it to answer.
                ans.add(Arrays.asList(i,j)) ;
            }
        }
        
        return ans ;
    }
    
    int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}};
    
    void dfs(int i, int j, int prev, int[][] matrix, boolean[][] ocean){
        if(i < 0 || j < 0 || i >= ocean.length || j >= ocean[0].length) return ;
        if(matrix[i][j] < prev || ocean[i][j]) return  ; // means false or already visited
        ocean[i][j] = true ; // true  becuase it is greater than or equal to prev element.
        
        for(int[] d : direc){
            dfs(i+ d[0], j + d[1], matrix[i][j], matrix, ocean) ;
        }
    }
}
