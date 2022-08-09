package Problem_Of_The_day;
import java.util.*;

public class Q158_Implement_Queue_using_Stacks {

    class MyQueue {

        public MyQueue() {
             
         }
         
     //[[[Complexity : Amortized(worst case occurs few times only) using 2 stacks]]]
         //[[the worst case is Amortized O(1) time and O(N)space]]
         Stack<Integer> input = new Stack<Integer>();
         Stack<Integer> output = new Stack<Integer>();
         
         public void push(int x) {
             input.push(x);
         }
         
         public int pop() {
             if(output.isEmpty() == false)
                 return output.pop();
             else{
                 while(input.isEmpty() != true)
                     output.push(input.pop());
                 return output.pop();
             }
         }
         
         public int peek() {
             if(output.isEmpty() == false)
                 return output.peek();
             else{
                 while(input.isEmpty() != true)
                     output.push(input.pop());
                 return output.peek();
             }
         }
         
         public boolean empty() {
             return (output.isEmpty() && input.isEmpty());
         }
     }
     
}
