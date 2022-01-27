package Arrays_and_string_level_02;

public class Q72_Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length ; // row length
        int m = matrix[0].length ; // col length
        
        boolean isRow = false ; // it denotes whether there exist any zero in first row
        boolean isCol = false ; // it denotes whether there exist any zero in first col     
        
        for(int i = 0 ; i < n ; i++) if(matrix[i][0] == 0) isCol = true ; // checking zero in first col
        for(int j = 0 ; j < m ; j++) if(matrix[0][j] == 0) isRow = true ; // checking zero in first row
        
        
        // now ignoring the first row and first column 
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0 ; // making 0 in the first col and that particular row
                    matrix[0][j] = 0 ; // making 0 in the first row and that particular col
                }
            }
        }
        
        // now making zero in row
        
        for(int i = 1 ; i < n ; i++){
           if( matrix[i][0] == 0 ){ // making zero in ith particular row
               for(int j = 1 ; j < m ; j++){
                   matrix[i][j] = 0 ;
               }
           }
        }
        
        
        // now making zero in column
        
        for(int j = 1 ; j < m ; j++){
           if( matrix[0][j] == 0 ){ // making zero in jth particular column
               for(int i = 1 ; i < n ; i++){
                   matrix[i][j] = 0 ;
               }
           }
        }
        
        
        // now checking the first row and first column previous variable value whether they contains zero previously.
        
        if(isRow){ // if there were any zero in first row then make complete first row 0
            for(int j = 0 ; j < m ; j++) matrix[0][j] = 0 ;
        }
        
        if(isCol){ // if there were any zero in first column then make first column completely 0
            for(int i = 0 ; i < n ; i++) matrix[i][0] = 0 ;
        }

        
    }
    
}
