package Stack_and_Queue_level01;

import java.util.Stack;

public class Q37_Max_Stack {

    public static class MaxStack {


        Stack<Integer> data , max ; 

        public MaxStack() {
            data = new Stack<>() ;
            max = new Stack<>() ;
        }
    
        public void push(int x) {
            data.push(x) ;
            int m = x ;

            if(max.size() > 0 ) m = Math.max(m, max.peek()) ;

            max.push(m) ; // storing max value 
    
        }
    
        public int pop() {
            max.pop() ;
          return data.pop();
        }
    
        public int top() {
          return data.peek();
        }
    
        public int peekMax() {
          return max.peek();
        }
    
        public int popMax() {

            int mvsf = max.peek() ; // max value so far.

            Stack<Integer> buffer = new Stack<>() ;

            while (data.peek() != mvsf) {

                buffer.push( pop()  ) ; // popping and pushing to buffer for backup
            }

            pop() ; // this is max element that we need to return


            while (buffer.size() > 0) { // returning all backup values back to where it belongs.
                push(buffer.pop());
            }

          return mvsf;
        }
    
      }
    
}
