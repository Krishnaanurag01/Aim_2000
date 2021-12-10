package Stack_and_Queue_level01;

import java.util.Stack;

public class Q34_Basic_Calculator_II_ {

    // kinda similar to previous question.

    public int calculate(String s) {
     
        int sum = 0 ;
        char sign = '+' ;

        Stack<Integer> st = new Stack<>() ;

        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i) ;

            if (Character.isDigit(ch)) { // find whole digit
                int val = 0 ;

                while (i < s.length() && Character.isDigit(  s.charAt(i) - '0' )) {

                    val = val * 10 + (s.charAt(i) - '0');
                    i++ ;
                }

                i-- ;

                if(sign == '+'){ // if sign + or - then add val with the same sign.
                    st.push(val) ;
                }
                else if(sign == '-')
                {
                    st.push(-val) ;
                }
                else if(sign == '*'){ // else if it is * or / the fetch last value from stack do operations and push new value.

                    val *= st.pop() ;
                    st.push(val) ; 

                }
                else if(sign == '/'){

                    val = st.pop() / val ;
                    st.push(val) ;

                }
            }
            else if(ch != ' '){ // if it is not white space then it must be sign so store it in sign variable.
                sign = ch ;
            }
        }
        
        while(st.size() > 0){ // now adding all values.
            sum += st.pop() ;
        }
        


        return sum ;
    }
    
}
