package Greedy;

import java.util.Arrays;

public class Q21_Smallest_subset_with_sum_greater_than_all_other_elements {


    public static void main(String[] args) {
        
        int[] arr = {1,2,2} ;

        minElements(arr, arr.length) ;
    }


    static int minElements(int arr[], int n){

        Arrays.sort(arr);

        int sum = 0 ;

        for (int i : arr) {
            sum += i ;
        }

        int count = 0 ;
        int msum = 0 ;

        for (int i = n-1 ; i >= 0 ; i--) {
            
            sum -= arr[i] ;
            msum += arr[i] ;
            count++ ;
            if (sum < msum) {
                break ;
                // return count ;
            }

        }

        System.out.println(count);

        return 0 ;
    }
    
}
