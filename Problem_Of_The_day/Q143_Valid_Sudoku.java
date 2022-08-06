package Problem_Of_The_day;

public class Q143_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
     
        // storing mask for each row, each col and each 3*3 submatrix in matrix
        int[] row = new int[board.length] ;
        int[] col = new int[board[0].length];
        int[][] matrix = new int[3][3] ;
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == '.') continue ;
                int val = board[i][j] - '0' ;
                
                // if the row already has it
                if( (row[i] & (1 << val)) != 0 ){
                    return false ;
                }
                else{
                    row[i] = row[i] | (1 << val) ;
                }
                
                
                 // if the col already has it
                if( (col[j] & (1 << val)) != 0 ){
                    return false ;
                }
                else{
                    col[j] = col[j] | (1 << val) ;
                }
                
                
                 // if the matrix already has it
                if( (matrix[i/3][j/3] & (1 << val)) != 0 ){
                    return false ;
                }
                else{
                    matrix[i/3][j/3] = matrix[i/3][j/3] | (1 << val) ;
                }
                
            }
        }
        
        
        return true;
    }
}
