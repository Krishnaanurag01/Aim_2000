package Searching_Sorting_level_02;

public class Q33_Row_with_max_1s {
    
    // method 01 :

    int rowWithMax1s(int arr[][], int n, int m) {
       
        
        int i = 0 ;
        int j = 0 ;
        
        while(j < m){
            
            if(arr[i][j] == 0){
                
                // finding row with 1
                for(int k = 0 ; k < n ; k++){
                    if(arr[k][j] == 1){
                        i = k ;
                        break ;
                    }
                }
            }
            
            
            if(arr[i][j] == 1){
                return i ;
            }

            j++;
        }
        
        return -1 ;
    }


    // method 01: O(N*logM)

    int rowWithMax1s_2(int arr[][], int n, int m) {

        int omax = 0 ;
        int row = 0 ; 

        for (int i = 0; i < n ; i++) {
            
            int onesFreq  = helper(arr,i,m) ; // applying binary search for each row

            if(onesFreq > omax){
                omax = onesFreq ;
                row = i ;
            }
        }

        return row;
    }


    private int helper(int[][] arr, int row, int colSize) {
       
        int low = 0 ;
        int high = colSize - 1 ;
        int max = 0 ;

        while (low <= high) {
            
            int mid = (low+high)/ 2 ;

            if( arr[row][mid] == 1 ){
                max = colSize - mid ;
                high = mid - 1 ; // for checking lesser index with 1 value
            }
            else{
                low = mid + 1 ;
            }

        }

        return max;
    }


}
