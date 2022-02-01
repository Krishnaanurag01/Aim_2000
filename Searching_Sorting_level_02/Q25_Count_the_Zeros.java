package Searching_Sorting_level_02;

public class Q25_Count_the_Zeros {
    
    int countZeroes(int[] arr, int n) {
        // code here
        
        int low = 0;
        int high = n-1 ;
        int ans = 0 ;
        
        while(low <= high){
            
            int mid = (high+low)/2 ;
            
            if(arr[mid] == 0 ){
                ans = n-mid;
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
            
        }
        
        return ans ;
        
    }
    
}
