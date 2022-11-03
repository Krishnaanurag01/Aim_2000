package Problem_Of_The_day;
import java.util.*;

public class Q276_Array_Removals {

    int removals(int[] arr, int n, int k) {
        Arrays.sort(arr) ;
        int ans = 0 ;
        
        // taking each value of ith index and finding it's corrsp right value such that max - min <= k
        for(int i = 0 ; i < arr.length ; i++){
            int left = arr[i] ; // min value
            
            int low = i ;
            int high = n-1 ;
            
            // binary search
            while(low <= high){
                int mid = (low + high)/2 ;
                
                int right = arr[mid] ; // max value
            
            // if it is in range then check for higher values and update the answer with max size range    
                if(right - left <= k){
                    ans = Math.max(ans, mid - i + 1) ;
                    low = mid + 1 ;
                }
                else{ // otherwise check with lower values.
                    high = mid - 1 ;
                }
            }
           
        }
        
        return n - ans ;
    }
}
