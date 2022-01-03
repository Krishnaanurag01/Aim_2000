package Greedy;
import java.util.*;

public class Q17_Swap_and_Maximize {

    // same as question number q16

    long maxSum(long arr[] ,int n)
    {
        
        Arrays.sort(arr) ;
        
        List<Long> list = new ArrayList<>() ;
        
        for(int i = 0 ; i < n/2 ; i++){
            list.add(arr[i]) ;
            list.add(arr[n-i-1]) ;
        }
        
        if(n % 2 != 0 ){
            list.add( arr[ n/2 ] ) ;
        }
        
        
        long max = 0 ;
        
        for(int i = 0 ; i < n -1  ; i++){
            max += Math.abs(list.get(i) - list.get(i+1)) ;
        }
        
        max += Math.abs(list.get(n-1) - list.get(0)) ;
        
        return max ;
    
        
    }
    
}
