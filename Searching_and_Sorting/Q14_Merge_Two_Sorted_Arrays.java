package Searching_and_Sorting;

import java.util.Arrays;

public class Q14_Merge_Two_Sorted_Arrays {
    public static void main(String[] args) {

        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
        mergeIt_WithoutExtraSpace(arr1, arr2);

        for (int i : arr1) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i : arr2) {
            System.out.print(i+" ");
        }
        
    }

    public static void mergeIt_WithoutExtraSpace(int[] arr1 , int[] arr2) {

        // arr1[] = {0, 1, 2, 3}                         arr1[] = {1, 3, 5, 7}
        // arr2[] = {5, 6, 7, 8, 9}                      arr2[] = {0, 2, 6, 8, 9}
                      
        
        int i = 0 ;
        int k = arr1.length-1 ;
        int j = 0;

        while (i <= k && j < arr2.length) {

            if(arr1[i] < arr2[j]){
                // if first array of ith element is smaller then we'll look for larger numbers.
                i++;
                continue;
            }
            else{
                // now when ith element is larger than jth element of array 2 then it means kth element is also larger as k is largers and starts from end in array 1 and both array are sorted. so we'll swap last element of array 1 with array 2.

                int temp = arr1[k];
                arr1[k] = arr2[j] ;
                arr2[j] = temp ;                            // we are not swaping from first index in array 1 as array is sorted and there might be a chance that ith element stays in array1.
                k--;
                j++;
            }
            
        }

        // after that simply sort both arrays.

        Arrays.sort(arr1);
        Arrays.sort(arr2);

    





    }
}
