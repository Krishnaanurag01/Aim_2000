package Stack_and_Queue_level01;
import java.util.*;

public class Q22_Minimum_Remove_to_Make_Valid_Parentheses {
    
    public String minRemoveToMakeValid(String s) {
        
        char[] str = s.toCharArray() ;
        Stack<Integer> stack = new Stack<>() ;
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            
            char ch = s.charAt(i) ;
            
            if(ch == '('){
                stack.push(i) ;
            }
            else  if(ch == ')'){
                if(stack.size() == 0){
                    str[i] = '.' ;
                }
                else{
                    
                    stack.pop() ;
                }
            }
            
        }
        
        
        while( stack.size() > 0 ) {
            str[stack.pop()] = '.' ;
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        for(char c : str){
            if( c != '.'){
                sb.append(c) ;
            }
        }
        
        return sb.toString() ;
        
    }
}
