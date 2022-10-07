package Problem_Of_The_day;
import java.util.*;

public class Q244_My_Calendar_III {

    class MyCalendarThree {
    
        TreeMap<Integer,Integer> map ;
        public MyCalendarThree() {
            map = new TreeMap<>() ;
        }
        
        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start,0) + 1) ; // adding 1 at start denotes an event arrives.
            map.put(end, map.getOrDefault(end,0) - 1) ; // this denotes an event over
            
            int max_booking = 0 ;
            int active_booking  = 0 ;
            
            for(int event : map.values()){
                active_booking += event ;
                max_booking = Math.max(active_booking, max_booking) ;
            }
            
            // returning max booking till now.
            return max_booking ;
        }
    }  
}
