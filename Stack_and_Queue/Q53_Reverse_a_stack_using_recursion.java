package Stack_and_Queue;

import java.util.Stack;

public class Q53_Reverse_a_stack_using_recursion {
    
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>() ;

        for (int i = 0; i < 10 ; i++) {
            st.push(i) ;
        }

        System.out.println(st);
        reverse_stack(st);
        System.out.println(st);
        
    }

    public static void reverse_stack(Stack<Integer> s) {
        
        if(s.size() == 0){
            return ;
        }

        int x = s.pop() ;
        reverse_stack(s); // here if we we wite insetfunc() before reverse then insert func will insert the popped element and rverse func will pop again and again this will give us stack overflow and loop.
        insert_At_bottom(s,x); // after removing all the element this function will insert element in the stack.
    }


    // this is same as Q52.
    public static void insert_At_bottom(Stack<Integer> s , int x) {
        
        if(s.size() == 0){
            s.push(x) ;
            return ;
        }

        int m = s.pop() ;
        insert_At_bottom(s, x);
        s.push(m) ;
    }
}
