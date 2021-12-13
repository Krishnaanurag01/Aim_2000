package Stack_and_Queue;
import java.util.* ;

public class Q12_Evaluation_of_Postfix_Expression {
    
    public static int evaluatePostFix(String str) {
        
        Stack<Integer> evaluate = new Stack<>() ;

        for (int i = 0; i < str.length() ; i++) {
            
            char ch = str.charAt(i) ;

            if(Character.isDigit(ch)){
             
                evaluate.push(ch - '0') ;
            }
            else{
                // operations

                // evaluating.
                int v2 = evaluate.pop() ;
                int v1 = evaluate.pop() ;
                int result = getEvaluted(v1 , v2 , ch) ;

                evaluate.push(result) ;

            }
        }




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
