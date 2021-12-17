package Stack_and_Queue ;
import java.util.*;
/**
 * Q58_Queue_using_stack
 */
public class Q58_Queue_using_stack {

    Stack<Integer> input = new Stack<Integer>(); 
    Stack<Integer> output = new Stack<Integer>(); 
    
    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
        if(input.size() == 0 ) return -1 ;

        while (input.size() > 1) { // getting all values except first value as it will be output in case of queue(fifo) .
            output.push(input.pop()) ;
        }

        int x = input.pop() ; // this is the value we need to return

        // storing all value back to input stack
        while (output.size() > 0) {
            input.push(output.pop()) ;
        }

        return x ;
    }
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	    input.push(x) ;
    }
}