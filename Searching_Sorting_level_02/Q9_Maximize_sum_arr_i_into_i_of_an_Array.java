package Searching_Sorting_level_02;
import java.util.*;

public class Q9_Maximize_sum_arr_i_into_i_of_an_Array {

    int Maximize(int arr[], int n)
    {
       Arrays.sort(arr);
 
   
    int mod = 1000000000+7 ;
    long sum = 0 ;
    
    for(int i = 0  ; i < n ; i++){
        
        sum = (sum % mod + (arr[i] * i )%mod ) % mod ;
    }
 
    return  (int)sum;
        
    }   
    
}
