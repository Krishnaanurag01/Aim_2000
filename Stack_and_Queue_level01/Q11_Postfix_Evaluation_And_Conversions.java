package Stack_and_Queue_level01 ;

import java.util.Stack;

/**
 * Q11_Postfix_Evaluation_And_Conversions
 */
public class Q11_Postfix_Evaluation_And_Conversions {

    public static void main(String[] args) {

        System.out.println(evaluatePostfix("231*+9-"));
        
    }

    public static int evaluatePostfix(String str) {
        
        Stack<String> infix = new Stack<>() ;
        Stack<String> prefix = new Stack<>() ;
        Stack<Integer> evaluate = new Stack<>() ;

        for (int i = 0; i < str.length() ; i++) {
            
            char ch = str.charAt(i) ;

            if(Character.isDigit(ch)){
                infix.push(ch + "") ;
                prefix.push(ch + "") ;
                evaluate.push(ch - '0') ;
            }
            else{
                // operations

                // evaluating.
                int v2 = evaluate.pop() ;
                int v1 = evaluate.pop() ;
                int result = getEvaluted(v1 , v2 , ch) ;

                evaluate.push(result) ;

                // infix managing.

                String infix_v2 = infix.pop() ;
                String infix_v1 = infix.pop() ;
                String infix_res =  "(" + infix_v1 + ch + infix_v2 + ")";
                infix.push(infix_res) ;


                // prefix managing.

                String prefix_v2 = prefix.pop() ;
                String prefix_v1 = prefix.pop() ;
                String prefix_res =  ch + prefix_v1 + prefix_v2 ;
                prefix.push(prefix_res) ;


            }
        }



        System.out.println(infix.peek());
        System.out.println(prefix.peek());
        System.out.println(evaluate.peek());
        return evaluate.peek() ;

    }

    private static int getEvaluted(int v1, int v2, char opr) {

        if(opr == '+'){
            return v1 + v2 ;
        }
        else if(opr == '-'){
            return v1 - v2 ;
        }
        else if(opr == '*'){
            return v1 * v2 ;

        }
        else if(opr == '/'){
            return v1 / v2 ;

        }

        return 0;
    }
}