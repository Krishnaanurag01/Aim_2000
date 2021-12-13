package Stack_and_Queue;

import java.util.Stack;

public class Q15_Smaller_on_Left {

    public static int[] Smallestonleft (int arr[], int n) {
        // Complete the function

        int[] ans = new int[n] ;

        ans[0] = -1 ;

        Stack<Integer> stack = new Stack<>() ;
        stack.push(arr[0]) ;

        for (int i = 1 ; i < ans.length ; i++) {

            while (stack.size() > 0 && stack.peek() >= arr[i]) {
                stack.pop() ;
            }

            if (stack.isEmpty()) {
                ans[i] = -1 ;
            }
            else{
                ans[i] = stack.peek() ;
            }

            stack.push(arr[i]);            
        }

        return ans ;
    }
    
}
