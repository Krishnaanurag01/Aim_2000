package Stack_and_Queue;
import java.util.* ;

public class Q62_Reverse_First_K_elements_of_Queue {

    public static void main(String[] args) {
        
        Queue<Integer> q = new LinkedList<>() ;

        for (int i = 1 ; i <= 5 ; i++) {
            q.add(i) ;
        }

       System.out.println( modifyQueue(q, 3)) ;

    
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        
        int n = q.size() ;
         
        Stack<Integer> st = new Stack<>() ; 

       for(int i = 0 ; i < k ; i++){
           st.push(q.remove()) ;  // adding k element to stack so  that it will give us in rverse order.
       }
        
        
        while (st.size() > 0) {
            q.add(st.pop()) ; //adding reverse to queue
        }

        for(int i = k ; i < n ; i++){
            q.add(q.remove()) ; /// adding rest of elements to queue by removing it.
        }
        
        return q;
    }
    
}
