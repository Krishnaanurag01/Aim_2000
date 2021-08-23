package Searching_and_Sorting;

import java.util.Arrays;
import java.util.HashSet;

public class Q10_Find_Pair_Given_Difference {
    public static void main(String[] args) {
        
    }

    // using o(n) time and o(n) space.
    public static boolean pairWithGivenDifferenceExist(int[] arr, int difference) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer in : arr) {
            set.add(in);
        }

        for (int i = 0; i < arr.length; i++) {
            int element = difference + arr[i];
            if(set.contains(element)) return true;

        }
        return false;
    }

    // using o(n logn) time and o(1) space only.

    public static boolean findPairWithGivenDifference(int[] arr, int difference) {
        
        // first sort the array.
        Arrays.sort(arr);

        int i = 0 ; 
        int j = 1 ; 

        while (i < arr.length && j < arr.length) {
            if( i!=j && arr[j] - arr[i]== difference){
                return true;
            }
            else if( arr[j] - arr[i] < difference){
                // means we need bigger elements
                j++;
            }else{
                i++;
            }
        }

        return false;
    }
}
