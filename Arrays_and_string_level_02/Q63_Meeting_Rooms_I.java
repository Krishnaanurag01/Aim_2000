package Arrays_and_string_level_02;
import java.util.*;

public class Q63_Meeting_Rooms_I {

    public static boolean meetingRooms(int intervals[][]){
       
        if(intervals.length == 0) return true ;


        // sorting based on the start time.
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]) ;
        
        int lastEnd = intervals[0][1] ; // taking information about last interval end time.
        
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] < lastEnd){ // if new interval comes before the end of the last interval then return false
                return false ;
            }
            else{ // else update the lastEnd interval with current interval end time.
                lastEnd = intervals[i][1] ;
            }
        }
        
        return true ;
    }
    
}
