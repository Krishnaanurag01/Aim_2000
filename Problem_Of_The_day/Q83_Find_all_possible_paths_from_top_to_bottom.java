package Problem_Of_The_day;
import java.util.*;

public class Q83_Find_all_possible_paths_from_top_to_bottom {

    // Normal backtracking Question.

    static ArrayList<ArrayList<Integer>> ans ;
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
     
     ans = new ArrayList<>() ;
     helper(0,0,grid, new ArrayList<>()) ;
     return ans ;
    }
    
    static void helper(int i, int j, int[][] grid, ArrayList<Integer> list){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            list.add(grid[i][j]) ;
            ans.add( new ArrayList<>(list));
            list.remove(list.size() - 1 ) ;
            return;
        }
        if( i >= grid.length || j >= grid[0].length ) return ;
        
        list.add(grid[i][j]) ;
        helper(i+1,j,grid,list) ;
        helper(i,j+1,grid,list) ;
        list.remove(list.size() - 1 ) ;
    }
}
