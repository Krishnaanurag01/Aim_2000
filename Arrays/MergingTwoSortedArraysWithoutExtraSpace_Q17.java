package Arrays;

import java.util.Arrays;

/**
 * MergingTwoSortedArraysWithoutExtraSpace_Q17
 */
public class MergingTwoSortedArraysWithoutExtraSpace_Q17 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        mergingWithoutExtraSpace(arr1, arr2, arr1.length, arr2.length);
        for (int i : arr1) {
            System.out.print(i+" ");
                }
            System.out.println();
            for (int i : arr2) {
            System.out.print(i+" ");
            }

    }
    public static void mergingWithoutExtraSpace(int[] arr1 , int[] arr2, int n , int m) {

        //method 1 with o(1) space complexcity.
        int p =n-1 , k =0 ;
        while (p>= 0 && k < m) {
            if (arr1[p]>arr2[k]) {
                int temp = arr1[p];
                arr1[p] = arr2[k];
                arr2[k] = temp;                
            }
            p--;
            k++;            
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
       
        
    }
}