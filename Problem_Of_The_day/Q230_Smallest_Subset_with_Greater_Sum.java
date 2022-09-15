package Problem_Of_The_day;
import java.util.*;

public class Q230_Smallest_Subset_with_Greater_Sum {
    int minSubset(int[] Arr,int N) { 
        
        if(N == 1) return 1 ;
        Arrays.sort(Arr) ;
        long sum = 0 ;
        
        for(int i = 0 ; i < N ; i++){
           sum += Arr[i] ; 
        }
        
        long back_sum = 0 ;
        
        for(int i = N - 1 ; i >= 1 ; i--){
            back_sum += Arr[i] ;
            if(back_sum > sum - back_sum) return N - i ;
        }
        
        return -1 ;
    }    
}
