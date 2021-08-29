package Searching_and_Sorting;


import java.util.Map;
import java.util.TreeMap;


public class Q39_Sorting_Arrays_with_repeated_elements_using_Hashmap {
 
    public static void main(String[] args) {

        int[] arr = {2,1,3,1,1,4,2,3,6,9,5};
        sort_using_hashing(arr);

        for (int i : arr) {
            System.out.println(i);
        }
        
    }

    // sorting without any basic sort algorithms like merge sort, quick sort e.t.c

    // using hashing : time comp : o(n + mlogm) here n is all the elements of array which are getting inserted in hashmap and m is all the distinct keys which we get from hashmap.

    public static void sort_using_hashing(int[] arr) {
        Map<Integer,Integer> map = new TreeMap<>(); // tree map sort it by default.

        for (int i : arr) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        int k = 0 ;

        for (var i : map.entrySet()) {
            
            int value = i.getValue();

            while (value-- > 0) {

                arr[k++] = i.getKey();                // overriding in the array.
            }
        }
        
       
    }
}
