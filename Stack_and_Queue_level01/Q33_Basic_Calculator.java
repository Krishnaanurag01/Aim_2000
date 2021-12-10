package Stack_and_Queue_level01;

import java.util.Stack;

public class Q33_Basic_Calculator {

    public int calculate(String s) {
     

        int sum = 0 ;
        int sign = 1 ; // this will denotes positive or negative signs

        Stack<Integer> st = new Stack<>() ;

        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i) ;

            if(Character.isDigit(ch)){ // if current char is digit then it may be possible that It's a number larger than 9 ( ex 43)

                int val = 0 ; // getting value
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    
                    val = val*10 + (s.charAt(i) - '0' ) ;
                    i++ ;
                }

                i--; // decrementing because for loop will also increment i by 1 by the end of this iteration.

                val = val * sign ; // multiplying extracted value with previous sign.

                sum += val ; // adding to sum

                sign = 1 ; // resetting sign

            }
            else if(ch == '('){ // if it is open bracket the.

                st.push(sum) ; // push sum and sign in stack and reset both to 0 and 1.
                st.push(sign) ;

                sum = 0 ;
                sign = 1 ;

            }
            else if(ch == ')'){

                sum = sum* st.pop() ; // multiplying with sign (this  sign is belongs to outside of bracket).
                sum += st.pop() ; // adding pevious value(value outside of bracket).

            }
            else if(ch == '-'){ //if - comes then multiply the sign by -1.
                sign *= -1 ;
            }
        }
    

        // returning sum.
        return sum ;
    }
    
}
