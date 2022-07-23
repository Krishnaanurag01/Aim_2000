package Recursion_and_backtracking_level_02;
import java.util.*;

/**
 * Q41_Rat_in_a_Maze_Problem
 */
public class Q41_Rat_in_a_Maze_Problem {

    static ArrayList<String> ans ;
    public static ArrayList<String> findPath(int[][] m, int n) {
       ans = new ArrayList<>() ;
       helper(0,0,m,n, new StringBuilder() ) ;
       return ans ;
    }
    
    
    static void helper(int i, int j, int[][] m, int n, StringBuilder sb){
        if(i == n - 1 && j == n - 1 ){
            ans.add(sb.toString()) ;
        }
        
        if(m[i][j] == 0) return  ;
        
        m[i][j] = 0 ; // making 0 so this can't be traversed again
        
        if(i < n-1 && m[i+1][j] == 1){
            sb.append("D") ;
            helper(i+1,j,m,n,sb) ;
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(i > 0 && m[i-1][j] == 1){
            sb.append("U") ;
            helper(i-1,j,m,n,sb) ;
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(j < n-1 && m[i][j+1] == 1){
            sb.append("R") ;
            helper(i,j+1,m,n,sb) ;
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(j > 0 && m[i][j-1] == 1){
            sb.append("L") ;
            helper(i,j-1,m,n,sb) ;
            sb.deleteCharAt(sb.length()-1);
        }
        
        m[i][j] = 1 ; // reverting back
           
    }
}