package Stack_and_Queue;

import java.util.Stack;

public class Q3_Next_greater_element {
    

    // time comp : O(n)

    public static long[] nextLargerElement(long[] arr, int n)
    { 
      
        Stack<Long> stack = new Stack<>() ;
        long[] ans = new long[n] ;

        stack.push(arr[n-1]) ;
        ans[n-1] = -1 ;

        for (int i = arr.length - 2; i >= 0 ; i--) {
            
            while (stack.size() > 0 && stack.peek() < arr[i]) {
                stack.pop() ;
            }

            if(stack.empty()){
                ans[i] = -1 ;
            }
            else{
                ans[i] = stack.peek() ;
            }

            stack.push(arr[i]) ;
        }



        return ans ;
    } 


    // Another method : 

    public static int[] getNextGreater(int[] arr , int n) {
        int[] nge = new int[n] ;
        Stack<Integer> stack = new Stack<>() ;

        stack.push(0) ;

        for (int i = 1 ; i < arr.length; i++) {
            
            while (stack.size() > 0 && arr[i] > arr[stack.peek()]) { // popping all the smaller elements by adding current number as nge.
                int pos = stack.peek() ;
                nge[pos] = arr[i] ;
                stack.pop() ;
            }

            stack.push(i) ;
        }

        // all the left overs are assigned -1.
        while (stack.size() > 0) {
            int pos = stack.pop() ;

            nge[pos] = -1 ;
        }

        return nge ;
    }



}
