package Stack_and_Queue_level01;
import java.util.* ;

public class Q39_Check_If_Word_Is_Valid_After_Substitutions {

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>() ;
        
        for(int i = 0 ; i < s.length()  ; i++ ){
            char ch = s.charAt(i) ; // getting char
            
            if(ch == 'c'){ // if it is c then check whether stack has previous element as b and previous of previous element as a. then continue else return directly false.
                if(stack.size() >= 2 && stack.pop() =='b' && stack.pop() == 'a' ){
                   
                }
                else{
                    return false ;
                }
            }
            else{ // if a and b comes then put into stack .
                stack.push(ch) ;
            }
        }
        
        
        return stack.isEmpty() ;
        
    }
    
}
