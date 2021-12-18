package Problem_Of_The_day;

import java.util.Stack;

public class Q22_Reverse_each_word_in_a_given_string {

    public static void main(String[] args) {

        System.out.println( reverseWords("i.like.this.program.very.much") ) ;
        // System.out.println(helper("str"));
        
    }

    // we can solve this problem with stack.
    static String reverseWords(String s)
    {

        Stack<Character> stack = new Stack<>() ; // creating a stack
        StringBuilder sb = new StringBuilder() ; // this is used so that we can make our answer by adding char in o(1) time

        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i) ;
            if(ch != '.'){ // if it is not . then add it to the stack
                stack.push(ch) ;
            }
            else{
                while (stack.size() > 0) { // else if it is dot then pop every character and add it to the sb
                    sb.append(stack.pop()) ;
                }
                sb.append(".") ; // also add it to the sb
            }
        }

        while (stack.size() > 0) {
            sb.append(stack.pop()) ; // now adding rest of the characters.
        }

        return sb.toString() ; // returning by making the string.
    }

}
