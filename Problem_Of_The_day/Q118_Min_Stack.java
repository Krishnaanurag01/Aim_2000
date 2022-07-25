package Problem_Of_The_day;
import java.util.*;

class MinStack {
    // takes O(2n) space complexity
    Stack<int[]> stack ; // 0th index -> value , 1st index -> min value till now.

    public MinStack() {
        stack = new Stack<>() ;
    }
    
    public void push(int val) {
        if(stack.size() > 0){
            stack.push(new int[]{val, Math.min(stack.peek()[1], val)}) ;
        }
        else{
            stack.push(new int[]{val,val});
        }
    }
    
    public void pop() {
        stack.pop() ;
    }
    
    public int top() {
       return stack.peek()[0] ;
    }
    
    public int getMin() {
        return stack.peek()[1] ;
    }
}
