package Problem_Of_The_day ;
import java.util.*;

public class Q225_Divide_Intervals_Into_Minimum_Number_of_Groups {
    
    public int minGroups(int[][] intervals) {
        
        // first sort the array based on left value when left is not same otherwise sort on right.
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1] ) ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>() ; // here we will store the right value of every interval group.
        
        for(int[] in : intervals){
            int left = in[0] ;
            int right = in[1] ;
            
            // when the peek value is less than current left then it means we can add current interval in that group so remove the old right of that group and add current right for interval.
            if(pq.size() > 0 && pq.peek() < left){
                pq.poll() ;
                // pq.add(right) ;
            }
            
            // otherwise just add the right of current interval. it will denote new group and extension of existing group.
            pq.add(right) ;
        }
        
        return pq.size() ;
    }
}
