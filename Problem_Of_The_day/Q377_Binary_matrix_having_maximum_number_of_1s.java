package Problem_Of_The_day;

public class Q377_Binary_matrix_having_maximum_number_of_1s {

    public int[] findMaxRow(int mat[][], int N) {
        int[] ans = {0,0} ;
        
        for(int i = 0 ; i < N ; i++){ // for each row
        // applying binary search toh find the count of 1's
            int low = 0 ; 
            int high = N - 1 ;
            
            while(low <= high){
                int mid = low + (high - low)/2 ; 
                
                if(mat[i][mid] == 1){
                    high = mid - 1 ;
                }
                else{
                    low = mid + 1 ;
                }
            }
            
            int freq = N - low ;
            
            // and storing the ans with max freq row
            if(ans[1] < freq){
                ans[0] = i ;
                ans[1] = freq  ;
            }
        }
        
        
        return ans ;
    }
}
