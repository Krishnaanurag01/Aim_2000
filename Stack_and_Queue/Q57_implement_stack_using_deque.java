package Stack_and_Queue;

import java.util.ArrayDeque;

public class Q57_implement_stack_using_deque {

    public static void main(String[] args) {

        push(4);
        push(5);
        push(6);
        push(8);
        push(2);

        System.out.println(pop());
        System.out.println(top());
        
    }

    static ArrayDeque<Integer> dq = new ArrayDeque<>() ;

    public static void push(int x) {
        dq.addLast(x);
    }
    public static int pop() {
        return dq.removeLast() ;
    }

    public static int top() {
        return dq.peekLast() ;
    }
    
}
