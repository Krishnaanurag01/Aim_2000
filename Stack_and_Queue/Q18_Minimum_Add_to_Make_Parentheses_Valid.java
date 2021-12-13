package Stack_and_Queue;

import java.util.Stack;

public class Q18_Minimum_Add_to_Make_Parentheses_Valid {

    public int minAddToMakeValid(String s) {
     
        Stack<Character> stack = new Stack<>() ;

        for (int i = 0; i < s.length() ; i++) {
            
            char ch = s.charAt(i) ;
            if(ch == ')'){

                if(stack.size() > 0 && stack.peek() == '('){
                    // removing from if both opening and closing are together
                    stack.pop();
                }
                else{
                    // else adding to the stack.
                    stack.push(ch) ;
                }

            }
            else{
                    // else adding to the stack;
                stack.push(ch) ;
            }
        }
        
        // stack size denotes the number of parantheses needed to balance
        return stack.size() ;
    }
    
}
