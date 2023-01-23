package Problem_Of_The_day;
import java.util.*;

public class Q344_Geeks_And_The_String {

    public static String removePair(String s) {
        Stack<Character> st = new Stack<>() ;
        
        for(char ch : s.toCharArray()){
            if(st.size() > 0 && st.peek() == ch){ // remove top char and not append current char if two adjecent char is same
                st.pop() ; 
            }
            else{ // else push it to stack.
                st.push(ch) ;
            }
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        while(st.size() > 0){ // taking out the remaining char in sb
            sb.append(st.pop()) ;
        }
        
        if(sb.length() == 0) return "-1" ; // when empty return -1
        return sb.reverse().toString() ; // otherwise return ans.(reversing it becuase the stack changed the order)
    }
}
