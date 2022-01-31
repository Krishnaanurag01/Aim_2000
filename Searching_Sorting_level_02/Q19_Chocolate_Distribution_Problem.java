package Searching_Sorting_level_02;
import java.util.*;

public class Q19_Chocolate_Distribution_Problem {
    
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        
        Collections.sort(a) ;
        
        long max = Integer.MAX_VALUE ;
        
        for(int i = 0 ; i <= a.size() - m ; i++){
            max = Math.min( a.get(i+(int)m-1) - a.get(i) , max ) ; 
        }
        return max ;
    }

}
