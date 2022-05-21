package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q39_Unique_Paths_III {

    public int uniquePathsIII(int[][] grid) {

        // si and sj is starting node index
        int si = 0 ;
        int sj = 0 ;
        /// ei and ej is ending node index
        int ei = -1;
        int ej = -1 ;
        
        // total white space cell.
        int tws = 0 ;

        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    si = i ;
                    sj = j ;
                }
                else if(grid[i][j] == 2){
                    ei = i ;
                    ej = j ;
                }
                else if(grid[i][j] == 0){
                    tws++ ;
                }
                else{
                    
                }
            }
        }
        HashSet<Integer> set = new HashSet<>() ;
        return helper(si,sj,grid,ei,ej,set,tws) ;
    }
    
    int helper(int si, int sj, int[][] grid, int ei, int ej, HashSet<Integer> set, int tws){
        if(si == ei && sj == ej){ // if current cell is ending cell then 
            if(set.size() == tws+1) return 1 ; // check whether we have visited every cell or not. if yes then count 1
            return  0 ; // else 0
        }
        
        if(si < 0 || si >= grid.length || sj < 0 || sj >= grid[0].length || grid[si][sj] == -1 ) return 0;
        
        int cell = si * grid[0].length  + sj ;
        set.add(cell) ;
        grid[si][sj] = -1 ; // making visited
        int count = 0 ;
        
        count += helper(si+1,sj,grid,ei,ej,set,tws) ;
        count += helper(si,sj+1,grid,ei,ej,set,tws) ;
        count += helper(si,sj-1,grid,ei,ej,set,tws) ;
        count += helper(si-1,sj,grid,ei,ej,set,tws) ;

        
                grid[si][sj] = 0 ; //unvisiting.

        set.remove(cell);
        
        return count ;
    }
}
