package Problem_Of_The_day;
import java.util.*;

public class Q235_IPL_2021_Match_Day_2 {

    // sliding window maximum
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // using next greater element and sliding window concept.
          Stack<Integer> stack = new Stack<>();
          int[] next_greater = new int[n];
          next_greater[n - 1] = n;
  
          stack.push(n - 1);
          // stores next greater  for every element.
          for (int i = n - 2; i >= 0; i--) {
              while (stack.size() != 0 && arr[stack.peek()] <= arr[i]) {
                  stack.pop();
              }
              if (stack.size() == 0) {
                  next_greater[i] = n;
              } else if (arr[stack.peek()] > arr[i]) {
                  next_greater[i] = stack.peek();
              }
              stack.push(i);
          }
          
          ArrayList<Integer> ans = new ArrayList<>() ;
          int j = 0;
          for (int i = 0; i <= n - k; i++) {
  
              if (j < i) {
                  j = i;
              }
              // checking if next greater of current element is in the window then move there.
              while (next_greater[j] < i + k) {
                  j = next_greater[j];
              }
  
              ans.add(arr[j]) ;
          }
          return ans;   
      }
}
