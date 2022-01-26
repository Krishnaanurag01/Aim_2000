package Searching_Sorting_level_02;

public class Q4_Search_a_2D_Matrix_II {

    // method 01 : time comp could be O(n) in worst case
    // binary search will not work here as we won't be able to identify the potential row.

    public boolean searchMatrix(int[][] matrix, int target) {
         
        int m = matrix.length  ;
        int n = matrix[0].length  ;
      
        
        int i = 0 ; 
        int j = n-1 ;
        
        while(i < m && j >= 0 ){
            
            if(matrix[i][j] > target){
                j-- ;
            }
            else if(matrix[i][j] < target){
                i++ ;
            }
            else{
                return true ;
            }
        }
            
            
        return false; 
    }
    
}
