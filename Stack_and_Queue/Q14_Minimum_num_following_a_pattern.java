package Stack_and_Queue;

import java.util.Stack;

public class Q14_Minimum_num_following_a_pattern {

    public static void main(String[] args) {
        
        System.out.println( printMinNumberForPattern("D") ) ;
    }

    static String printMinNumberForPattern(String S){
        
        String ans = "" ; // this will have our answer.

        Stack<Integer> stack = new Stack<>() ;

        int num = 1;

        for (int i = 0; i < S.length() ; i++) {

            char ch = S.charAt(i) ;
            
            if(ch == 'D'){ // if we have d then only add the number and increment it.
                stack.push(num++) ;
            }
            else{
                // else when I comes then add to the stack and remove all numbers from stack and add it to the answer.
                stack.push(num++) ; 
                while (stack.size() > 0) {
                    ans += stack.pop() ;
                }
            }
        }
        
        stack.push(num) ; // adding the last number.

        // now if any number left in stack then add it to the answer.
        while (stack.size() > 0) {
            ans += stack.pop() ;
        }

        return ans ;
    }
    
}
