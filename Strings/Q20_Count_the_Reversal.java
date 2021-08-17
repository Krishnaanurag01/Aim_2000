package Strings;

import java.util.Stack;

public class Q20_Count_the_Reversal {
    public static void main(String[] args) {

      System.out.println( countTheReversal("{}{{}{{{{{}}{}") );
    
    }

    public static int countTheReversal(String s) { 

        if(s.length()%2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);

            if(c == '}' && !stack.empty()){
                if(stack.peek() == '{'){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            else{
                stack.push(c);
            }
        }

        int stackLength = stack.size();

        int n = 0 ;

        while (!stack.isEmpty() && stack.peek()=='{') {
            n++;
            stack.pop();
        }


        return (stackLength/2 + n%2);



    }
}
