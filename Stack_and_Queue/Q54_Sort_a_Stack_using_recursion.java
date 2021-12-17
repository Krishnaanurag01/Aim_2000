package Stack_and_Queue;

import java.util.Stack;

public class Q54_Sort_a_Stack_using_recursion {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>() ;

       st.push(4) ;
       st.push(1) ;
       st.push(9) ;
       st.push(3) ;
       st.push(4) ;
       st.push(1) ;
       st.push(4) ;

        System.out.println(st);
       sortIt(st);
        System.out.println(st);
        
    }


    // same logic as Q53.


    public static void sortIt(Stack<Integer> st) {
        if (st.size() == 0) {
            return ;
        }
        int x = st.pop() ;
        sortIt(st); // first removing elements
        helper(st,x) ; // after that inserting element through helper func
    }


    private static void helper(Stack<Integer> st, int x) {
        if(st.size() == 0){ // if stack is empty then push it.
            st.push(x) ;
            return ;
        }

        if(st.peek()  > x ){ // if stacks top element is larger than current element then do backup and perform recursion 
            int m = st.pop() ;
            helper(st, x);
            st.push(m) ;
        }
        else{ // if current element is greater then insert it directly.
            st.push(x) ;
        }
    }
    
}
