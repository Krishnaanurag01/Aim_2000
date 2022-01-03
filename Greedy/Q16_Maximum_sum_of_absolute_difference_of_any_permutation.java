package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Q16_Maximum_sum_of_absolute_difference_of_any_permutation {

    
    public static void main(String[] args) {
        
        System.out.println( MaxSumDifference(new Integer[]{1,2,4,8}, 4)  );
    }




    // algo : first sort the array and then choose one smaller element with larger number, this way we'll get the maximum sum.


    static int MaxSumDifference(Integer []a, int n)
    {

        ArrayList<Integer> list = new ArrayList<>() ;

        Arrays.sort(a);
        System.out.println ( Arrays.deepToString(a )) ;

        for (int i = 0; i < n/2 ; i++) {
            list.add(a[i]);
            list.add( a[ n-1-i ]  ) ;
        }


        if(n % 2 !=0){
            list.add(a[n/2]) ; // adding the middle element when array is of odd length.
        }

        int max = 0 ;

        for (int i = 0; i < n-1; i++) {
            max += Math.abs( list.get(i) - list.get(i+1) ) ;
        }

        max += Math.abs(list.get(n-1) - list.get(0)) ;
     
        return max ;
    }
}
