package Searching_Sorting_level_02;

public class Q29_Find_Transition_Point {
    
    int transitionPoint(int arr[], int n) {
        // code here
        
        int low = 0 ;
        int high = n-1 ;
        int ans = -1 ;

        // we are just finding the first position of 1 using binary search
        
        while(low <= high){
            int mid = (low+high)/2 ;
            
            if(arr[mid] == 1){
                ans = mid  ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        
        return ans ;
    }

}
