package Stack_and_Queue_level01;

import java.util.Stack;

public class Q19_Remove_Outermost_Parentheses {

    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                if (stack.isEmpty()) { // when stack is empty then only adding to the stack becuase it would be our outer most boundries.
                    stack.push(ch);
                } else {
                    // else adding in both stack and sb
                    stack.push(ch);
                    sb.append(ch);
                }
            } else {
                if (stack.peek() == '(') {
                    if (!stack.isEmpty()) {
                        // then it's not our outer most so add it to the answer.
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }

}
