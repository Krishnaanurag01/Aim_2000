package BackTracking;
import java.util.*;

public class Q1_N_Queen_problem {

    public static void main(String[] args) {
        
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here

        int[][] board = new int[n][n] ;


        placeQueen(board, new ArrayList<>() , 0);

        return null ;
    }


    static ArrayList<ArrayList<Integer>> queens = new ArrayList<>() ;


    private static void placeQueen(int[][] board, ArrayList<Integer> list, int row) {

        if(list.size() == board.length){
            queens.add(list) ;
            return ;
        }

        for (int col = 0; col < board.length; col++) {
            if(isItSafeHere(board,row,col) == true){
                board[row][col] = 1 ;

                list.add(row) ;

                placeQueen(board,list , row+1);
                

                int last = list.size() - 1  ;
                
                list.remove(last) ;

                board[row][col] = 0 ;

            }
        }
    }

    static boolean isItSafeHere(int[][] board , int row, int col){

        // looking vertical for queen.

        for (int i = row-1 , j = col ; i >= 0 ; i--) {
            if(board[i][j] == 1) return false ;
        }

        
        // looking left upper diagonal for queen.

        for (int i = row-1 , j = col - 1; i >= 0 && j >= 0 ; i-- ,j--) {
            if(board[i][j] == 1) return false ;
        }

        // looking right upper diagonal for queen.

        for (int i = row-1 , j = col + 1; i >= 0 && j < board.length ; i-- ,j++) {
            if(board[i][j] == 1) return false ;
        }


        return true ;

    }
    
}
