package Searching_Sorting_level_02;
import java.util.*;

public class Q7_Find_k_closest_element_optimal_solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length ;
        int low = 0 ;
        int high = n - 1 ;
        
        // first finding the nearest element of x using binary search
        while(low <= high){
            int mid = (low+high)/2 ;
            if( x == arr[mid]){
                break;
            }
            else if(arr[mid] > x ){
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        
        List<Integer> ans = new ArrayList<>() ; // answer list
        
        int left = low - 1 ;  // this becomes the left side pointer
        int right = low ; // mid becomes the right side pointer
        
        while( left >= 0 && right < n && k-- > 0 ){ 
            
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ){ // if left side gap is less than equal then add left side one
                ans.add(arr[left]) ;
                left-- ;
            }
            else{ // else add right side one
                ans.add(arr[right]) ;
                right++ ;
            }       
        }
        
        // if k left then check which side elements available and add

        while(k > 0 && left >= 0){
            ans.add(arr[left--]) ;
            k--;
        }
        
        
        while(k > 0 && right < n){
            ans.add(arr[right++]) ;
            k--;
        }
        
        Collections.sort(ans) ;  // sorting the answer.
        
        return ans ;
    }
    
}
