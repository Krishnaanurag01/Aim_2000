package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q17_Remove_Invalid_Parentheses {

    static List<String> ans ;
    public List<String> removeInvalidParentheses(String s) {
        
        ans = new ArrayList<>() ;
        int mr = getMin(s) ; // this is the count of total invalid count of paranthesis
        helper(s,mr,new HashSet<String>()) ;
        
        return ans ;
    }
    
    
    // this function will give the count of invalid paranthesis
    public int getMin(String s){
        
        Stack<Character> stack = new Stack<>() ;
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            
            if(ch == '('){
                stack.push(ch) ;
            }
            else if(ch == ')'){
                if(stack.size() == 0 ) {
                    stack.push(ch) ;
                }
                else if(stack.peek() == ')')
                {
                    stack.push(ch) ;
                }
                else if(stack.peek() == '(' ){
                    stack.pop() ;
                }
            }
        }
        
        return stack.size() ;
    }
    
    
    public void helper(String s, int mr, HashSet<String> set){
        
        
        if(mr == 0){ // base condition
            int arm = getMin(s) ; // getting the count of min paranthesis the is invalid
            
            if(arm == 0 && !set.contains(s)){ // if invalid and does not came before then print and add it to the set so that we will not print the same answer twice.
                ans.add( new String(s) ) ;
                set.add(s) ;
            }
            return  ;
        }
        
        for(int i = 0 ; i < s.length() ; i++){ // going through every character once
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){ // when current char is alphabet then ignore else do following
            String left = s.substring(0,i) ; // left part string
            // not adding the ith char
            String right = s.substring(i+1) ; // right part string
            helper(left+right,mr-1,set) ; // calling again with new string (that has removed the ith char) so that we can remove all the invalid character.
            }
        }
        
    }
    
}
