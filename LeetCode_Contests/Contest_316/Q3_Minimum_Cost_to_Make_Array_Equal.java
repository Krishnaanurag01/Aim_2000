package LeetCode_Contests.Contest_316;
import java.util.*;

public class Q3_Minimum_Cost_to_Make_Array_Equal {

    public long minCost(int[] nums, int[] cost) {
        
        // we can simply say it is a binary search problem but here normal binary search will not work. kyuki esme hume ye pta nhi hoga ki kab hume value larger chahiy aur kab smaller chahiy. 
        // it is based on  " CENTRAL TENDANCY ". // here we will find the median value of nums.
        
        // first make a pair array where cost is treated as freq of nums[i] so that we can find the median.
        
        Pair[] arr = new Pair[nums.length] ;
        long total_val = 0 ; // total count of element.
        
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = new Pair(nums[i], cost[i]) ;
            total_val += cost[i] ;
        }
        
        // sorting values.
        Arrays.sort(arr, (a,b) -> a.val - b.val) ;
        
        long mid = (total_val + 1) / 2 ; // mid index value
        
        int new_value = 0 ;
        for(Pair p : arr){
             mid -= p.freq ; // phle freq subtract it agar 0  ya less than ho jaye matlab ki yahi mid value h .
            if(mid <= 0) {
                new_value = p.val ;
                break; // then break
            }
           
        }
     
        long final_cost = 0 ;
        
        // ab sare element ko new_value me convert karne ka cost nikal lo except the new_value itself.
        for(Pair p : arr){
            if(p.val != new_value){ 
                // formula is : cost(freq) * (jitna subtract ya increase karna ho current value ko.)
                final_cost += (p.freq*1L*(Math.abs(p.val - new_value))) ;
            }
        }
        
        
        return final_cost ;
    }
    
    
    class Pair{
        int val ;
        int freq ;
        
        Pair(int x, int y){
            val = x ;
            freq = y ;
        }
    }
}
