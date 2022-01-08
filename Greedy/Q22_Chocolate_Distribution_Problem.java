package Greedy;
import java.util.*;

public class Q22_Chocolate_Distribution_Problem {

    public static void main(String[] args) throws Exception {
        

        ArrayList<Long> list = new ArrayList<>() ;
        
       long[] arr = {3, 4, 1, 9, 56, 7, 9, 12} ;
       for (Long i : arr) {
           list.add(i) ;
       }

        int m = 5 ;

        findMinDiff(list, arr.length , m) ;
        
    }
    
    public static long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        

        // algo : just sort the list and find the max(of 5th child) -min(of 1st child) 


        Collections.sort(a) ;
        System.out.println( a );
        long min = Integer.MAX_VALUE ;
        
        for(int i = 0 ; i <= n-m ; i++){

            min = Math.min(min,a.get(i+ (int)m - 1) - a.get(i)) ;
        }
        
        System.out.println(min);
        return min ;
    }
}
