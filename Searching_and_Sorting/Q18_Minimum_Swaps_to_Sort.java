package Searching_and_Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class Q18_Minimum_Swaps_to_Sort {
    public static void main(String[] args) {
        int[] arr = {2, 8, 5, 4};
       System.out.println(minSwaps(arr,arr.length));
    }

    // time complexcity : o(n log n) and space is o(n)
    public static int minSwaps(int[] arr,int n) {

        // creating a fake array so that we can sort it and find out the index of swapped element.
        int[] temp = Arrays.copyOfRange(arr, 0 , n);

        // here we are storing the index of original values of array.
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i ) ;  // storing in the form of : (value,index)
        }

        Arrays.sort(temp);

        int ans = 0;

        for (int i = 0; i < n ; i++) {

            if(arr[i] != temp[i]){                  // arr[i] is original where as temp array is sorted array with same element.
            // when arr[i] is not equal to temp[i] then it means that the element in arr at  i index gets swapped.
                ans++;  // thats why storing the result.

                int originalArrayElement = arr[i] ;   // now we are storing the original value of array becuase after swap operation it may changed. 

                swapIt(arr, i ,map.get(temp[i]));   // we are swapping the arr element of ith index with the element which is currently present in  temp array of ith index. so we look into the map and find the temp[i] value's original index and performed thee swap operation in original array.

                map.put(originalArrayElement,map.get(temp[i])); // now after swapped operation index will also swapped. so temp's value index becomes index of arr's value and vice versa.
                map.put(temp[i], i );  // I'm changing maps values because when we encounter arr[i] value in temp array then we have to swap again for different elements.
            }
            
        }

        


        return ans ;
    }
    private static void swapIt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j] ; 
        arr[j] = temp;
    }
}
