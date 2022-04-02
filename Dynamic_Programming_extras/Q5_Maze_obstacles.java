package Dynamic_Programming_extras;
// import java.util.*;

public class Q5_Maze_obstacles {
   
    // same as Q4. optimal solution check explanation there
    // take O(m) space only

    public int uniquePathsWithObstacles(int[][] mat) {
    
        int n = mat.length ;
        int m = mat[0].length ;
        int[] prev = new int[m] ;
    
        // int mod = 1000000000 + 7 ;
        
        for(int i = 0 ; i < n ; i++){
            int[] temp = new int[m] ;
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0 ){
                    if( mat[i][j] == 1) return 0 ; // if the first cell if deadend then return 0
                    temp[j] = 1 ;
                }
                else if(mat[i][j] != 1){ // if not dead end then only calculate
                    
                    int up = i - 1 >= 0 ? prev[j] : 0 ;
                    int left = j - 1 >= 0 ? temp[j-1] : 0;
                    temp[j] = up + left ;
                }
            }
            prev = temp ;
        }
        
        return prev[m-1] ;
        
    }

    // take only O(1) space.
    // storing the result in given array.
    public int uniquePathsWithObstacles2(int[][] mat) {
        
        // int mod = 1000000000 + 7 ;
      int n = mat.length ;
      int m = mat[0].length ;
      for(int i = 0 ; i < n ; i++){
//             int[] temp = new int[m] ;
          for(int j = 0 ; j < m ; j++){
              if(i == 0 && j == 0 && mat[i][j] != 1 ){
                  mat[i][j] =  1 ;
              }
              else if(mat[i][j] != 1){
                  
                  int up = i - 1 >= 0 ?  mat[i-1][j] : 0 ;
                  int left = j - 1 >= 0 ?  mat[i][j-1] : 0;
                  mat[i][j] =  up + left  ;
              }
              else if(  mat[i][j] == 1 ){
                  mat[i][j] = 0 ;
              }
          }
//             prev = temp ;
      }
      
      return mat[n-1][m-1] ;
      
  }
    
}
