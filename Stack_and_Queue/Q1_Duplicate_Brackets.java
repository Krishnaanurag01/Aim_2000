package Stack_and_Queue;

import java.util.Stack;

public class Q1_Duplicate_Brackets {
    public static void main(String[] args) {
        
    }

    public static boolean hasDuplicate(String expr) { /// (a + b) + ((c + d))
        
        Stack<Character> stack = new Stack<>() ;

        for (int i = 0; i < expr.length() ; i++) {
            
            char ch = expr.charAt(i) ;

            if(ch == ')'){ // when closing bracket appears.
                if(stack.peek() == '('){ // check if stack has opening one then it means duplicacy is here
                    return true ;
                }else{
                    while(stack.size() > 0 ){ // otherwise pop until you get the opening side
                        char ch2 = stack.pop() ;
                        if(ch2 == '('){
                            break ;
                        }
                    }
                }
            }
            else{ // addding to the stack
                stack.push(ch) ;
            }
        }



        return false ;
    }
}
