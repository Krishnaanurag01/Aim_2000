package Dynamic_Programming_level_02;

import java.util.*;

public class Q87_Pairs_with_specific_difference {


    public static void main(String[] args) {

        int[] arr = {3, 5, 10, 15, 17, 12, 9} ;

        getSum_of_all_pairs(arr, 4);
        
    }


    public static void getSum_of_all_pairs(int[] arr , int k) {

        Arrays.sort(arr) ; // just sort the array.
        int sum = 0 ;
        
        for (int i = arr.length - 1 ; i > 0 ; --i) {  // now traverse the array from last to 0+1st index and check
            
            if (arr[i] - arr[i-1] < k ) {  // if difference is less than k then do this
                sum += arr[i] ; // add both pairs in sum.
                sum += arr[i-1] ;
                --i ; // and also skip the next element as it is already paired with someone. so we go next i-1 -1(from loop) .
            }
        }

        System.out.println( sum );

    }
    //
}
