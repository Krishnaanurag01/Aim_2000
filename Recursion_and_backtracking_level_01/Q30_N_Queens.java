package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q30_N_Queens {
 
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;

        int[][] chess = new int[n][n] ;

        printNQueens(chess,"",0) ;
        sc.close();

    }

    public static void printNQueens(int[][] chess, String qsf, int row) {

        if(row == chess.length){
            System.out.println(qsf+".") ;
            return ;
        }

        for(int col = 0 ; col < chess.length ; col++){
            if(isSafe(chess,row,col)){
                chess[row][col] = 1 ;

                printNQueens(chess,qsf+row+"-"+col+", ", row+1) ;
                chess[row][col] = 0 ;
            }
        }


    }


    public static boolean isSafe(int[][] chess , int row , int col ){

        
        // looking vertical
        for(int i = row ; i >= 0 ; i--){
            if(chess[i][col] == 1)
            return false ;
        }

        // we don't need to look horizontally as we are only placing one queen in one row
        // for(int i = col ; i >= 0 ; i--){
        //     if(chess[row][i] == 1)
        //     return false ;
        // }


        // looking diagonaly
        for(int i = row , j = col ; i >=0  && j >= 0 ; i-- , j--){
            if(chess[i][j] == 1)
            return false ;
        }

        for(int i = row , j = col ; i >=0  && j < chess.length ; i-- , j++){
            if(chess[i][j] == 1)
            return false ;
        }

        return true ;

    }


}
