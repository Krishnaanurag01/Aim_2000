package LeetCode_Contests.Contest_315;
import java.util.*;

public class Q4_Count_Subarrays_With_Fixed_Bounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        TreeSet<Integer> min_list = new TreeSet<>() ; // here storing every minK indexes
        TreeSet<Integer> max_list = new TreeSet<>() ; // storing every maxK indexes
        
        for(int i = 0 ; i < nums.length ; i++){
            int val = nums[i] ;
            if(val == minK){
                min_list.add(i) ;
            }
            
            if(val == maxK){
                max_list.add(i) ;
            }
        }
        
        // adding n so that when we call for ceil value it will give me n not null.
        min_list.add(nums.length) ;
        max_list.add(nums.length) ;
        
        long ans = 0; 
        
        for(int i = 0 ; i < nums.length ; i++){
            
            if(nums[i]  < minK || nums[i]  > maxK) continue ; // if current value is lesser or greater than min and max then skip.
            
            // now l is left boundary of subarray
            int l = i ; // left boundary
            
            // and finding right boundary of subarray such that every value is in range.
            while(i < nums.length && nums[i] >= minK && nums[i] <= maxK){
                i++ ;
            }
            i-- ;
            int r = i ; // right boundary
            
            
            int last = l - 1 ;  // last min or max encountered
            for(int m = l ; m <= r ; m++){
                int val = nums[m] ;
                
                if(val == minK){ // if current is min
                    int max_idx = max_list.ceiling(m) ; // then find the index of max that lies in between m and right boundary.
                    if(max_idx > r) continue ; // if it is out of boundary then skip
                    
                    int left_count = m - last ; // eska matlab humara subarray left me kha kha se start ho sakta toh left boundary se lekr min index tak sare value starting point ho saktey becuase enke bich me dono min and max lie karenge.
                    
                    int right_count = r - max_idx + 1 ; // this count mena humara subarray kha kha par khatam ho sakta toh max index se right boundary tak har element pr ye khatam ho sakta.
                    ans = ans + (left_count * right_count) ; // so this is count A*B
                    last = m ;
                }
                else if(val == maxK){ // if current is max
                    // same as above but with max case.
                    int min_idx = min_list.ceiling(m) ;
                    if(min_idx > r) continue ;
                    int left_count = m - last ;
                    int right_count = r - min_idx + 1 ;
                    ans = ans + (left_count * right_count) ;
                    last = m ;
                }
            }
        }
        
        
        
        return ans ;
    }
}
