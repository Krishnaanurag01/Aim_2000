package Searching_and_Sorting;

import java.util.*;


public class Q37_Count_Inversion {
    
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        long[] arr = new long[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0 , arr.length-1);
        System.out.println(count);
        sc.close();
        
    }

    public static long[] mergeSort(long[] arr , int low , int high) {
        
        if( low == high ){

            long[] number = new long[1];
            number[0] = arr[low];
            return number;
        }

        int mid = low + ( high - low)/2 ;

        long[] left = mergeSort(arr, low , mid);
        long[] right = mergeSort(arr, mid+1, high);
        long[] merged = mergeTwoSortedArrays(left,right);

        return merged;
    }

    static long count = 0;

    private static long[] mergeTwoSortedArrays(long[] left, long[] right) {

        long[] mergedArray = new long[left.length + right.length];

        int i = 0 ;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {

            if(left[i] <= right[j]){
                mergedArray[k++] = left[i++];
            }
            else{ // when right side is smaller then it means it has to swap with left.length - i elements(this is rest elements) of left array.
                count += (left.length - i) ; 
                mergedArray[k++] = right[j++];
            }
        }

        while (i < left.length) {
            mergedArray[k++] = left[i++];
        }

        while (j < right.length) {
            mergedArray[k++] = right[j++];
        }




        return mergedArray;
    }
}
