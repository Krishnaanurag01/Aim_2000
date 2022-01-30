package Arrays_and_string_level_02;

import java.util.*;

public class Q55_Design_TicTacToe {

    static class TicTacToe {

        static int n;
        static int[] rowSum; // this will contain information about last column
        static int[] colSum; // this will contain information about last row
        static int diag; // diagonal
        static int adiag; // reverse diagonal

        public TicTacToe(int n) {
            // this.n = n;
            rowSum = new int[n];
            colSum = new int[n];
        }

        public int move(int row, int col, int player) {

            /// increame 1 for player 1 and -1 for player 2

            int incre = 1; // bydefault considering increment 1

            if (player == 2)
                incre = -1;

            rowSum[row] += incre; // adding current val
            if (rowSum[row] == n || rowSum[row] == -n)  // if rowsum[row] become equal to n then it means all the position have incre in line which make sum as n and if it is -n then it means all position have -incre means player2 mark
                return player;

            colSum[col] += incre; // same as rowsum
            if (colSum[col] == n || colSum[col] == -n)
                return player;

            if (row == col) {
                // means diagonal
                diag += incre;
                if (diag == n || diag == -n) {
                    return player;
                }
            }

            if (row + col == n - 1) {
                // means reverse diagonal
                adiag += incre;
                if (adiag == n || adiag == -n) {
                    return player;
                }
            }

            return 0;

        }
    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        TicTacToe obj = new TicTacToe(n);
        for (int i = n * n; i >= 1; i--) {
            int ans = obj.move(scn.nextInt(), scn.nextInt(), scn.nextInt());

            System.out.println(ans);
            if (ans != 0)
                break;
        }

        scn.close();
    }

}
