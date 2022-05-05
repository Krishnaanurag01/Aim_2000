package LeetCode_Daily;
import java.util.*;

public class Q3_Implement_Stack_using_Queues {
    
}

class MyStack {

    LinkedList<Integer> q ;  
    int top ;
    public MyStack() {
        q = new LinkedList<>() ;
        top = -1;
    }
    
    public void push(int x) {
        q.add(x) ;
        top = x ;
    }
    
    public int pop() {
        
        // removing the n-1 elements from front and adding to back of the queue , this will make the top element in front of queue and then we delete the front element.
        for(int i = 0 ; i < q.size() - 1 ; i++ ){
            int front = q.removeFirst() ;
            q.add(front) ;
            top = front ; // also updating the front.
        }    
        return q.removeFirst() ;
    }
    
    public int top() {
        return top ; // returning top
    }
    
    public boolean empty() {
        return q.size() == 0 ;
    }
}
