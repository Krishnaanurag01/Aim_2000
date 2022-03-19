package Bit_Manipulation;

import java.util.*;

public class Q18_Sudoku_Using_Bit_Manipulation {

  public static void display(int[][] arr){
    for (int ii = 0; ii < arr.length; ii++) {
      for (int jj = 0; jj < arr.length; jj++) {
        System.out.print(arr[ii][jj] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 9; j++) {
                int digit = scn.nextInt();
                arr[i][j] = digit;
                rows[i] = rows[i] | (1 << digit); // storing in row side for distinct
                cols[j] = cols[j] | (1 << digit); // storing in column side for distinct
                grid[i / 3][j / 3] = grid[i / 3][j / 3] | (1 << digit); // storing bits in 3*3 grid
            }

        }

        solveSudoku(arr, rows, cols, grid, 0, 0);
        scn.close();
    }

    private static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {

        if (i >= arr.length) {
            display(arr);
            return;
        }

        // when it is already filled
        if (arr[i][j] > 0) {   // moving to next row if on boundry
            solveSudoku(arr, rows, cols, grid, j == arr.length - 1 ? i + 1 : i , j == arr.length - 1 ? 0 : j + 1 ); // then move forward without doing anything
        }
        else{ // at 0th place.

            for (int num = 1 ; num <= 9 ; num++) {
                
                // checking in row , col and grid side if no one contains this number then proceeding further
                if( ( rows[i] & ( 1 << num ) ) == 0   &&  (cols[j] & ( 1 << num ) ) == 0 && ( grid[i/3][j/3] & (1 << num) ) == 0  ){ // means not present.

                    arr[i][j] = num ;
                    rows[i]= rows[i] ^ ( 1 << num ) ; // switching on in rows[i] side
                    cols[j] = cols[j] ^ ( 1 << num) ; // switching on in cols[i] side
                    grid[i/3][j/3]  ^= (1 << num) ;
                    solveSudoku(arr, rows, cols, grid, j == arr.length - 1 ? i + 1 : i , j == arr.length - 1 ? 0 : j +1 ); // moving ahead

                    // unvisiting or switching off num'th bit.
                    arr[i][j] = 0 ;
                    rows[i]= rows[i] ^ ( 1 << num ) ; // switching off in rows[i] side
                    cols[j] = cols[j] ^ ( 1 << num) ; // switching off in cols[i] side
                    grid[i/3][j/3]  ^= (1 << num) ;

                }
            }
        }
        return ;
    }

}
