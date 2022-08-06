package Problem_Of_The_day;
import java.util.*;

public class Q147_Evaluate_Reverse_Polish_Notation {

    // using stack.
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>() ;
        
        for(String s : tokens){
            
            if(s.equals("*")){
                int val1 = stack.pop() ;
                int val2 = stack.pop() ;
                
                stack.push(val2 * val1) ;
            }
            else if(s.equals("+")){
                
                int val1 = stack.pop() ;
                int val2 = stack.pop() ;
                
                stack.push(val2 + val1) ;
            }
            else if(s.equals("-")){
                
                int val1 = stack.pop() ;
                int val2 = stack.pop() ;
                
                stack.push(val2 - val1) ;
            }
            else if(s.equals("/")){
                
                int val1 = stack.pop() ;
                int val2 = stack.pop() ;
                
                stack.push(val2 / val1) ;
            }
            else{
                
                stack.push( Integer.valueOf(s));
            }
        }
        
        return stack.pop() ;
    }
}
