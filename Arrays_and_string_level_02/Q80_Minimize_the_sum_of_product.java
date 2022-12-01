package Arrays_and_string_level_02;
import java.util.*;

public class Q80_Minimize_the_sum_of_product {

    public long minValue(long a[], long b[], long n) 
    {
        long ans = 0 ;
        
        Arrays.sort(a) ;
        Arrays.sort(b) ;
        
        int i = 0 ;
        int j = (int)n-1 ;
        
        while(i < n){
            long min = a[i++]; 
            long max = b[j--];
            
            ans += (min*max) ;
        }
        
        return ans ;
    }
}
