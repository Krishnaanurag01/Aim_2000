package Arrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Maximum_of_allsubarrays_of_size_k {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        max_of_subarrays(arr, n, k);

        sc.close(); 

    }


    // *************** sliding window maximum **********************

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here

        ArrayList<Integer> ansList = new ArrayList<>();

        // storing the next greater element in an array.

        Stack<Integer> stack = new Stack<>(); // this will help in finding the next greater element.
        int[] next_greater = new int[n]; // making an array each element will store the index of next greater element.
        next_greater[n - 1] = n; // alast element of array will have no greater elements on right so storing n or infinity.

        stack.push(n - 1); // adding the last index of array.

        for (int i = n - 2; i >= 0; i--) { // now runnning from n-2 to 0.

            while (stack.size() != 0 && arr[stack.peek()] <= arr[i]) { // removing element from stack until we found the arr[index] which is greater than current element arr[i]. 
                stack.pop(); // so removing
            }

            if (stack.size() == 0) { // if the stack becomes empty then that means we didn't find any greater element so storing n.
                next_greater[i] = n;
            } else if (arr[stack.peek()] > arr[i]) {
                next_greater[i] = stack.peek(); // elese storing the index of greater element.
            }

            stack.push(i); // adding current index.
        }

        int j = 0;

        for (int i = 0; i <= n - k; i++) {

            if (j < i) { // when j becomes less than i then make j == i 
                j = i;
            }

            while (next_greater[j] < i + k) { // while j index is in between i+k ( window size) then keep finding next greater index.
                j = next_greater[j];
            }

            ansList.add(arr[j]) ; // now adding the latest greater element ( arr[j]) 
        }

        int[] ans = new int[ansList.size()] ;

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i) ;
        }

        return ansList;
    }
}
