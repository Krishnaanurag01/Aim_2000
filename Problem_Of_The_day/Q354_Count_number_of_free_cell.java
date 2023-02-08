package Problem_Of_The_day;
import java.util.*;

public class Q354_Count_number_of_free_cell {

    long[] countZero(int N, int K, int[][] arr){
        HashSet<Integer> rows = new HashSet<>() ;
        HashSet<Integer> cols = new HashSet<>() ;
        
        long[] ans = new long[K] ;
        int m = 0 ;
        
        for(int[] a: arr){
            rows.add(a[0]) ;
            cols.add(a[1]) ;
            
            long x = N - rows.size() ;
            long y = N - cols.size() ;
            ans[m++] = x*y ;
        }
        
        return ans ;
    }
}
