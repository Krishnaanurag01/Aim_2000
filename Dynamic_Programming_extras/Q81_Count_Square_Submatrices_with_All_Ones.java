package Dynamic_Programming_extras;

public class Q81_Count_Square_Submatrices_with_All_Ones {

    public int countSquares(int[][] matrix) {
        
        int count = 0 ;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                
                if(i == 0 || j == 0){ // keep first and first column as it is
                    if(matrix[i][j] == 1) count++ ;
                    continue ;
                }
                if(matrix[i][j] == 0) continue;
                // 1 + min(up,left,left diagonal)
                matrix[i][j] = 1 + Math.min(matrix[i][j-1], Math.min(matrix[i-1][j-1],matrix[i-1][j])); 
                
                count += matrix[i][j] ;
            }
        }
        
        return count ;
    }
}
