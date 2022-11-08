package Problem_Of_The_day;
import java.util.*;

public class Q282_Make_The_String_Great {

    public String makeGood(String s) {
        
        Stack<Character> st = new Stack<>() ;
        
        for(char ch : s.toCharArray()){
            
            if(st.size() == 0){ // when stack is empty then push and skip
                st.push(ch) ;
                continue ;
            }
            
            // check if current and prev char is same but the case is different  then remove both 
            if(Character.isLowerCase(ch) && Character.isUpperCase(st.peek()) && ch == Character.toLowerCase(st.peek())){
                st.pop() ;
            }
            else if(Character.isUpperCase(ch) && Character.isLowerCase(st.peek()) && ch == Character.toUpperCase(st.peek())){
                st.pop() ;
            }
            else{
                st.push(ch) ; // otherwise just push the current char.
            }
            
        }
        
        StringBuilder sb = new StringBuilder() ;
        while(st.size() > 0){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString() ;
    }
}
