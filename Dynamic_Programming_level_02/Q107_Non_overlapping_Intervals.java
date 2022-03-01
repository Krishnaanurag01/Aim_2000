package Dynamic_Programming_level_02;
import java.util.*;

public class Q107_Non_overlapping_Intervals {

    // method - 01 
    // time comp : O(n2)
    public int eraseOverlapIntervals(int[][] in ) {
        
        Arrays.sort(in, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0] ;
            }
            else{
                return a[1] - b[1] ;
            }
        }) ;
        
        int n = in.length ;
        
        int[] dp = new int[n] ;
        int ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            int max = 0 ;
            for(int j = 0 ; j < i ; j++){
                if(in[j][1] <= in[i][0]){
                    max  = Math.max(max, dp[j]) ;
                }
            }
            dp[i] = max + 1 ;
            ans = Math.max(ans,dp[i]) ;
        }
        
        return n - ans ;
    }

    // method 02 :
    // time comp : O(n) 

    public int eraseOverlapIntervals2(int[][] in ) {
        
        // first sorting the intervals
        Arrays.sort(in, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0] ;
            }
            else{
                return a[1] - b[1] ;
            }
        }) ;
        
        int lend = in[0][1] ; // last interval end time
        int res = 0 ; // total count of conflicts

        for (int i = 1; i < in.length; i++) {
            int currStart = in[i][0] ; // current start time
            
            if(currStart >= lend){
                lend = in[i][1] ;
            }
            else{
                lend = Math.min(lend, in[i][1]) ;
                res++ ;
            }
        }
        



        return res ;
    }


    
}
