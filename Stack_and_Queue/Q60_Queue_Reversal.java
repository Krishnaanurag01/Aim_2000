package Stack_and_Queue;
import java.util.* ;

public class Q60_Queue_Reversal {



    /// method 01 : using stack 

    // public Queue<Integer> rev(Queue<Integer> q){
    //     //add code here.
    //     Stack<Integer> st = new Stack<>() ;
        
    //     while(q.size() > 0){
    //         st.push(q.remove()) ;
    //     }
         
    //     while(st.size() > 0 ) q.add(st.pop()) ;
        
    //     return q ;
    // }



    // method 02 : using recursion.

    private void reverseIt(Queue<Integer> q) {
        if(q.size() == 0){
            return ;
        }

        int x = q.poll() ;
        reverseIt(q) ;
        addToBottom(q,x) ;
    }

    private void addToBottom(Queue<Integer> q, int x) {
            q.add(x) ;
    }    
}
