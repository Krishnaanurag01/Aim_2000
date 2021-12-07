package Stack_and_Queue_level01;
import java.util.* ;

public class Q24_132_Pattern {
    public boolean find132pattern(int[] nums) {
        
        int[] min = new int[nums.length] ;
        min[0] = nums[0] ; // min for first number is itself.
        
        for(int i = 1 ; i < nums.length ; i++ ){
            min[i] = Math.min(nums[i] , min[i-1]) ; // finding min
        }
        
        Stack<Integer> stack = new Stack<>() ;
        
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            
            while(stack.size() > 0 && stack.peek() <= min[i]) stack.pop() ; // if stack element is less than or equal to our min number then pop
            
            // if theres any element left in stack and that element is smaller than nums[i] and greater than min[i] then we found the pattern so return true.
            if(stack.size() > 0 && stack.peek() < nums[i]){
                return true ;
            }
            stack.push(nums[i]) ; // adding values to stack afterwards.
        }
    
        return false ;
    }
}
