package Arrays;

import java.util.Scanner;

public class Radix_Sort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;

        int[] arr = new int[n] ;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt() ;
        }
        

        Radix_sorting(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
        sc.close(); 
    }

    public static void Radix_sorting(int[] arr) {
        
        int max = Integer.MIN_VALUE ; // finding the max value becuase this is length we use for sorting.

        for (int i : arr) {
            max = Math.max(max, i);
        }

        int exp = 1 ; // this will help in dividing the value then % 10 to get digits of numbers.

        while (exp <= max) {
            sort_with_count_sort(arr, exp); // calling function from 1 to length of max.
            
            exp *= 10 ; // so first time number gets divided by 1 then 10 then 100... 
        }
    }
    


    // counting algo used here.
    public static void sort_with_count_sort(int[] arr, int exp) {
        
        /// making an frequency array that will store the frequency of elements.

        int[] farr = new int[10] ; // making array of 0 to 9 digits. this store the freq.

        for (int i = 0; i < arr.length ; i++) { // storing frquency.
            int val = arr[i] ;
            farr[val /exp % 10]++ ; // this increase freq by finding the digit ( value / exp % 10).
        }

        // now making pre sum array.

        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i-1] ;
        }


        // now traversing the original array from last.
        int[] ans = new int[arr.length] ; // this will store the sorted values .

        for (int i = arr.length - 1 ; i >= 0; i--) {
            int val = arr[i] ;
            int pos = farr[val / exp % 10] ; // again fidning the pos
            int index = pos-1 ;

            ans[index] = val ; // storing in new array
            farr[val / exp % 10]-- ; // now decresing the freq,
        }

        // now storing in the original array.

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i] ;
        }


    }
}
