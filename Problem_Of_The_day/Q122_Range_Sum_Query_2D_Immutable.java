package Problem_Of_The_day;

public class Q122_Range_Sum_Query_2D_Immutable {
    

    class NumMatrix {

        int[][] sum ;
        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length][matrix[0].length] ;
            
            for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 1 ; j < matrix[0].length ; j++){
                    matrix[i][j] += matrix[i][j-1] ;
                }
            }
            
            for(int i = 1 ; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[0].length ; j++){
                    matrix[i][j] += matrix[i-1][j] ;
                }
            }
            
            sum = matrix ;
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            
            int total = sum[row2][col2] ;
            // getting the extra value that is included in this total
            int extra = ( row1 > 0 ? sum[row1-1][col2] : 0 ) + (col1 > 0 ? sum[row2][col1-1] : 0) - (row1 > 0 && col1 > 0 ? sum[row1-1][col1-1] : 0) ;
            
            return total - extra ;
        }
    }
}
