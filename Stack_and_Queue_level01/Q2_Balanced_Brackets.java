package Stack_and_Queue_level01;

import java.util.Scanner;
import java.util.Stack;

public class Q2_Balanced_Brackets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.size() > 0) {

                    if (ch == ')') {
                        char ch2 = stack.pop();
                        if (ch2 != '(') {
                            System.out.println(false);
                            return;
                        }
                    } else if (ch == '}') {

                        char ch2 = stack.pop();
                        if (ch2 != '{') {
                            System.out.println(false);
                            return;
                        }

                    } else if (ch == ']') {

                        char ch2 = stack.pop();
                        if (ch2 != '[') {
                            System.out.println(false);
                            return;
                        }
                    }
                }
                else if(ch == ')' || ch == '}' || ch == ']'){
                    System.out.println(false);
                    return ;
                }
            }
        }

        if (stack.size() > 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }



        sc.close(); 

    }
}
