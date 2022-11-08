package LeetCode_Contests.Contest_318;
import java.util.*;

public class Q2_Maximum_Sum_of_Distinct_Subarrays_With_Length_K {

    public long maximumSubarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;// it will help us in finding wheather the elements present in subarray is distinct or not. if the size of map is equal to k then it means every elememt is unique as the keys size are equal to K.
        long sum = 0 ;
        // first calculate the first subarray
        for(int i = 0 ; i < k ; i++){
            sum += (nums[i]*1L) ;
            map.put(nums[i], map.getOrDefault(nums[i],0)+1) ;
        }
        
        long ans = 0 ;
        if(map.size() == k){ // if every element is distinct then ans is sum for now.
            ans = sum ;
        }
        
        for(int i = k ; i < nums.length ; i++){
            int val = nums[i] ; 
            map.put(val, map.getOrDefault(val,0)+1) ; // now pick the current element
            
            // now remove element from left.
            int prev = nums[i - k] ;
            int freq = map.get(nums[i-k]) ;
            if(freq == 1){
                map.remove(nums[i-k]) ;
            }
            else{
                map.put(nums[i-k], freq - 1) ;
            }
            
            // and also calculating the sum parallely.
            sum += (val*1L) ;
            sum -= prev;  // and also removing the left boundary element.
            
            if(map.size() == k){
                ans = Math.max(ans, sum) ; // updating answer if all elements of window is distinct.
            }
        }
        
        return ans ;
    }
}
