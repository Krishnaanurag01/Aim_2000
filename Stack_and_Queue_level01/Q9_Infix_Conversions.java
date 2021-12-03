package Stack_and_Queue_level01;

import java.util.Stack;

public class Q9_Infix_Conversions {


    public static void main(String[] args) {
        infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
    }

    public static String infixToPostfix(String exp) 
	{

        Stack<String> prefix = new Stack<>() ;
        Stack<String> postfix = new Stack<>() ;
        Stack<Character> opr = new Stack<>() ; // operations

        for (int i = 0; i < exp.length() ; i++) {
            
            char ch = exp.charAt(i) ;

            if(ch == '('){
                opr.push(ch) ;
            }
            else if(ch == ')'){

                while (opr.peek() != '(') {
                    
                    char operator = opr.pop() ;

                    String val2 = prefix.pop() ;
                    String val1 = prefix.pop() ;
                    String pre_val = operator+val1+val2 ;
                    prefix.push(pre_val) ;

                    String val2_post = postfix.pop() ;
                    String val1_post = postfix.pop() ;
                    String post_val = val1_post+val2_post+operator ;
                    postfix.push(post_val) ;
                }

                opr.pop() ;

            }
            else if( (ch >= '0' && ch <= '9' ) || (ch >= 'a' && ch <= 'z' ) || (ch >= 'A' && ch <= 'Z') ){

                prefix.push(ch+"") ;
                postfix.push(ch+"") ;

            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(opr.peek()) >= getPrecedence(ch)) {

                    char operator = opr.pop() ;

                    String val2 = prefix.pop() ;
                    String val1 = prefix.pop() ;
                    String pre_val = operator+val1+val2 ;
                    prefix.push(pre_val) ;

                    String val2_post = postfix.pop() ;
                    String val1_post = postfix.pop() ;
                    String post_val = val1_post+val2_post+operator ;
                    postfix.push(post_val) ;

                    
                }

                opr.push(ch) ;

            }
            
        }

        while (opr.size() > 0) {
                    
            char operator = opr.pop() ;

            String val2 = prefix.pop() ;
            String val1 = prefix.pop() ;
            String pre_val = operator+val1+val2 ;
            prefix.push(pre_val) ;

            String val2_post = postfix.pop() ;
            String val1_post = postfix.pop() ;
            String post_val = val1_post+val2_post+operator ;
            postfix.push(post_val) ;
        }



        System.out.println(prefix.peek());
        System.out.println(postfix.peek());

        return "" ;
	} 


    public static int getPrecedence(char opr) {
        
        if(opr == '+' || opr == '-'){
            return 1 ;
        }
        else {
            return 2 ; // returning 2 for / and * .
        }
    }
    
}
