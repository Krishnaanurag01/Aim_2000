package Problem_Of_The_day;
import java.util.*;

/**
 * Q145_Find_the_Distance_Value_Between_Two_Arrays
 */
public class Q145_Find_the_Distance_Value_Between_Two_Arrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        Arrays.sort(arr2) ;
        
        int count = 0 ;
        
        for(int val : arr1){
            if(helper(arr2,val,d) == false) count++ ;
        }
        
        return count;
    }
    
    boolean helper(int[] arr, int val, int d){
        
        int low = 0 ;
        int high = arr.length - 1 ;
        
        while(low <= high){
            int val1 = Math.abs(val - arr[low]) ;
            int val2 = Math.abs(val - arr[high]) ;
            
            if(val1  <= d || val2 <= d) return true ;
            low++ ;
            high-- ;
        }
        
        return false;
    }
}