package Recursion_and_backtracking_level_02;

import java.util.Scanner;

public class Q8_Solve_Sudoku {
    
    // for printing the elements
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
      }
    

      // check if current cell is valid or not
      public static boolean isValid(int[][] board, int row, int col, int val ){
    
        // checking current row's different col -> if some other cell already has val then return false
        for(int j = 0 ; j < board[0].length ; j++){
          if(board[row][j] == val)
          return false ;
        }
    
        // checking current col's different row
        for(int i = 0 ; i < board.length ; i++){
          if(board[i][col] == val)
          return false; 
        }
    
    // finding the top left corner of submatrix of size 3x3
        int smi = row/3 * 3 ; // submatrix i(row)
        int smj = col/3 * 3 ; // submatrix j(col)
    
        // checking if submatrix containing the val if yes then return false
        for(int i = 0 ; i < 3 ; i++){
          for(int j = 0 ; j < 3 ; j++){
    
            if(board[smi + i][smj + j] == val){
              return false;
            }
          }
        }
    
        return true ;
    
      }
    
      public static void solveSudoku(int[][] board, int i, int j) {
    
        if( i == board.length){ // when traversed all the row then print the answer
          display(board) ;
          return ;
        }
    
        int ni = i ; // next i(roww)
        int nj = j ; // next j (col)
    
        if(j == board[0].length-1){ // if j is the last col then it means we have to look in the next row
          ni = i+1 ; // so this is our new row
          nj = 0 ; // and starting new row with first column
        }
        else{
          ni = i ;  // else row remain same
          nj = j+1 ; // moving to next column
        }
    
        if(board[i][j] != 0){ // if current val is not 0 then move forward
          solveSudoku(board,ni,nj) ;
        }
        else{
    
            // checking value 1 to 9 validity for current cell
          for(int val = 1 ; val <= 9 ; val++){
            if(isValid(board,i,j,val) == true){ 
              // when valid then store val in current position and look for next 0
              board[i][j] = val ;
              solveSudoku(board,ni,nj) ;
              board[i][j] = 0 ; // unvisiting so that we can come up with the next solution
            }
          }
        }
    
    
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            arr[i][j] = scn.nextInt();
          }
        }
    
        solveSudoku(arr, 0, 0);
        scn.close();
      }
}
