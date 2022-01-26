package Searching_Sorting_level_02;

public class Q3_Search_a_2D_Matrix {

    // method 01 : time comp could be O(n) in worst case

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

    // method 02 : using binary search
    
    
    public boolean searchMatrix2(int[][] matrix, int target) {
         
        int m = matrix.length  ; // row size
        int n = matrix[0].length  ; // column size
      
        // Step 01 : find the potential row 
        int poteRow = -1 ; // potential row

        // using binary search for finding the potential 
        int low = 0 ;
        int high = m-1 ;

        while (low < high) {
            
            int mid = (low+high)/2 ;

            if (matrix[mid][0] <= target && matrix[mid][n-1] >= target) {
                poteRow = mid ;
                break ;
            }
            else if(matrix[mid][0] >= target ){
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        if(poteRow == -1) return false ; // when no potential row present then return false directly.

        // Step 02 : find value in potential row using binary search.
        low = 0 ;
        high = n-1 ;

        while (low < high){

            int mid = (low+high)/2 ;

            if(matrix[poteRow][mid] == target){
                return true ;
            }
            else if(matrix[poteRow][mid] < target){
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
            
        }
            
        // if function comes here then return false becuase it did not found answer so far.
            
        return false; 
    }
}
