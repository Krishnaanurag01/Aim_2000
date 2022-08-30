package Problem_Of_The_day;
import java.util.*;

public class Q197_Find_Right_Interval {

    public int[] findRightInterval(int[][] intervals) {
        
        // step 01 : make an array where each element has si of interval and the index of that si in interval
        int[][] pair = new int[intervals.length][2] ;
        for(int i = 0 ; i < intervals.length ; i++){
            int si = intervals[i][0] ;
            pair[i] = new int[]{si,i} ;
        }
        
        // sorting so that we can perform binary search on it.
        Arrays.sort(pair, (a,b) -> a[0] - b[0]) ;
        
        // step 02 : find the sj > ei using binary search
        int[] ans = new int[intervals.length] ;
        for(int i = 0 ; i < intervals.length ; i++){
            int ei = intervals[i][1] ;
            
            // applying binary search over pair array to find greater start than ei.
            int low = 0 ; 
            int high = intervals.length - 1;
            int pIdx = -1 ; // this is the index of ans in pair
            
            while(low <= high){
                int mid = low + (high - low)/2 ;
                if(pair[mid][0] >= ei){
                    pIdx = mid;// storing the index of element in pair.
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
             
            // now storing the original index of ans.
           ans[i] = pIdx != -1 ? pair[pIdx][1] : -1 ;
             
        }
    
        return ans ;
    }
}
