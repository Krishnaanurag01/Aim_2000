package Recursion_and_backtracking_level_02;
import java.io.*;

public class Q30_Queens_Combinations_2d_As_2d_Box_Chooses {
    
    public static void queensCombinations(int qpsf, int n , int row, int col , String asf){

        if(row == n){ // base case when row gets out of bound
          if(qpsf == n){
            System.out.println(asf) ;
          }
          return ;
        }
  
        int nr ; // new row
        int nc ; // new col
        String yasf ; // yes ans so far
        String nasf ; // no ans so far
  
        // findin next row and col
        if(col == n-1){
          nr = row+1 ;
          nc = 0 ;
          yasf = asf + "q"+ "\n";
          nasf = asf + "-"+ "\n";
        }
        else{
          nr = row ;
          nc = col + 1 ;
          yasf = asf + "q" ;
          nasf = asf + "-"  ;
         }
  
         // chossing once
          queensCombinations(qpsf+1, n , nr,nc,yasf);
  
          // not choosing queen
          queensCombinations(qpsf, n , nr,nc,nasf);
        
  
      
  
      }
      public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          
          queensCombinations(0, n ,0,0,"");
      }

}
