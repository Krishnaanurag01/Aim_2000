package LeetCode_Contests.BiWeekly_90;
import java.util.*;

public class Q3_Destroy_Sequential_Targets {

    public int destroyTargets(int[] nums, int space) {
        
        // this is a mathematical question : ( check bro coder solution for video solution)
        
        /*
        A + c * space = B
        C * SPACE = B - A // Now it means B - A is a multiple of SPACE.
        if c == 0 then 
        Space = B - A // and as space is a multiple of B - A THEN
        (B - A) % Space == 0 ;
        B % Space = A % Space 
        // means we have to find element with same remainder.
        
        */
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int mrc = 0 ; // max remainder count.
        
        
        // step 01 : store remainder count by diving with space
        for(int val : nums){
            int rem = val % space ;
            map.put(rem, map.getOrDefault(rem,0)+1) ;
            mrc = Math.max(mrc, map.get(rem)) ; // and also keep track of highest remainder.
        }
        
        int ans = (int)1e9 ;
        
        
        for(int val : nums){
            if(map.get(val % space) == mrc){ // now if current value gives remainder with highest count then update answer.
                ans = Math.min(ans, val) ;
            }
        }
        
        return ans ;
    }
}
