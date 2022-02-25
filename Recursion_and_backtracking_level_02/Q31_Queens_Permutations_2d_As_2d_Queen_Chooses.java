package Recursion_and_backtracking_level_02;
// import java.util.*;
import java.io.*;

public class Q31_Queens_Permutations_2d_As_2d_Queen_Chooses {

    public static void queensPermutations(int qpsf, int tq, int[][] chess ){
        

        if(qpsf == tq){
            // printing
          for(int i = 0 ; i < chess.length ; i++){
            for(int j = 0 ; j < chess.length ; j++){
              if(chess[i][j] == 0){
                System.out.print("-\t") ;
              }
              else{
                System.out.print( "q"+chess[i][j]+"\t" ) ;

              }
            }
            System.out.println() ;
          }
          System.out.println() ;
          return ;  
        }


        for(int i = 0 ; i < chess.length ; i++ ){
          for(int j = 0 ; j < chess[0].length ; j++){

            if(chess[i][j] == 0 ){ // denotes queen is not placed here

              chess[i][j] = qpsf + 1 ; // placing the previous placed queen +1 (new queen)
              queensPermutations(qpsf+1,tq,chess) ;
              chess[i][j] = 0 ; // backtracking
            }
          }

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
    
        queensPermutations(0, n, chess );
    }
    
}
