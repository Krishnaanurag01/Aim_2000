package Problem_Of_The_day;
import java.util.*;

public class Q329_Maximum_Profit_By_Choosing_A_Subset_Of_Intervals {

    static Integer[] dp ;
    public static int maximum_profit(int n, int[][] intervals) {
       
       // sort on starting index.
       Arrays.sort(intervals, (a,b) ->{
           if(a[0] != b[0]) return a[0] - b[0] ;
           return a[1] - b[1] ; // when si same then sort on ei
       });
       
       dp = new Integer[n] ;
       return helper(0,intervals);
    }
    
    static int helper(int idx, int[][] intervals){
        
        if(idx >= intervals.length) return 0 ;
        if(dp[idx] != null) return dp[idx] ; // if already solved then return
        
        int np = helper(idx+1, intervals) ; // not picked move forward
        int p = intervals[idx][2] ; // picked.
        int ans = Math.max(np,p) ;
        
        
        // using binary search for finding the next interal where the si is greater/equal than current ei
        int low = idx + 1 ;
        int high = intervals.length - 1 ;
        int next = -1;
        
        while(low <= high){
            int mid = low +(high - low)/2 ;
            
            if(intervals[mid][0] >= intervals[idx][1]){
                next = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }
        
        if(next != -1){ // if found next interval use it with the pick
            ans = Math.max(ans, p + helper(next, intervals)) ;
        }
        
        
        return dp[idx] = ans ; // memoize.
    }
}


