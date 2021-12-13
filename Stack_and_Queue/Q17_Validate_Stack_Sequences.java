package Stack_and_Queue;

import java.util.Stack;

public class Q17_Validate_Stack_Sequences {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    
        Stack<Integer> stack = new Stack<>() ;

        int p = 0 ;

        for (int i = 0; i < popped.length; i++) {
            
            while (stack.size() > 0 && stack.peek() == popped[p]) { // if the elment is same then pop it and increament the pointer of popped arr.
                stack.pop() ;
                p++ ;
            }

            stack.push(pushed[i]) ; // pushing the value to the stack.
        }
        
        while (stack.size() > 0 && stack.peek() == popped[p]) { // if elements left then process it.
                stack.pop() ;
                p++ ;
            }
        
            // if the stack becomes empty then return true else false.
            
        return stack.isEmpty() ;
    }

}
