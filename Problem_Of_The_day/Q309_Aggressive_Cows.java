package Problem_Of_The_day;
import java.util.*;

public class Q309_Aggressive_Cows {

    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls) ;
        int low = 0 ; // min gap ppossible
        int high = stalls[stalls.length - 1] - stalls[0] ; //max distance gap
        int ans = 0 ;
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            
            // check if we can allocate cow such with atleast min gap 
            if(isPossible(stalls,k,mid)){ // if yes
                ans = mid ; // then update answer
                low = mid + 1 ; // now search for higher answer
            }
            else{
                high = mid - 1 ; // else search for lower answer
            }
        }
        
        return ans ;
    }
    
    public static boolean isPossible(int[] stalls, int cows, int min_gap){
        
        int last_cow = stalls[0] ; // allocated  first cow at 0th stall
        cows--  ;
        
        for(int i = 1 ; i < stalls.length && cows > 0 ; i++){
            if(stalls[i] - last_cow >= min_gap){ // allocating next cow if the min gap between last and current is atleast min_gap
                last_cow = stalls[i] ;
                cows-- ;
            }
        }
        
        return cows == 0 ;
    }
}
