package Stack_and_Queue;
import java.util.* ;
public class Q40_Design_Hit_Counter {

    static class HitCounter {

        /** Initialize your data structure here. */
        ArrayDeque<Integer> q ;
        public HitCounter() {
            q = new ArrayDeque<>() ;
        }
    
        /** Record a hit.
            @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            q.add(timestamp) ; // adding to queue
            int start = timestamp - 300 + 1 ; // getting start value
            while(q.peek() < start) q.remove() ; // removing value which are lesser than start becuase they are useless as getHits function always comes in future and it ask for hit in timestamp - 300 + 1 range so values lesser than this range will  not be counted.
        }
    
        /** Return the number of hits in the past 5 minutes.
            @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int start = timestamp - 300 + 1 ;
            while(q.peek() < start) q.remove() ;
          return q.size();
        }
      }
    
}
