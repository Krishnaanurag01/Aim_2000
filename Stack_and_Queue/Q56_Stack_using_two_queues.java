package Stack_and_Queue;
import java.util.* ;

public class Q56_Stack_using_two_queues {

    public static void main(String[] args) {
        
    }


    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    q1.add(a) ;
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here

        if(q1.size() == 0 ) { // if empty then return -1.
            return -1 ;
        }

	    while (q1.size() > 1 ) { // remove all element except the last element. as this last element will be the element which is added at last so this will be top for stack
            q2.add(q1.poll()) ;
        }

        int x = q1.poll() ; // now getting the last element.

        q1 = q2 ; // making q1 = q2
        q2 = new LinkedList<>() ; // and giving q2 = new space ;


        return x ;
        
    }
	
    
}
