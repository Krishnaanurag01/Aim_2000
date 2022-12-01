package Arrays_and_string_level_02;
import java.util.*;

public class Q79_Swapping_pairs_make_sum_equal {
    

    long findSwapValues(long A[], int n, long  B[], int m)
    {
        Arrays.sort(A) ;
        Arrays.sort(B) ;
        
        long s1 = 0 ;
        long s2 = 0 ;
        
        // find the sum of both the arrays.
        for(int i = 0 ; i < Math.max(n,m) ; i++){
            if(i < A.length){
                s1 += A[i] ;
            }
            
            if(i < B.length){
                s2 += B[i] ;
            }
        }
        
        
        // now search for the pair whose swaping can make sum equal
        int i = A.length - 1 ;
        int j = B.length - 1 ;
        
        
        while(i >= 0 && j >= 0 ){
            long val1 = A[i] ;
            long val2 = B[j] ;
            
            long temp1 = s1 - val1 + val2 ; // this will be sum1 after swap
            long temp2 = s2 - val2 + val1 ; // this will be sum2 after swap
            
            if(temp1 == temp2) return 1 ; // if sum gets same return true
            
            if(temp1 > temp2){ // if sum1 gets larger means we are getting larger value from 2nd array so go to lesser value by decreasing j
                j-- ;
            }
            else{ // else decrease i
                i-- ;
            }
        }
        
        return -1 ;
        
        
        
    }
}
