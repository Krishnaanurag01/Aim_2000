package Stack_and_Queue;
import java.util.* ;

public class Q50_Reverse_a_string_using_Stack  {

    public String reverse(String S){
        //code here
        Stack<Character> st = new Stack<>() ;
        for(int i = 0 ; i < S.length() ; i++){
            char ch = S.charAt(i) ;
            st.push(ch) ; // adding to stack
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        while(st.size() > 0 ) sb.append(st.pop() ) ; // adding to sb by removing from sb.
        
        return sb.toString();
    }
    
}
