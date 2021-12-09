package Stack_and_Queue_level01;
import java.util.* ;

public class Q28_Trapping_rain_water {

    public int trap(int[] height) {
        
        Stack<Integer> stack = new Stack<>() ;
        int ans = 0 ;
        
        for(int i = 0 ; i < height.length; i++){
            
            // check if current element could become the right max of stack.peek element 
            while(stack.size() > 0 && height[stack.peek()] <= height[i]){ // if current element height is greater than stacks element height then current element is right max for stacks element
                
                int rm = i ; // right  max
                int current_height = height[stack.pop()]; // stack element height
                if(stack.size() == 0) break ; // is stack become empty after popping one elemet then break directly as it doesn't contain left max.
                
                int lm = stack.peek() ; // left max
                
                int width = rm - lm - 1 ; // finding the distance between left max tower and right max tower.
                
                ans += (Math.min( height[rm] , height[lm] ) - current_height ) * width ; // we chose the min height tower and subtract current building height then we multiply with width and add it to the answer.
                
                
            }
            
            stack.push(i) ;       // now adding current element to the stack.
        }
        
        
        return ans ;
        
    }
    
}
