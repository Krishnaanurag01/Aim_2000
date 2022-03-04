package Stack_and_Queue;
import java.util.*;

public class Q63_Interleave_The_First_Half_Of_The_Queue_With_The_Second_Half {


    public static void interLeaveQueue(Queue < Integer > q) { // ex : q = 1 2 3 4 5 6
        // Write your code here.
        int n = q.size()/2 ;
        Stack<Integer> st = new Stack<>() ;
        
       for(int i = 0 ; i < n; i++){ // first removing n/2 elements from q and adding to stack 
            st.push(q.poll()) ;  // st : 3 2 1 (top -> bottom)
        }
        
        while(st.size() > 0){ // now adding all elements back to q
            q.add(st.pop()) ; 
        }                                                     // q : 4 5 6 3 2 1
        
        for(int i = 0 ; i < n; i++){  // now removing the n/2 elements and adding to the same queue
            q.add(q.remove()) ;
        }  // after this queue will look like this : >  // q : 3 2 1 4 5 6 
        
        for(int i = 0 ; i < n; i++){ // again adding n/2 elements to stack
            st.push(q.poll()) ;
        } // q : 4 5 6 and st : 1 2 3 (top -> bottom)
        
        // now doing interleave by adding one element of stack to que and one element of queue to queue
        while(st.size() > 0 ){
            q.add(st.pop());
            q.add(q.poll());
        }
        

        // now q : 1 4 2 5 3 6
    }
    
}
