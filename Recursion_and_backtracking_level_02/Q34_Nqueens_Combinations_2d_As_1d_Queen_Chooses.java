package Recursion_and_backtracking_level_02;
import java.io.*;

public class Q34_Nqueens_Combinations_2d_As_1d_Queen_Chooses {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
       
        // checking all four direcion that is row , col and both upper diagonal
        for(int j = col ; j >= 0 ; j--){
            if(chess[row][j] == true){
                return false ;
            }
        }
 
        for(int j = row ; j >= 0 ; j--){
            if(chess[j][col] == true){
                return false ;
            }
        }
 
        for(int i = row , j = col ; i >= 0 && j >= 0 ; j-- , i--){
            if(chess[i][j] == true){
                return false ;
            }
        }
 
 
        for(int i = row , j = col ; i >= 0 && j < chess.length ; j++ , i--){
            if(chess[i][j] == true){
                return false ;
            }
        }
        
        return true ;
 
     }
 
     // this is same as previous questions.
     public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
         if (qpsf == tq) {
             for (int row = 0; row < chess.length; row++) {
                 for (int col = 0; col < chess.length; col++) {
                     System.out.print(chess[row][col] ? "q\t" : "-\t");
                 }
                 System.out.println();
             }
             System.out.println();
             return;
         }
 
         for (int i = lcno + 1; i < chess.length * chess.length; i++) {
             int row = i / chess.length;
             int col = i % chess.length;
 
             if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                 chess[row][col] = true;
                 nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                 chess[row][col] = false;
             }
         }
     }
 
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         boolean[][] chess = new boolean[n][n];
 
         nqueens(0, n, chess, -1);
     }
    
}
