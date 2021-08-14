package Strings;

import java.util.Stack;

public class Q15_Parenthesis_Checker {
    public static void main(String[] args) {
        System.out.println(checkParenthesis("[()]{}{[()()]()}"));
        
    }

    public static boolean checkParenthesis(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                else{

                    if(s.charAt(i) == ']' && stack.peek() !='['){
                        return false;
                    }
                    else if(s.charAt(i) == '}' && stack.peek() !='{'){
                        return false;
                    }
                    else if(s.charAt(i) == ')' && stack.peek() !='('){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }

        if(!stack.empty()){
            return false;
        }
        





        return true;
    }
}
