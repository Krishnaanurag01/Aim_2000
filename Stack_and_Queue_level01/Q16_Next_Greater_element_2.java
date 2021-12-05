package Stack_and_Queue_level01;
import java.util.*;

public class Q16_Next_Greater_element_2 {
    
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length ;
        
        Stack<Integer> stack = new Stack<>() ; 
        
        // adding element from n-2 to 0
        for(int i = n-2 ; i >= 0 ; i--){
            
            while(stack.size() > 0 && stack.peek() <= nums[i]){
                stack.pop() ;
            }
            stack.push(nums[i]) ;
        }
        
        int[] ans = new int[n] ;
        
        // now finding the answer from n-1 to 0.
        for(int i = n-1 ; i >= 0 ; i--){
            while(stack.size() > 0 && stack.peek() <= nums[i]){
                stack.pop() ;
            }
            
            ans[i] = stack.size() > 0 ? stack.peek() : -1 ;
            
            stack.push(nums[i]);
        }
        
        
        return ans ;  

    }
}
