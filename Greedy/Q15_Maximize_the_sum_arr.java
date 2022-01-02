package Greedy;

import java.util.Arrays;

public class Q15_Maximize_the_sum_arr {

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
