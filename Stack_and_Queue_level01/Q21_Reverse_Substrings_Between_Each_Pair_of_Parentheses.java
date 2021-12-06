package Stack_and_Queue_level01;
import java.util.*;


public class Q21_Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public String reverseParentheses(String s) {
        
        Stack<Character> st = new Stack<>() ;
        
        for(int i = 0 ; i < s.length() ; i++ ){
            
            char ch = s.charAt(i) ;
            
            if(ch == ')'){ // when the closing bracket comes. then remove characters between opening and current and reverse it then again insert to stack without adding brakcets backet.
                
                Queue<Character> q = new LinkedList<>() ;
                
                while(st.peek() != '('){
                    q.add(st.pop()); // popping and adding to queue.
                }
                
                st.pop() ; // removing the opening bracket.
                
                // this is working as rversing the string.
                while(q.size() > 0){
                    st.push(q.remove()) ; // adding back to stack.
                }                
            }
            else{
                // pushing
                st.push(ch) ;
            }
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        while(st.size() > 0){
            sb.append(st.pop()) ; // adding to sb 
        }
        
        return sb.reverse().toString() ; // now reversing and converting to string.
        
    }
}
