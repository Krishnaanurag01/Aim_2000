package Stack_and_Queue_level01;

import java.util.Scanner;
import java.util.Stack;

public class Q8_Infix_Evaluation {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner( System.in ) ;

        String str = sc.nextLine() ;

        Stack<Integer> oprnd = new Stack<>() ;
        Stack<Character> oprtor = new Stack<>() ;

        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i) ;

            if (ch == '(' ) {
                oprtor.push(ch) ;
            }
            else if( Character.isDigit(ch)){
                oprnd.push(ch - '0') ;
            }
            else if(ch == ')'){

                while (oprtor.size() > 0 && oprtor.peek() != '(') {
                    
                    int v2 = oprnd.pop() ;
                    int v1 = oprnd.pop() ;
                    char opration = oprtor.pop() ;

                    int result = operations(v1, v2, opration) ;
                    oprnd.push(result) ;
                }

                oprtor.pop() ; // removing opening bracket

            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                while (oprtor.size() > 0 && oprtor.peek() != '(' && precedance(oprtor.peek()) >= precedance(ch) ) {
                    
                    int v2 = oprnd.pop() ;
                    int v1 = oprnd.pop() ;
                    char opration = oprtor.pop() ;

                    int result = operations(v1, v2, opration) ;
                    oprnd.push(result) ;
                }

                oprtor.push(ch) ;
            }
        }

        while (oprtor.size() > 0) {
                    
            int v2 = oprnd.pop() ;
            int v1 = oprnd.pop() ;
            char opration = oprtor.pop() ;

            int result = operations(v1, v2, opration) ;
            oprnd.push(result) ;
        }

        System.out.println(oprnd.peek());

    }

    public static int precedance(char c) {
        
        if(c == '+'){
            return 1;
        }
        else if( c == '-'){
            return 1 ;
        }
        else if( c == '*'){
            return 2 ;
        }
        else{
            return 2 ;
        }

    }

    public static int operations(int v1 , int v2 , char c) {
        
        if(c == '+'){
            return v1 + v2 ;
        }
        else if( c == '-'){
            return v1 - v2 ;
        }
        else if( c == '*'){
            return v1 * v2 ;
        }
        else{
            return v1 / v2 ;
        }
    
    }
    
}
