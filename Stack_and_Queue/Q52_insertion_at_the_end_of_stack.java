package Stack_and_Queue;

import java.util.Stack;

public class Q52_insertion_at_the_end_of_stack {

    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<>() ;
        for (int i = 0; i < 10; i++) {
            st.push(i) ;
        }


        System.out.println(st);
        pushToTheEnd(st,20) ;
        System.out.println(st);
    }

    private static void pushToTheEnd(Stack<Integer> st, int i) {

        if (st.size() == 0) { /// if size beomes zero then push the desired element.
            st.push(i) ;
            return ;
        }

        int x = st.pop() ; // else backup the current element 

        pushToTheEnd(st, i); // and call the function

        st.push(x) ; // now at the returning time push back the backup element.
    }
    
}
