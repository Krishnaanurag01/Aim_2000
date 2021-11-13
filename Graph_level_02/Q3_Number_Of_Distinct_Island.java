package Graph_level_02;
import java.util.*;
import java.io.*;


// distinct element means : island should not be of same shape , return the count of different shape island.


public class Q3_Number_Of_Distinct_Island {

    
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  
  public static void dfs(int[][] arr , int row , int col){
      
    // making array unvisited after visiting it.
      arr[row][col] = 0 ;
      
      if(row - 1 >= 0 && arr[row-1][col] == 1){ // if we can go up then
          psf.append("u"); // add "u" to the path  u =>> up
          dfs(arr,row-1,col); // now calling dfs.
      }
      
      if(row + 1 < arr.length && arr[row+1][col] == 1){ // if we can go down then
          psf.append("d"); // add "d" to the path d =>> down
          dfs(arr,row+1,col); // now calling dfs.
      }
      
      if(col - 1 >= 0 && arr[row][col-1] == 1){ // if we can go left then
          psf.append("l"); // add "l" to the path l =>> left
          dfs(arr,row,col-1); // now calling dfs.
      }
      
      if(col + 1 < arr[0].length && arr[row][col+1] == 1){ // if we can go right then
          psf.append("r");// add "r" to the path r =>> right
          dfs(arr,row,col+1); // now calling dfs.
      }
    
      // adding z for backtracking.
      psf.append("z") ;
  }

  public static StringBuilder psf = new StringBuilder(); // help in making the path.

  public static int numDistinctIslands(int[][] arr) {
    //write your code here
    HashSet<String> set = new HashSet<>(); // we'll store all the path in this and set doesn't contain any duplicate element so it will return distint count of paths.
    
    for(int i = 0 ; i < arr.length ; i++){
        for(int j = 0 ; j < arr[0].length ; j++){
            
            if(arr[i][j] == 1){ // if the element is 1 then
                psf = new StringBuilder(); // assign new string in path so far( psf)
                psf.append("x"); // append x for current element
                dfs(arr,i,j); // and call dfs
                set.add( psf.toString() ) ; // now adding psf
            }
        }
        
    }
    
    // returning the count of distinct paths.
    return set.size() ;
  }
  
  
    
}
