package Stack_and_Queue_level01;
import java.util.*;

public class Q35_Find_the_Most_Competitive_Subsequence {
    
    public int[] mostCompetitive(int[] nums, int k) {
        
        int n = nums.length ; 
        
        Stack<Integer> stack = new Stack<>() ;
        
        for(int i = 0 ; i < n ; i++){
            int val = nums[i] ; // getting current value.

            // n - i - 1 == > remaining elements in nums array after the current element
            // k - stack.size() == > required elements.
            while(stack.size() > 0 && stack.peek() > val && n - i - 1 >= k - stack.size()){
                stack.pop() ;
            }
            if(stack.size() < k){ // if stack doesn't contain k elements then push current element.
                stack.push(val) ;
            }
        }
        
        // storing in ans array.
        int[] ans = new int[stack.size()] ;
        
        int i = ans.length - 1 ;
        
        while(i >= 0) ans[i--] = stack.pop() ;
        
        return ans ;
    }

}
