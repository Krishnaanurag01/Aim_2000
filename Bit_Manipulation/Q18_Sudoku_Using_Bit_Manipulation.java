package Bit_Manipulation;

public class Q18_Sudoku_Using_Bit_Manipulation {

    boolean solved;

    public void solveSudoku(char[][] board) {
        int[] row = new int[9]; // store visited val at thier bit position
        int[] col = new int[9];
        int[][] grid = new int[3][3]; // stores the identify of 3*3 matrix in one cell

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int val = board[i][j] - '0';
                row[i] |= (1 << val);
                col[j] |= (1 << val);
                grid[i / 3][j / 3] |= (1 << val);
            }
        }

        solved = false;
        solution(board, row, col, grid, 0, 0);
    }

    void solution(char[][] board, int[] row, int[] col, int[][] grid, int i, int j) {
        if (i == board.length) { // base condition
            solved = true; // turning the flag on
            return;
        }

        if (board[i][j] != '.') {
            solution(board, row, col, grid, j == board[0].length - 1 ? i + 1 : i, j == board[0].length - 1 ? 0 : j + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (((row[i] & (1 << num)) == 0) && ((col[j] & (1 << num)) == 0) && ((grid[i / 3][j / 3] & (1 << num)) == 0)) {

                    // visiting in row , col, grid
                    board[i][j] = (char) (num + '0');
                    row[i] ^= (1 << num);
                    col[j] ^= (1 << num);
                    grid[i / 3][j / 3] ^= (1 << num);

                    solution(board, row, col, grid, j == board[0].length - 1 ? i + 1 : i,j == board[0].length - 1 ? 0 : j + 1);

                    if (solved) return; // if already solved then it will not perform any more operation

                    // unvisiting
                    board[i][j] = '.';
                    row[i] ^= (1 << num);
                    col[j] ^= (1 << num);
                    grid[i / 3][j / 3] ^= (1 << num);
                }
            }
        }
    }

}
