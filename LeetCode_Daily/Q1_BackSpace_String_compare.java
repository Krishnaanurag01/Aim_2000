package LeetCode_Daily; 
import java.util.*;

public class Q1_BackSpace_String_compare {


    // taking O(n) space.
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> st = new Stack<>() ;
        
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(st.size() > 0)
                    st.pop();
            }
            else{
                st.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder() ;
        for(char ch : st)
            sb.append(ch);
        
        st = new Stack<>() ;
        
        for(char ch : t.toCharArray()){
            if(ch == '#'){
                if(st.size() > 0)
                    st.pop();
            }
            else{
                st.push(ch);
            }
        }
        
        StringBuilder sb2 = new StringBuilder() ;
        for(char ch : st)
            sb2.append(ch);
        
        System.out.println("sb : " + sb +" sb2 : " + sb2) ;
        
        
        return sb.toString().equals(sb2.toString()) ;
    }

    

    // method - 02 : using only StringBuilder.

    public boolean backspaceCompare2(String s, String t) {
        
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1) ;
            }
            else{
                sb.append(ch) ;
            }
        }
        
        StringBuilder sb2 = new StringBuilder();
        for(char ch : t.toCharArray()){
            if(ch == '#'){
                if(sb2.length() > 0)
                    sb2.deleteCharAt(sb2.length()-1) ;
            }
            else{
                sb2.append(ch) ;
            }
        }
        
        return sb.toString().equals(sb2.toString()) ;
    }
    
}