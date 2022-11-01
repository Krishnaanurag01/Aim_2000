package Problem_Of_The_day;

public class Q273_Toeplitz_Matrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        
        for(int i = matrix.length - 1; i >= 0 ; i--){
            
            int m = i ; 
            int n = 0 ;
            int prev = -1 ;
            
            while(m < matrix.length && n < matrix[0].length){
                if(prev == -1){
                    prev = matrix[m][n] ;
                }
                else if(matrix[m][n] != prev) return false;
                m++ ;
                n++ ;
            }
        }
        
        for(int j = 1 ; j < matrix[0].length ; j++){
            int m = 0 ;
            int n = j ;
            int prev = -1;
            
            while(m < matrix.length && n < matrix[0].length){
                if(prev == -1){
                    prev = matrix[m][n] ;
                }
                else if(matrix[m][n] != prev) return false;
                m++ ;
                n++ ;
            }
            
        }   
        
        return true;
    }
}
