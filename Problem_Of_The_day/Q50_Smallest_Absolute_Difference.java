package Problem_Of_The_day;
import java.util.*;

public class Q50_Smallest_Absolute_Difference {
    
    public long kthDiff(long arr[], long n, long k)
    {
        ArrayList<Long> list = new ArrayList<>() ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                long num = Math.abs( arr[i] - arr[j] ) ; // absolute difference
                list.add(num) ;
            }
        }
        
        Collections.sort(list) ;
        
        // System.out.println(list) ;
        return list.get((int)k-1) ;
        
    }
}
