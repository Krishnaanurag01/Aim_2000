package Stack_and_Queue_level01 ;
import java.util.*;



public class Q20_Score_of_Parentheses {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>() ;


        // -1 denotes '(' 
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char ch = s.charAt(i) ;
            
            if(ch == '('){ // if opening brackets arrives then add -1 to stack.
                stack.push(-1) ;
            }
            else{// else when ")"
            // checking if stack has opening (-1) if yes then remove and add 1 as [ () gives 1 point ]
                if(stack.peek() == -1 ){
                    stack.pop() ;
                    stack.push(1) ;
                }
                else{
                    // else claculate the value in between the opening and closing bracket 
                    int val = 0 ;
                    
                    while(stack.peek() != -1){
                        val += stack.pop() ; // calculating values
                    }
                    
                    stack.pop() ; // removing opening bracket 
                    stack.push(2*val) ; // and adding new value
                }
                
            }
            
        }
        
        int ans = 0 ; // ()() => with this the above loop will run but stack will have 1,1 so we have to handle this case by adding one more loop that will calculate the values.
        
        while(stack.size() > 0){
            ans += stack.pop() ;
        }
        
        return ans ;   
    }

    
}