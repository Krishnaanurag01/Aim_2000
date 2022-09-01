package Binary_Search;

public class Q4_Find_a_Peak_Element_II {

    public int[] findPeakGrid(int[][] mat) {
        
        int low = 0 ;
        int high = mat.length - 1 ;
        
        while(low <= high){
            int midRow = low + (high-low)/2 ;
            
            int maxElemIdx = getMaxOfRow(mat,midRow) ; // getting the index of max elem of mid row.
            
            if(midRow == 0){ // if it is first row
                // check if below element is smaller or not
                if(midRow + 1 < mat.length && mat[midRow + 1][maxElemIdx] < mat[midRow][maxElemIdx]){
                    return new int[]{midRow, maxElemIdx};
                }
            }
            
            
            if(midRow == mat.length - 1){ // if last row. check upper value is smaller or not.
                if(midRow - 1 >= 0 && mat[midRow - 1][maxElemIdx] < mat[midRow][maxElemIdx]){
                    return new int[]{midRow, maxElemIdx};
                }
            }
            
            
            // when it lies in middle check both upper and lower neighbours.
            if(midRow - 1 >= 0 && midRow +1 < mat.length && mat[midRow - 1][maxElemIdx] < mat[midRow][maxElemIdx] &&
              mat[midRow + 1][maxElemIdx] < mat[midRow][maxElemIdx] ){
                return new int[]{midRow, maxElemIdx} ;
            }
            
            // if upper value is greater then go up
            if(midRow - 1 >= 0 && mat[midRow - 1][maxElemIdx] > mat[midRow][maxElemIdx]){
                    high = midRow - 1 ;
            } // else go down.
            else if(midRow + 1 < mat.length && mat[midRow + 1][maxElemIdx] > mat[midRow][maxElemIdx]){
                    low = midRow + 1 ;
            }
            
        }
        
        return new int[]{-1,-1} ;
    }
    
    
    // returns index of max element in any particular row.
    int getMaxOfRow(int[][] mat, int row){
        
        int max = (int)-1e9 ;
        int idx = -1 ;
        for(int i = 0 ; i < mat[0].length ; i++){
            if(mat[row][i] > max){
                max = mat[row][i] ;
                idx = i ;
            }
        }
        
        return idx ;
    }
}
