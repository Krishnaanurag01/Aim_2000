package Searching_Sorting_level_02 ;

public class Q15_Rotation {
    

    // same as Q14
    int findKRotation(int arr[], int n) {
        // code here
        
        // the index of min element == rotation count;
        if(arr[0] <= arr[n-1]){
            return 0 ;
        }
        
        int low = 0 ;
        int high = n-1 ;
        int ans = 0 ;
        
        while(low <= high){
            
            int mid = (low+high)/2 ;
            
            if( mid > 0 && arr[mid] < arr[mid - 1]) return mid ;
            if(mid < n && arr[mid] > arr[mid + 1]) return mid + 1 ;
            
            else if(arr[low] <= arr[mid]){
                low = mid + 1 ;
            }
            else if(arr[mid] <= arr[high]){
                high = mid - 1 ; 
            }
        }
        
        
        return ans ;
    }
}
