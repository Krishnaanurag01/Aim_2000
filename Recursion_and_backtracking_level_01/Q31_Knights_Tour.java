package Recursion_and_backtracking_level_01;

import java.util.Scanner;

public class Q31_Knights_Tour {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;// dimension of chess board (n*n)
        int r = sc.nextInt() ; // current row
        int c = sc.nextInt() ; // current col

        int[][] chess = new int[n][n] ;

        printKnightsTour(chess,r,c,1) ; // giving move == 1 by default
        sc.close();
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        
        if(r < 0 || r >= chess.length || c < 0 || c >= chess.length || chess[r][c] != 0 ){
            return ;
        }
        else if(move == chess.length*chess.length){ // when move is == n*n i.e : if move is 25 and chess board is 5*5 that means we have visited all the cells so this is one of our answer.
            chess[r][c] = move ;
            displayBoard(chess) ;
            chess[r][c] = 0; 
        }

        chess[r][c] = move ; // storing move will work as visiting the current cell

        // going to all 8 directions
        printKnightsTour(chess,r-2,c+1,move+1) ;
        printKnightsTour(chess,r-1,c+2,move+1) ;
        printKnightsTour(chess,r+1,c+2,move+1) ;
        printKnightsTour(chess,r+2,c+1,move+1) ;
        printKnightsTour(chess,r+2,c-1,move+1) ;
        printKnightsTour(chess,r+1,c-2,move+1) ;
        printKnightsTour(chess,r-1,c-2,move+1) ;
        printKnightsTour(chess,r-2,c-1,move+1) ;

        chess[r][c] = 0 ; // unvisiting
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
