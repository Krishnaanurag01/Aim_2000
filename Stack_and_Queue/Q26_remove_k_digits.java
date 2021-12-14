package Stack_and_Queue;

import java.util.*;

public class Q26_remove_k_digits {

    public static void main(String[] args) {

        System.out.println(removeKdigits("1432219", 3));
    }

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            char ch = num.charAt(i);

            // if stack has bigger element then remove until k becomes 0.
            while (stack.size() > 0 && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        // if k still doesn't become 0 then pop from array
        while (k > 0) {

            stack.pop();
            k--;
        }


        // now making an  array for rest of string

        char[] ans = new char[stack.size()];

        for (int i = ans.length - 1; i >= 0; i--) {

            ans[i] = stack.pop();

        }



        // this will d check and remove the leading 0 for ex : 00543
        int d = 0;

        while (d < ans.length && ans[d] == '0') {
            d++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = d; i < ans.length; i++) { /// adding answer to sb
            sb.append(ans[i]);
        }

        if (sb.length() == 0) // if sb is 0 then it means all elements must have been 0 so add 0 to sb and return
            sb.append(0);

        return sb.toString();


    }

}
