package Graph_level_01;

import java.io.*;

public class Q10_Knights_Tour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // board size of n*n
        int r = Integer.parseInt(br.readLine()); // current row
        int c = Integer.parseInt(br.readLine()); // current col

        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove){
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0){  // if index goes out of bound or chess[r][c] is not 0 then it means knight already walked there so return.
            return;
        } else if(upcomingMove == chess.length * chess.length){  // if the move becomes equal to board length : eg : move is 25 and board size is 25 as well (5*5) then it means we walked all the path so print.
            chess[r][c] = upcomingMove; // placing current move
            displayBoard(chess); // and printing 
            chess[r][c] = 0;    // then removing move for next iteration.
            return;
        }

        chess[r][c] = upcomingMove; 

        // running in all 8 direction knight can move.
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2 , upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2 , upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1 , upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1 , upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2 , upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2 , upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1 , upcomingMove + 1);
        chess[r][c] = 0;
    }

    // this will print the chess board.
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
