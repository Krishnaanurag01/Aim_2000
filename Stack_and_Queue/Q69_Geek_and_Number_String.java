package Stack_and_Queue;
import java.util.*;

public class Q69_Geek_and_Number_String {

    public int minLength(String s, int n) {
        
        Stack<Integer> stack = new Stack<>() ;
        for(char ch : s.toCharArray()){
            if(stack.size() == 0 ){
                stack.add((int)ch - '0') ;
            }
            else{
                int prev = stack.peek() ;
                int curr = ch - '0' ;
                
                if((curr == 1 && prev == 2) || (curr == 2 && prev == 1) ){
                    stack.pop() ;
                    continue ;
                }
                
                if((curr == 3 && prev == 4) || (curr == 4 && prev == 3) ){
                    stack.pop() ;
                    continue ;
                }
                
                if((curr == 5 && prev == 6) || (curr == 6 && prev == 5) ){
                    stack.pop() ;
                    continue ;
                }
                
                if((curr == 7 && prev == 8) || (curr == 8 && prev == 7) ){
                    stack.pop() ;
                    continue ;
                }
                
                if((curr == 0 && prev == 9) || (curr == 9 && prev == 0) ){
                    stack.pop() ;
                    continue ;
                }

                stack.push(curr) ;
            }
        }

        return stack.size();
    }
}
