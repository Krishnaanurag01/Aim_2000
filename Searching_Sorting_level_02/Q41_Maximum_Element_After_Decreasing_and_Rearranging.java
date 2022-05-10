package Searching_Sorting_level_02;
import java.util.*;

public class Q41_Maximum_Element_After_Decreasing_and_Rearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr) ; // sorting will arrange the element
        int max = 1 ;
        
        if(arr[0] != 1){ // if after sorting first element is still greater then simply decrease that number to 1.
                arr[0] = 1 ;
        }
        
        for(int i = 1 ; i < arr.length ; i++){ // now checking adjecent difference
            if(Math.abs(arr[i] - arr[i-1]) > 1){ // if high difference then decrease the value
                arr[i] = arr[i-1] + 1 ;
            }
            max = Math.max(max,arr[i]) ; // updating the answer.
        }

        return max ;
    }
}
