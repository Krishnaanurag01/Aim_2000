package Stack_and_Queue;

import java.util.*;

public class Q68_Stack_Permutations {
    public static int isStackPermutation(int n, int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int p = 0;

        for (int i = 0; i < popped.length; i++) {
            stack.push(pushed[i]);
            while (stack.size() > 0 && stack.peek() == popped[p]) {
                stack.pop();
                p++;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
