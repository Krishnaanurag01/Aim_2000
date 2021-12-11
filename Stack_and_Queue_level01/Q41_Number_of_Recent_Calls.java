package Stack_and_Queue_level01;
import java.util.*; 

// same as Q40.
public class Q41_Number_of_Recent_Calls {
    
    class RecentCounter {

        ArrayDeque<Integer> dq  ;
        
        public RecentCounter() {
            dq = new ArrayDeque<>() ;
        }
        
        public int ping(int t) {
            dq.add(t) ;
            int min = t - 3000 ;
            while(dq.peek() < min) dq.remove() ;
            
            return dq.size() ;
        }
    }
}
