package Stack_and_Queue_level01 ;
import java.util.*;

// using sliding window technique.
public class Q42_Moving_Average_From_Data_Stream {

    public static class MovingAverage {
      
        ArrayDeque<Integer> dq ;
        int s ;
        double sum ;
          
        public MovingAverage(int size) {
            dq = new ArrayDeque<>() ;
            s = size ;
        }
    
        public double next(int val) {
            sum += val ;
            dq.add(val) ;
            if(dq.size() > s)
            {
              sum -= dq.remove() ;
            }
            
            double avg = sum / dq.size() ;
            
            
            return avg ;
        }
      }
}