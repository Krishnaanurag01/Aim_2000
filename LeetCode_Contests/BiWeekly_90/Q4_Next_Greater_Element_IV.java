package LeetCode_Contests.BiWeekly_90;
import java.util.*;

/**
 * Q4_Next_Greater_Element_IV
 */
public class Q4_Next_Greater_Element_IV {

    public int[] secondGreaterElement(int[] nums) {
        
        Stack<Integer> st = new Stack<>() ;
        int[] ngre = new int[nums.length] ;
        
        // first find the next greater of every index.
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int val = nums[i] ;
            
            while(st.size() > 0 && nums[st.peek()] <= val){
                st.pop() ;
            }
            
            if(st.size() == 0){
                ngre[i] = nums.length ;
            }
            else{
                ngre[i] = st.peek() ;
            }
            
            st.push(i) ;
        }
        
        
        int[] ans = new int[nums.length] ;
        
        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = -1 ;
            
            // now take the next greater values index of current element
            int next = ngre[i] ;
           
            
            if(next <= nums.length - 2){ // now we have to search for next greater of curr so we will search after next index.for second greater
                int second = next + 1 ; // so this is starting index where we will begin our search
                while(second < nums.length && nums[second] <= nums[i]){ // if less or equal then 
                    second = ngre[second] ; // go its next greater
                }
                
                if(second < nums.length){ // if this index is in range means we have found it sucessfullly
                    ans[i] = nums[second] ;
                }
            }
        }
        
        
        return ans ;
    }
}